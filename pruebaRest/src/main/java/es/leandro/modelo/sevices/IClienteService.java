package es.leandro.modelo.sevices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.leandro.modelo.entity.Cliente;
import es.leandro.modelo.entity.Region;

public interface IClienteService {
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cli);
	
	public void delete(Long id);
	
	public List<Region> findAllRegiones();
}
