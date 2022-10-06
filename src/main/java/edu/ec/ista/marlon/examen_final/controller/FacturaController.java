package edu.ec.ista.marlon.examen_final.controller;

import edu.ec.ista.marlon.examen_final.model.Factura;
import edu.ec.ista.marlon.examen_final.service.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    FacturaServiceImpl facturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>> listar() {
        return new ResponseEntity<>(facturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura f) {
        if (!f.getId_cliente().isEmpty() && !f.getNum_factura().isEmpty() && !f.getFecha().isEmpty()){
            return new ResponseEntity<>(facturaService.crear(f), HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Factura> eliminarFactura(@PathVariable Integer id) {
        facturaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Integer id, @RequestBody Factura f) {
        Factura factura = facturaService.findById(id);
        if (factura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {

                return new ResponseEntity<>(facturaService.crear(f), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
