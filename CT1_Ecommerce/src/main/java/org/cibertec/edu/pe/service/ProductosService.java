package org.cibertec.edu.pe.service;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductosService;
import org.cibertec.edu.pe.interfaces.IProductos;
import org.cibertec.edu.pe.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService implements IProductosService {

	@Autowired
	private IProductos data;

	
	@Override
	public Producto save(Producto producto) {
		return data.save(producto);
	}

	@Override
	public Optional<Producto> Buscar(String id) {
		return data.findById(id);
	}

	@Override
	public void update(Producto producto) {
		data.save(producto);
		
	}

	@Override
	public void delete(String id) {
		data.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		return data.findAll();
	}

}
