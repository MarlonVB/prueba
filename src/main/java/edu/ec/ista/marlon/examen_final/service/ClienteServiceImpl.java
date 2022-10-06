package edu.ec.ista.marlon.examen_final.service;

import edu.ec.ista.marlon.examen_final.model.Cliente;
import edu.ec.ista.marlon.examen_final.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findByAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElse(new Cliente());
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
