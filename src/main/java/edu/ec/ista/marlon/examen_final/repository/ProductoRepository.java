package edu.ec.ista.marlon.examen_final.repository;

import edu.ec.ista.marlon.examen_final.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
