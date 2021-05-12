package es.leandro.modelo.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.leandro.modelo.dao.IClienteDAO;
import es.leandro.modelo.dao.IFacturaDAO;
import es.leandro.modelo.dao.IProductosDAO;
import es.leandro.modelo.entity.Cliente;
import es.leandro.modelo.entity.Factura;
import es.leandro.modelo.entity.Producto;
import es.leandro.modelo.entity.Region;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDAO cliDao;

	@Autowired
	private IFacturaDAO factDao;

	@Autowired
	private IProductosDAO prodDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) cliDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return cliDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return cliDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cli) {
		return cliDao.save(cli);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cliDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return cliDao.findAllRegiones();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return factDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura saveFactura(Factura factura) {
		return factDao.save(factura);
	}

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		factDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Producto> findProductoByNombre(String nombre) {
		return prodDao.findByNombreContainingIgnoreCase(nombre);
	}

}
