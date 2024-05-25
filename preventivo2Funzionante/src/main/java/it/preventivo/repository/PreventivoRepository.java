package it.preventivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.preventivo.entity.Preventivo;

@Repository
public interface PreventivoRepository extends JpaRepository<Preventivo, Long> {
}