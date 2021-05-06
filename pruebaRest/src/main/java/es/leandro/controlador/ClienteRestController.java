package es.leandro.controlador;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.leandro.modelo.entity.Cliente;
import es.leandro.modelo.entity.Region;
import es.leandro.modelo.sevices.IClienteService;
import es.leandro.modelo.sevices.IUploadFileService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService cliServ;

	@Autowired
	private IUploadFileService uplServ;

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return cliServ.findAll();
	}

	@GetMapping("/clientes/pag/{page}")
	public Page<Cliente> index2(@PathVariable Integer page) {
		return cliServ.findAll(PageRequest.of(page, 4));
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id) {
		Cliente cli = null;

		Map<String, Object> response = new HashMap<>();

		try {
			cli = cliServ.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al obtener el cliente con ID: ".concat(id.toString()));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cli == null) {
			response.put("mensaje",
					"El cliente con ID: ".concat(id.toString()).concat(" no existe en la base de datos."));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cliente>(cli, HttpStatus.OK);
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> agregar(@Valid @RequestBody Cliente cli, BindingResult result) {
		Map<String, Object> response = new HashMap<>();

		Cliente cliNew = null;

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "'" + err.getField() + "': " + err.getDefaultMessage()).collect(Collectors.toList());

			response.put("mensaje", "Error agregar el cliente");
			response.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			cliNew = cliServ.save(cli);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error agregar el cliente");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (cliNew == null) {
			response.put("mensaje", "El cliente no se puede agregar a la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("cliente", cliNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> modificar(@Valid @RequestBody Cliente cli, BindingResult result, @PathVariable Long id) {
		Cliente act = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "'" + err.getField() + "': " + err.getDefaultMessage()).collect(Collectors.toList());

			response.put("mensaje", "Error modificar el cliente");
			response.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			act = cliServ.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al obtener el cliente con ID: ".concat(cli.getId().toString())
					.concat(" no existe en la base de datos."));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			act.setApellido(cli.getApellido());
			act.setEmail(cli.getEmail());
			act.setNombre(cli.getNombre());
			act.setCreateAt(cli.getCreateAt());
			act.setRegion(cli.getRegion());

			cliServ.save(act);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente con ID: ".concat(id.toString()));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		response.put("mensaje", "El cliente ha sido actualizado con éxito");
		response.put("cliente", act);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> borrar(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			Cliente cli = cliServ.findById(id);

			uplServ.eliminar(cli.getFoto());

			cliServ.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al borrar el cliente con ID: ".concat(id.toString()));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido borrado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();

		Cliente cli = cliServ.findById(id);

		if (!archivo.isEmpty()) {
			String nomArchivo = null;
			try {
				nomArchivo = uplServ.copiar(archivo);
			} catch (IOException e) {
				e.printStackTrace();
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String fotoAnterior = cli.getFoto();

			uplServ.eliminar(fotoAnterior);

			cli.setFoto(nomArchivo);

			cliServ.save(cli);

			response.put("cliente", cli);
			response.put("mensaje", "Imagen subida correctamente");
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/upload/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {
		Resource recurso = null;

		try {
			recurso = uplServ.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}

	@GetMapping("/clientes/regiones")
	public List<Region> listarRegiones() {
		return cliServ.findAllRegiones();
	}
}
