/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

/**
 *
 * @author Federico
 */
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import TurismoQR.Servicios.Usuario.IServicioUsuario;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Servicios.Validacion.IServicioValidacionDatos;
import Utils.FilaTablaUsuario;
import Utils.IFila;
import Utils.Tabla;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Federico
 */
@Controller
@RequestMapping("/administracion/usuario")
public class InformacionUsuarioController
{

    IServicioUsuario servicioUsuario;
    IServicioValidacionDatos servicioValidacionDatos;
    IServicioCliente servicioCliente;

    @Autowired
    public void InformacionUsuarioController(
            IServicioUsuario servicioUsuario,
            IServicioValidacionDatos servicioValidacionDatos,
            IServicioCliente servicioPersona)
    {
        this.servicioUsuario = servicioUsuario;
        this.servicioValidacionDatos = servicioValidacionDatos;
        this.servicioCliente = servicioPersona;
    }

    @RequestMapping(value = "/informacionPersonal.htm", method = RequestMethod.GET)
    public String paginaInformacionPersonal(ModelMap model, HttpServletRequest request)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        
        String nombreUsuario = userDetails.getUsername();

        DTOCliente dtoCliente = servicioCliente.obtenerDatosClienteDeUsuario(nombreUsuario);

        if(dtoCliente == null)
        {
            model.put("usuario", nombreUsuario);
            return "Administracion/Usuario/InformacionPersonalUsuario";
        }
        
        return "redirect:/administracion/cliente/informacionPersonal.htm";
    }

    @RequestMapping(value = "/paginaAdministracionUsuarios.htm", method = RequestMethod.GET)
    public String paginaAdministracionUsuarios(ModelMap model)
    {
        model.put("roles", servicioUsuario.obtenerRoles());
        return "Administracion/Usuario/AdministracionUsuarios";
    }

    @RequestMapping(value = "/obtenerInformacionTabla.htm", method = RequestMethod.GET)
    public
    @ResponseBody
    Tabla obtenerInformacionTabla()
    {
        Collection<DTOUsuario> dtosUsuario = servicioUsuario.consultarUsuarios();

        Tabla tabla = new Tabla();

        Collection<IFila> filas = new HashSet<IFila>();

        for (DTOUsuario dtoUsuario : dtosUsuario)
        {
            FilaTablaUsuario fila = new FilaTablaUsuario();

            fila.setContraseña(dtoUsuario.getContraseña());
            fila.setNombreUsuario(dtoUsuario.getNombreUsuario());
            fila.setIdUsuario(dtoUsuario.getIdUsuario());
            fila.setBloqueado(!dtoUsuario.isAccountNonLocked());
            fila.setExpirado(!dtoUsuario.isCredentialsNonExpired());
            fila.setHabilitado(dtoUsuario.isEnabled());
            filas.add(fila);
        }

        tabla.setRows(filas);

        return tabla;

    }

    @RequestMapping(value = "/cambiarContrasenia.htm", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, String> cambiarContrasenia(
            @RequestParam("contraseniaActual") String contraseniaActual,
            @RequestParam("nuevaContrasenia") String nuevaContrasenia,
            HttpServletRequest request,
            HttpServletResponse response)
    {
        String username = (String) request.getSession().getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY);

        Errores errores = servicioUsuario.cambiarContrasenia(username, contraseniaActual, nuevaContrasenia);

        if (errores.hayErrores())
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return errores;
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_OK);
            Map<String, String> datos = new HashMap<String, String>();

            datos.put("urlRedirigir", "home.htm");

            return datos;
        }
    }

    @RequestMapping(value = "/reiniciarContrasenia.htm", method = RequestMethod.POST)
    public
    void reiniciarContrasenia(@RequestParam("nombreUsuario") String nombreUsuario, HttpServletResponse response)
    {
        Boolean exito = servicioUsuario.reiniciarContrasenia(nombreUsuario);

        if(exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @RequestMapping(value = "/eliminarUsuario.htm", method = RequestMethod.POST)
    public
    void eliminarUsuario(@RequestParam("nombreUsuario") String nombreUsuario, HttpServletResponse response)
    {
        Boolean exito = servicioUsuario.eliminarUsuario(nombreUsuario);

        if(exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @RequestMapping(value = "/desbloquearUsuario.htm", method = RequestMethod.POST)
    public
    void desbloquearUsuario(@RequestParam("nombreUsuario") String nombreUsuario, HttpServletResponse response)
    {
        Boolean exito = servicioUsuario.desbloquearUsuario(nombreUsuario);

        if(exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @RequestMapping(value = "/crearUsuario.htm", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, String> crearUsuario(@RequestBody DTOUsuario dtoUsuario, HttpServletResponse response)
    {
        Errores errores = servicioValidacionDatos.validarDatos(dtoUsuario);

        if (errores.hayErrores())
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return errores;
        }
        else
        {
            boolean exito = servicioUsuario.crearUsuario(dtoUsuario);

            if (exito)
            {
                response.setStatus(HttpServletResponse.SC_OK);
                return null;
            }
            else
            {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                return null;
            }
        }

    }
}
