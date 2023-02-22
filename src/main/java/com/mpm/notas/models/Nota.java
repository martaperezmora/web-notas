package com.mpm.notas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Nota {
    @Id
    @GeneratedValue
    private int codigo;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fecha;

    @Column(length = 1000, nullable = false)
    private String descripcion;
    
    public Nota(int codigo) {
        this.codigo = codigo;
    }
    
    public Nota(int codigo, String titulo, Date fecha, String descripcion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Nota() {
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nota other = (Nota) obj;
        if (codigo != other.codigo)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        return true;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
