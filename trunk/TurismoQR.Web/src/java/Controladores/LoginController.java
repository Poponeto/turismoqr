package Controladores;


import TurismoQR.Usuario.IServicioUsuario;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Federico
 */

@Service
public class LoginController implements UserDetailsService {

    
    IServicioUsuario servicioUsuario;

    //@Autowired
    //public void setServicioUsuario(IServicioUsuario servicioUsuario)
    //{
    //    this.servicioUsuario = servicioUsuario;
    //}


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
    {
        return servicioUsuario.cargarUsuario(username);
    }

 
}
