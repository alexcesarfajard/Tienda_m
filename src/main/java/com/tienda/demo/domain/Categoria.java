package com.tienda.demo.domain;

/*
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
}
