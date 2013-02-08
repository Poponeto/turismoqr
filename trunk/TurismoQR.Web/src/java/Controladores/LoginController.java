package Controladores;


import TurismoQR.Servicios.Usuario.IServicioCliente;
import TurismoQR.Servicios.Usuario.IServicioUsuario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;

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
    IServicioCliente servicioCliente;

    @Autowired
    public void LoginController(IServicioUsuario servicioUsuario, IServicioCliente servicioPersona)
    {
        this.servicioUsuario = servicioUsuario;
        this.servicioCliente = servicioPersona;
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

    @RequestMapping("/cuentaExpirada.htm")
    public String redirigirPasswordExpirado(Model modelo, HttpServletRequest request)
    {
        String username = (String) request.getSession().getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY);

        UserDetails userDetails = servicioUsuario.cargarUsuario(username);

        if (userDetails == null){
         return "redirect:/home.htm";
        }

        modelo.addAttribute("usuario", username);

        return "CuentaExpirada";
    }

    @RequestMapping(value = "/reiniciarContraseniaClienteConEmail.htm", method = RequestMethod.POST)
    public void reiniciarContraseñaClienteConEmail(String emailCliente, HttpServletResponse response)
    {
        String idCliente = servicioCliente.obtenerIdClienteConEmail(emailCliente);

        boolean exito = false;

        if(idCliente != null && idCliente != "") {
            exito = servicioCliente.reiniciarContraseñaCliente(idCliente);
        }
        

        if (exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
        
    }

}
