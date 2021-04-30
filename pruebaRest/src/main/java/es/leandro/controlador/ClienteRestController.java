package es.leandro.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.leandro.modelo.entity.Cliente;
import es.leandro.modelo.sevices.IClienteServices;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteServices cliServ;
	
	@GetMapping("/clientes")
	public List<Cliente> indes(){
		return cliServ.findAll();
	}
	
}
