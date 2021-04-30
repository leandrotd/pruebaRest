package es.leandro.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService cliServ;
	
	@GetMapping("/clientes")
	public List<Cliente> indes(){
		return cliServ.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente mostrar(@PathVariable Long id) {
		return cliServ.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente agregar(@RequestBody Cliente cli) {
		return cliServ.save(cli);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente modificar(@RequestBody Cliente cli, @PathVariable Long id) {
		Cliente act = cliServ.findById(id);
		
		act.setApellido(cli.getApellido());
		act.setEmail(cli.getEmail());
		act.setNombre(cli.getNombre());
		
		return cliServ.save(act);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable Long id) {
		cliServ.delete(id);
	}
}
