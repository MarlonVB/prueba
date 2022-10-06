package edu.ec.ista.marlon.examen_final.controller;

import edu.ec.ista.marlon.examen_final.model.Cliente;
import edu.ec.ista.marlon.examen_final.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/listar")
    public List<Cliente> getLista() {
        return clienteService.findByAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crear(Cliente cliente) {
        System.out.println("NOMBRE: "+cliente.getNombre());
        System.out.println("APELLIDO: "+cliente.getApellido());
        System.out.println("CEDULA: "+cliente.getTelefono());
        if (!cliente.getNombre().isEmpty() && !cliente.getApellido().isEmpty() && !cliente.getTelefono().isEmpty()) {
        return new ResponseEntity<>(clienteService.crear(cliente), HttpStatus.CREATED);
        } else {
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id,@RequestBody Cliente cliente) {
        Cliente personaActual = clienteService.findById(id);
        if (personaActual == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{

            personaActual.setNombre(cliente.getNombre());
            personaActual.setApellido(cliente.getApellido());
            personaActual.setTelefono(cliente.getTelefono());

            return new ResponseEntity<>(clienteService.crear(personaActual), HttpStatus.OK);
        }
    }

    @GetMapping("/listarID/{codigo}")
    public Cliente listarByCodigo(@RequestParam Integer id) {
        return clienteService.findById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminar(@RequestParam Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente != null) {
            clienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
