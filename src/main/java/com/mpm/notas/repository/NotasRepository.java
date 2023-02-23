package com.mpm.notas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpm.notas.models.Nota;

@Repository
public interface NotasRepository extends JpaRepository<Nota, Integer>{
    // select * from notas where titulo like %cadena% and fecha >= '23/03/2023';
    public List<Nota> findByTituloContainingOrFechaGreaterThanEqual (String titulo, Date fecha);
}

