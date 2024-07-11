package com.tienda.demo.dao;

import com.tienda.demo.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDAO 
        extends JpaRepository<Producto, Long>{
    
}
