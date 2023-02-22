package com.mpm.notas.service;

import java.util.List;

import com.mpm.notas.models.Nota;

public interface NotasService {
        
    public List<Nota> findAll();
    public Nota findById(int id);
    public List<Nota> findByTitulo(String cadena);
    public Nota save(Nota nota);
    public void update(Nota nota, int id);
    public void deleteById(int id);
    public void deleteAll();
}
