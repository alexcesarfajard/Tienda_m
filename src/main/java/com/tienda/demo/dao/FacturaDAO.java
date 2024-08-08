package com.tienda.demo.dao;

import com.tienda.demo.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturaDAO 
        extends JpaRepository<Factura, Long>{
    
}
