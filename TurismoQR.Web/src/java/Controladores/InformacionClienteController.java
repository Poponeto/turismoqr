/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Servicios.Validacion.IServicioValidacionDatos;
import Utils.FilaTablaCliente;
import Utils.IFila;
import Utils.Tabla;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Federico
 */
@Controller
@RequestMapping("/administracion/cliente")
public class InformacionClienteController
{

    private IServicioCliente servicioEmpresa;
    private IServicioCliente servicioPersona;
    private IServicioCliente servicioCliente;
    private IServicioValidacionDatos servicioValidacionDatos;

    @Autowired
    public InformacionClienteController(
            IServicioCliente servicioEmpresa,
            IServicioCliente servicioPersona,
            IServicioValidacionDatos servicioValidacionDatos)
    {
        this.servicioEmpresa = servicioEmpresa;
        this.servicioPersona = servicioPersona;
        this.servicioCliente = servicioPersona;
        this.servicioValidacionDatos = servicioValidacionDatos;
    }

    @RequestMapping(value = "/informacionPersonal.htm", method = RequestMethod.GET)
    public String paginaInformacionPersonal(ModelMap model)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }

        String nombreUsuario = userDetails.getUsername();

        DTOCliente dtoCliente = servicioCliente.obtenerDatosClienteDeUsuario(nombreUsuario);

        if(dtoCliente instanceof DTOPersona)
        {
            model.put("formularioCliente", RegistroClienteController.generarURLFormularioPersona());
            model.put("tipoCliente", "Persona");
        }
        else
        {
            model.put("formularioCliente", RegistroClienteController.generarURLFormularioEmpresa());
            model.put("tipoCliente", "Empresa");
        }

        model.put("cliente", dtoCliente);
        
        return "Administracion/Usuario/InformacionPersonalCliente";
    }

    @RequestMapping(value = "/paginaAdministracionClientes.htm", method = RequestMethod.GET)
    public String redirigir()
    {
        return "Administracion/Usuario/AdministracionClientes";
    }

    @RequestMapping(value = "/obtenerInformacionTabla.htm", method = RequestMethod.GET)
    public
    @ResponseBody
    Tabla obtenerInformacionTabla()
    {

        Tabla tabla = new Tabla();

        Collection<DTOCliente> dtosCliente = servicioCliente.consultarClientes();
        Collection<IFila> filas = new HashSet<IFila>();

        for (DTOCliente dtoCliente : dtosCliente)
        {
            FilaTablaCliente fila = new FilaTablaCliente();
            fila.setCelular(dtoCliente.getCelular());
            fila.setMail(dtoCliente.getMail());
            fila.setPuntosPermitidos(dtoCliente.getCantidadDePuntosPermitidos());
            fila.setTelefonoFijo(dtoCliente.getTelefonoFijo());
            fila.setTipoCliente(dtoCliente.getTipoCliente());//
            fila.setNombreCliente(dtoCliente.getNombreCliente());//
            fila.setPuntosQuePosee(dtoCliente.getCantidadDePuntosQuePosee());
            fila.setIdCliente(dtoCliente.getIdContacto());
            fila.setEstadoCliente(dtoCliente.getEstadoCliente());
            filas.add(fila);
        }

        tabla.setRows(filas);
        return tabla;

    }

    @RequestMapping(value = "/autorizarCliente.htm", method = RequestMethod.POST)
    public void autorizarCliente(String idCliente, HttpServletResponse response)
    {
        boolean exito = servicioCliente.autorizarCliente(idCliente);

        if (exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @RequestMapping(value = "/reiniciarContraseniaCliente.htm", method = RequestMethod.POST)
    public void reiniciarContraseñaCliente(String idCliente, HttpServletResponse response)
    {
        boolean exito = servicioCliente.reiniciarContraseñaCliente(idCliente);

        if (exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @RequestMapping(value = "/eliminarCliente.htm", method = RequestMethod.POST)
    public void eliminarCliente(String idCliente, HttpServletResponse response)
    {
        boolean exito = servicioCliente.eliminarCliente(idCliente);

        if (exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @RequestMapping(value = "/desbloquearCliente.htm", method = RequestMethod.POST)
    public void desbloquearCliente(String idCliente, HttpServletResponse response)
    {
        boolean exito = servicioCliente.desbloquearCliente(idCliente);

        if (exito)
        {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @RequestMapping(value = "/modificarEmpresa.htm", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, String> modificarEmpresa(@RequestBody  DTOEmpresa dtoEmpresa, HttpServletResponse response)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }

        String nombreUsuario = userDetails.getUsername();

        DTOCliente dtoCliente = servicioCliente.obtenerDatosClienteDeUsuario(nombreUsuario);
        dtoEmpresa.setIdContacto(dtoCliente.getIdContacto());

        Errores errores = servicioValidacionDatos.validarDatos(dtoEmpresa);

        response.setContentType("application/json");

        if (errores.hayErrores())
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return errores;
        }
        else
        {
            boolean exito = servicioEmpresa.actualizarDatosCliente(dtoEmpresa);

            Map<String, String> datos = new HashMap<String, String>();

            if (exito)
            {
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else
            {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

            return datos;

        }

    }

    @RequestMapping(value = "/modificarPersona.htm", method = RequestMethod.POST)
    public 
    @ResponseBody
    Map<String, String> modificarPersona(@RequestBody  DTOPersona dtoPersona, HttpServletResponse response)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }

        String nombreUsuario = userDetails.getUsername();

        DTOCliente dtoCliente = servicioCliente.obtenerDatosClienteDeUsuario(nombreUsuario);
        dtoPersona.setIdContacto(dtoCliente.getIdContacto());

        Errores errores = servicioValidacionDatos.validarDatos(dtoPersona);

        response.setContentType("application/json");

        if (errores.hayErrores())
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return errores;
        }
        else
        {
            boolean exito = servicioPersona.actualizarDatosCliente(dtoPersona);

            Map<String, String> datos = new HashMap<String, String>();

            if (exito)
            {
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else
            {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

            return datos;

        }

    }

    @RequestMapping(value = "/obtenerDatosClienteActual.htm", method = RequestMethod.GET)
    public @ResponseBody DTOCliente obtenerDatosClienteActual()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }

        String nombreUsuario = userDetails.getUsername();

        DTOCliente dtoCliente = servicioEmpresa.obtenerDatosClienteDeUsuario(nombreUsuario);

        return dtoCliente;
    }
}
