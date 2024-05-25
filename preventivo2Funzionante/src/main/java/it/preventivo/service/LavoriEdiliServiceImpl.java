package it.preventivo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.preventivo.entity.LavoriEdili;
import it.preventivo.repository.LavoriEdiliRepository;

@Service
public class LavoriEdiliServiceImpl implements LavoriEdiliService {

    @Autowired
    private LavoriEdiliRepository repository;

    @Override
    public List<LavoriEdili> findAll() {
        return repository.findAll();
    }

    @Override
    public LavoriEdili findById(long id) {
        Optional<LavoriEdili> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public LavoriEdili save(LavoriEdili lavoroEdile) {
        return repository.save(lavoroEdile);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
