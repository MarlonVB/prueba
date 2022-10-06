package edu.ec.ista.marlon.examen_final.service;

import edu.ec.ista.marlon.examen_final.model.Factura;

import java.util.List;

public interface FacturaService {

    public List<Factura> findByAll();

    public Factura crear(Factura persona);

    public Factura findById(Integer id);

    public void delete(Integer id);
}
