package com.mpm.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpm.notas.models.Nota;

@Repository
public interface NotasRepository extends JpaRepository<Nota, Integer>{
    
}

