package com.mpm.notas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpm.notas.models.Nota;

@Repository
public interface NotasRepository extends JpaRepository<Nota, Integer>{
    public List<Nota> findByTitulo (String cadena);
}

