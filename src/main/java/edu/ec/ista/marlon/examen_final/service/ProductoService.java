package edu.ec.ista.marlon.examen_final.service;

import edu.ec.ista.marlon.examen_final.model.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> findByAll();

    public Producto crear(Producto persona);

    public Producto findById(Integer id);

    public void delete(Integer id);
}
