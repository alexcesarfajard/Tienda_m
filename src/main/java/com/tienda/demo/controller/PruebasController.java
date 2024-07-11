package com.tienda.demo.controller;

import com.tienda.demo.domain.Producto;
import com.tienda.demo.service.CategoriaService;
import com.tienda.demo.service.ProductoService;
import com.tienda.demo.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idProducto}")
    public String listado(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto); 
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";
    }

}
