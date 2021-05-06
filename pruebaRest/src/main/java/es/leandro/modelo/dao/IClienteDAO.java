package es.leandro.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.leandro.modelo.entity.Cliente;
import es.leandro.modelo.entity.Region;

public interface IClienteDAO extends JpaRepository<Cliente, Long> {

	@Query("from Region")
	public List<Region> findAllRegiones();
	
}
