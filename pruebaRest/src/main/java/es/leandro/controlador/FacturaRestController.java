package es.leandro.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.leandro.modelo.entity.Factura;
import es.leandro.modelo.entity.Producto;
import es.leandro.modelo.sevices.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {
	
	@Autowired
	private IClienteService cliServ;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Factura mostrar(@PathVariable Long id) {
		return cliServ.findFacturaById(id);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura guardar(@RequestBody Factura factura) {
		return cliServ.saveFactura(factura);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar (@PathVariable Long id) {
		cliServ.deleteFacturaById(id);
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/facturas/filtrar-productos/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> filtrarProductos(@PathVariable String nombre) {
		return cliServ.findProductoByNombre(nombre);		
	}
	
}
