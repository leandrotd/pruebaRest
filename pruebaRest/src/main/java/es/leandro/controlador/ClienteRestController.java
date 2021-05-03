package es.leandro.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.leandro.modelo.entity.Cliente;
import es.leandro.modelo.sevices.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService cliServ;

	@GetMapping("/clientes")
	public List<Cliente> indes() {
		return cliServ.findAll();
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
	public ResponseEntity<?> agregar(@RequestBody Cliente cli) {
		Cliente cliNew = null;

		Map<String, Object> response = new HashMap<>();

		try {
			cliNew = cliServ.save(cli);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al guardar el cliente con ID: ".concat(cli.getId().toString()));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliNew == null) {
			response.put("mensaje", "El cliente con ID: ".concat(cli.getId().toString())
					.concat(" no se puede agregar a la base de datos."));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("cliente", cliNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> modificar(@RequestBody Cliente cli, @PathVariable Long id) {
		Cliente act = null;
		Map<String, Object> response = new HashMap<>();

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

			cliServ.save(act);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente con ID: ".concat(cli.getId().toString()));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido actualizado con éxito");
		response.put("cliente", act);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> borrar(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			cliServ.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al borrar el cliente con ID: ".concat(id.toString()));
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido borrado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
