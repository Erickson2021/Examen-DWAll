package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Producto;


public interface IProductosService {
	public Producto save( Producto producto);
	public Optional<Producto> Buscar(String id);
	public void update(Producto producto);
	public void delete(String id);
	public List<Producto> findAll();
}
