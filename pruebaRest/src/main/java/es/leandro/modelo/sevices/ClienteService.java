package es.leandro.modelo.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.leandro.modelo.dao.IClienteDAO;
import es.leandro.modelo.entity.Cliente;

@Service
public class ClienteService implements IClienteServices {

	@Autowired
	private IClienteDAO cliDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) cliDao.findAll();
	}

}
