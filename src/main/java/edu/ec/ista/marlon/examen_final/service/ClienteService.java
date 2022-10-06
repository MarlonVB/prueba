package edu.ec.ista.marlon.examen_final.service;

import edu.ec.ista.marlon.examen_final.model.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findByAll();

    public Cliente crear(Cliente cliente);

    public Cliente findById(Integer id);

    public void delete(Integer id);
}
