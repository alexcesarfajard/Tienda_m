package com.tienda.demo.dao;

import com.tienda.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDAO 
        extends JpaRepository<Categoria, Long>{
    
}
