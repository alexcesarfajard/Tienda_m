package com.tienda.demo.service;

import com.tienda.demo.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface RegistroService {

    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;
    
    public Model activar(Model model, String usuario, String clave);
    
    public void activar(Usuario usuario, MultipartFile imagenFile);
    
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
}