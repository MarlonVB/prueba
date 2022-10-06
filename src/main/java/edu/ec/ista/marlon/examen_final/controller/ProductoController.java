package edu.ec.ista.marlon.examen_final.controller;

import edu.ec.ista.marlon.examen_final.model.Producto;
import edu.ec.ista.marlon.examen_final.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoS;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        return new ResponseEntity<>(productoS.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto p) {

        return new ResponseEntity<>(productoS.crear(p), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id) {
        productoS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto p) {
        Producto producto = productoS.findById(id);
        if (producto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                producto.setCod_prodcuto(p.getCod_prodcuto());
                producto.setProducto(p.getProducto());
                producto.setCantidad(p.getCantidad());
                producto.setPrecio(p.getPrecio());
                return new ResponseEntity<>(productoS.crear(p), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

}
