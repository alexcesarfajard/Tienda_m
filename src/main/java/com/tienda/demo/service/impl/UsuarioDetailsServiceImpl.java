package com.tienda.demo.service.impl;

import com.tienda.demo.dao.UsuarioDAO;
import com.tienda.demo.domain.Rol;
import com.tienda.demo.domain.Usuario;
import com.tienda.demo.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
public class UsuarioDetailsServiceImpl 
        implements UsuarioDetailsService, UserDetailsService {
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        
        //Se busca el registro en la tabla de usuarios mediante findByUsername
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //Se valida si se recuperó un usuario de la tabla
        if (usuario == null){
            //No se encuentra el usuario
            throw new UsernameNotFoundException(username);
        }
        
        //si estamos acá... si se encontró el usuario
        
        //Acá va la recuperación de la foto...
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //Se recuperan los roles 
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol r: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        
        //Se devuelve un usuario ya de tipo UserDetails
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
        
    }
    
}
