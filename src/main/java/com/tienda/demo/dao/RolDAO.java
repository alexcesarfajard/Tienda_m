package com.tienda.demo.dao;

import com.tienda.demo.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDAO extends 
        JpaRepository<Rol,Long>{
    
    
    
}
