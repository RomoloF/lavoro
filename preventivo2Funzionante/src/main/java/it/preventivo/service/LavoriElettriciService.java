package it.preventivo.service;

import java.util.List;

import it.preventivo.entity.LavoriElettrici;

public interface LavoriElettriciService {
    List<LavoriElettrici> findAll();
    LavoriElettrici findById(Long id);
    LavoriElettrici save(LavoriElettrici lavoriElettrici);
    void deleteById(Long id);
}
