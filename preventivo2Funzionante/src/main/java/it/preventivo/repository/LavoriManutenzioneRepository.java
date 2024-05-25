package it.preventivo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.preventivo.entity.LavoriManutenzione;

@Repository
public interface LavoriManutenzioneRepository extends JpaRepository<LavoriManutenzione, Long> {
    // Puoi aggiungere metodi di query personalizzati se necessario
}
