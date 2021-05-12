package es.leandro.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import es.leandro.modelo.entity.Factura;

public interface IFacturaDAO extends CrudRepository<Factura, Long> {

}
