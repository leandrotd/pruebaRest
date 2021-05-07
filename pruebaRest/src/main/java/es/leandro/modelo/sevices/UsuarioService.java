package es.leandro.modelo.sevices;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.leandro.modelo.dao.IUsuarioDAO;
import es.leandro.modelo.entity.Usuario;

@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {

	@Autowired
	private IUsuarioDAO usuDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Logger logger = LoggerFactory.getLogger(UsuarioService.class);

		Usuario usu = usuDao.findByUsername(username);

		if (usu == null) {
			logger.error("El usuario " + username + " no existe.");
			throw new UsernameNotFoundException("El usuario " + username + " no existe.");
		}

		List<GrantedAuthority> authorities = usu.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(auhority -> logger.info("Role: " + auhority.getAuthority()))
				.collect(Collectors.toList());

		return new User(username, usu.getPassword(), usu.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuDao.findByUsername(username);
	}

}
