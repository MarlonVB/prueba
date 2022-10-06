package edu.ec.ista.marlon.examen_final.repository;

import edu.ec.ista.marlon.examen_final.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
