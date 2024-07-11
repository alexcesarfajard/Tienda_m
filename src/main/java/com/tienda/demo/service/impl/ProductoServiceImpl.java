package com.tienda.demo.service.impl;

import com.tienda.demo.dao.ProductoDAO;
import com.tienda.demo.domain.Producto;
import com.tienda.demo.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl 
        implements ProductoService{

    @Autowired 
    private ProductoDAO productoDao;
    
    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        
        if (activos){ // no leer los inactivos
            //lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
}
