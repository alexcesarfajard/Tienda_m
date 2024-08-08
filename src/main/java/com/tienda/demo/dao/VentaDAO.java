package com.tienda.demo.dao;

import com.tienda.demo.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VentaDAO 
        extends JpaRepository<Venta, Long>{
    
}
