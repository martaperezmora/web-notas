package com.mpm.notas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mpm.notas.models.Nota;
import com.mpm.notas.repository.NotasRepository;
import com.mpm.notas.service.NotasService;

public class NotasServiceImpl implements NotasService{

    @Autowired
    NotasRepository notasRepository;

    @Override
    public List<Nota> findAll() {
        return notasRepository.findAll();
    }

    @Override
    public Nota findById(int codigo) {
        Optional<Nota> findById = notasRepository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public Nota save(Nota nota) {
        return notasRepository.save(nota);
    }

    @Override
    public void update(Nota nota, int codigo) {
        this.findById(codigo);
        nota.setCodigo(codigo);
        notasRepository.save(nota);
        
    }

    @Override
    public void deleteById(int codigo) {
        notasRepository.deleteById(codigo);
        
    }

    @Override
    public void deleteAll() {
        notasRepository.deleteAll();
        
    }
    
}
