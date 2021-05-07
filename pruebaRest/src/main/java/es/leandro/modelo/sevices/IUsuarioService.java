package es.leandro.modelo.sevices;

import es.leandro.modelo.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
}
