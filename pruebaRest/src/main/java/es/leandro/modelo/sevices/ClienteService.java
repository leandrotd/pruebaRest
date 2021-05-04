package es.leandro.modelo.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.leandro.modelo.dao.IClienteDAO;
import es.leandro.modelo.entity.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDAO cliDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) cliDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Cliente> findAll(Pageable pageable) {
		return cliDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		return cliDao.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cli) {
		return cliDao.save(cli);
	}

	@Override
	public void delete(Long id) {
		cliDao.deleteById(id);
	}

}
