package it.preventivo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.preventivo.entity.Preventivo;
import it.preventivo.repository.PreventivoRepository;

@Service
public class PreventivoService {

    @Autowired
    private PreventivoRepository preventivoRepository;

    public List<Preventivo> findAll() {
        return preventivoRepository.findAll();
    }

    public Optional<Preventivo> findById(Long id) {
        return preventivoRepository.findById(id);
    }

    public Preventivo save(Preventivo preventivo) {
        return preventivoRepository.save(preventivo);
    }

    public void deleteById(Long id) {
        preventivoRepository.deleteById(id);
    }
}

