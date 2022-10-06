package edu.ec.ista.marlon.examen_final.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "producto")
//LOMBOK
@Data
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_factura", nullable = false, length = 45)
    private String id_factura;

    @Column(name = "cod_prodcuto", nullable = false, length = 45)
    private String cod_prodcuto;

    @Column(name = "prodcuto", nullable = false, length = 45)
    private String producto;

    @Column(name = "cantidad", nullable = false, length = 45)
    private int cantidad;

    @Column(name = "precio", nullable = false, length = 45)
    private double precio;

    public Producto() {
    }
}
