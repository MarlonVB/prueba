package edu.ec.ista.marlon.examen_final.service;

import edu.ec.ista.marlon.examen_final.model.Producto;
import edu.ec.ista.marlon.examen_final.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<Producto> findByAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(new Producto());
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }
}
