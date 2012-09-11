package Controladores;


import TurismoQR.Usuario.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Federico
 */

@Controller
@RequestMapping("/Login")
@SessionAttributes
public class ControladorLogin implements UserDetailsService {

    IServicioUsuario servicioUsuario;

    @Autowired
    public void setServicioUsuario(IServicioUsuario servicioUsuario)
    {
        this.servicioUsuario = servicioUsuario;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
    {
        return null;
    }

 
}
