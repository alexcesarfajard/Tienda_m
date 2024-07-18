package com.tienda.demo.dao;

import com.tienda.demo.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDAO 
        extends JpaRepository<Producto, Long>{
    
    public List<Producto> findByPrecioBetweenOrderByDescripcion
        (double precioInf, double precioSup);
    
}
