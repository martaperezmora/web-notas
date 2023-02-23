package com.mpm.notas.service;

import java.util.Date;
import java.util.List;

import com.mpm.notas.models.Nota;

public interface NotasService {
        
    public List<Nota> findAll();
    public Nota findById(int id);
    public List<Nota> findByTituloFecha(String cadena, Date fecha);
    public Nota save(Nota nota);
    public void update(Nota nota, int id);
    public void deleteById(int id);
    public void deleteAll();
}
