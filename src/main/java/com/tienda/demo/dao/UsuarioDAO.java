package com.tienda.demo.dao;

import com.tienda.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends 
        JpaRepository<Usuario,Long>{
    
    public Usuario findByUsername(String username);
    
}
