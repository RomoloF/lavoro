package it.preventivo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import it.preventivo.entity.LavoriElettrici;

public interface LavoriElettriciRepository extends JpaRepository<LavoriElettrici, Long> {
    // Puoi aggiungere eventuali query personalizzate qui, se necessario
}
