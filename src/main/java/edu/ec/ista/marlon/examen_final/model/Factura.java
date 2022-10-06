package edu.ec.ista.marlon.examen_final.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "factura")
//LOMBOK
@Data
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_cliente", nullable = false, length = 45)
    private String id_cliente;

    @Column(name = "num_factura", nullable = false, length = 45)
    private String num_factura;

    @Column(name = "fecha", nullable = false, length = 45)
    private String fecha;

    public Factura() {
    }
}
