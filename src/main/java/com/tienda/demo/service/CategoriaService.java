package com.tienda.demo.service;

import com.tienda.demo.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Se enuncia un metodo que recupera los registros de la tabla categoria dentro de un arraylist,
    //pueden ser todos los registros o sólo los activos
    public List<Categoria> getCategorias(boolean activos);
}
