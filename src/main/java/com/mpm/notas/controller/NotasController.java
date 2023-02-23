package com.mpm.notas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpm.notas.models.Nota;
import com.mpm.notas.service.NotasService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class NotasController {

    @Autowired
    NotasService notasService;

    @GetMapping("/notas")
    public List<Nota> lista() {
        return notasService.findAll();
    }

    @GetMapping("/notas/{codigo}")
    public Nota findNota(@PathVariable int codigo) {
        return notasService.findById(codigo);
    }

    @DeleteMapping("/notas/{codigo}")
    public void deleteNota(@PathVariable int codigo) {
        notasService.deleteById(codigo);
    }

    @PostMapping(value = "/notas")
    public Nota guardar(@RequestBody Nota nota) {
        return notasService.save(nota);
    }

    @PutMapping(value = "/notas/{codigo}")
    public void modificar(@RequestBody Nota nota, @PathVariable("codigo") int codigo) {
        notasService.update(nota, codigo);
    }

    @GetMapping("/notas/buscar")
    public List<Nota> findPorTituloFecha(@RequestParam("titulo") String titulo, @RequestParam("fecha") String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date fechaDate = formato.parse(fecha); 
        return notasService.findByTituloFecha(titulo, fechaDate);
    }

}
