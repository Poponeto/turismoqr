package Controladores;


import TurismoQR.Usuario.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Federico
 */

@Controller("loginController")
@RequestMapping("/login")
public class LoginController implements UserDetailsService {

    
    IServicioUsuario servicioUsuario;

    @Autowired
    public void LoginController(IServicioUsuario servicioUsuario)
    {
        this.servicioUsuario = servicioUsuario;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
    {
        UserDetails userDetails = servicioUsuario.cargarUsuario(username);
        return userDetails;
    }

    @RequestMapping("/ingresarComoTurista.htm")
    public String ingresarComoTurista()
    {
        return "redirect:/buscarPunto/paginaBuscarPunto.htm";
    }

 
}
