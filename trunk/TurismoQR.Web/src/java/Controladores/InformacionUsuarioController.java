/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

/**
 *
 * @author Federico
 */

import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Usuario.IServicioUsuario;
import TurismoQR.Servicios.Validacion.Errores;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
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
public class InformacionUsuarioController {

    IServicioUsuario servicioUsuario;

    @Autowired
    public void InformacionUsuarioController(IServicioUsuario servicioUsuario)
    {
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(value = "/paginaAdministracionUsuarios.htm", method = RequestMethod.GET)
    public String redirigir()
    {
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

        for(DTOUsuario dtoUsuario : dtosUsuario)
        {
            FilaTablaUsuario fila = new FilaTablaUsuario();

            fila.setContraseña(dtoUsuario.getContraseña());
            fila.setNombreUsuario(dtoUsuario.getNombreUsuario());
            fila.setIdUsuario(dtoUsuario.getIdUsuario());
            filas.add(fila);
        }

        tabla.setRows(filas);

        return tabla;

    }

    @RequestMapping(value = "/cambiarContrasenia.htm", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String,String> cambiarContrasenia(
            @RequestParam("contraseniaActual") String contraseniaActual,
            @RequestParam("nuevaContrasenia") String nuevaContrasenia,
            HttpServletRequest request,
            HttpServletResponse response)
    {
        String username = (String) request.getSession().getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY);

        Errores errores = servicioUsuario.cambiarContrasenia(username, contraseniaActual,  nuevaContrasenia);

        if(errores.hayErrores())
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return errores;
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_OK);
            Map<String, String> datos = new HashMap<String, String>();

            datos.put("urlRedirigir", "/home.htm");

            return datos;
        }
    }
}
