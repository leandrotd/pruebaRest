package es.leandro.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import es.leandro.modelo.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long> {

}
