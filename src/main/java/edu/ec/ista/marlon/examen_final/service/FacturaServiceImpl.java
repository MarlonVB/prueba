package edu.ec.ista.marlon.examen_final.service;

import edu.ec.ista.marlon.examen_final.model.Factura;
import edu.ec.ista.marlon.examen_final.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public List<Factura> findByAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura crear(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura findById(Integer id) {
        return facturaRepository.findById(id).orElse(new Factura());
    }

    @Override
    public void delete(Integer id) {
        facturaRepository.deleteById(id);
    }
}
