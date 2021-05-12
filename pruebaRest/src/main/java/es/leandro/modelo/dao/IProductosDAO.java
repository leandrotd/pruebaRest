package es.leandro.modelo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.leandro.modelo.entity.Producto;

public interface IProductosDAO extends CrudRepository<Producto, Long> {

	public List<Producto> findByNombreContainingIgnoreCase(String nombre);

}
