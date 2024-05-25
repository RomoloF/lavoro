package it.preventivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.preventivo.entity.LavoriEdili;

public interface LavoriEdiliRepository extends JpaRepository<LavoriEdili, Long> {
    // Puoi aggiungere eventuali query personalizzate qui, se necessario
}

