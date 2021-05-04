package es.leandro.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.leandro.modelo.entity.Cliente;

public interface IClienteDAO extends JpaRepository<Cliente, Long> {

}
