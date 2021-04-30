package es.leandro.modelo.sevices;

import java.util.List;

import es.leandro.modelo.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cli);
	
	public void delete(Long id);
}
