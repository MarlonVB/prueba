package edu.ec.ista.marlon.examen_final.repository;

import edu.ec.ista.marlon.examen_final.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
