package it.preventivo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.preventivo.entity.LavoriElettrici;
import it.preventivo.repository.LavoriElettriciRepository;

@Service
public class LavoriElettriciServiceImpl implements LavoriElettriciService {

    @Autowired
    private LavoriElettriciRepository lavoriElettriciRepository;

    @Override
    public List<LavoriElettrici> findAll() {
        return lavoriElettriciRepository.findAll();
    }

    @Override
    public LavoriElettrici findById(Long id) {
        Optional<LavoriElettrici> result = lavoriElettriciRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public LavoriElettrici save(LavoriElettrici lavoriElettrici) {
        return lavoriElettriciRepository.save(lavoriElettrici);
    }

    @Override
    public void deleteById(Long id) {
        lavoriElettriciRepository.deleteById(id);
    }
}
