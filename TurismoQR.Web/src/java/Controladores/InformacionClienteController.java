/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import Utils.FilaTablaCliente;
import Utils.IFila;
import Utils.Tabla;
import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    public InformacionClienteController(
            IServicioCliente servicioEmpresa,
            IServicioCliente servicioPersona)
    {
        this.servicioEmpresa = servicioEmpresa;
        this.servicioPersona = servicioPersona;
        this.servicioCliente = servicioPersona;
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

    @RequestMapping(value = "/datosClienteActual.htm", method = RequestMethod.GET)
    public @ResponseBody DTOCliente datosClienteActual(Principal principal)
    {
        DTOCliente dtoCliente = servicioCliente.datosClienteActual(principal.getName());

        return dtoCliente;
    }


    @RequestMapping(value = "/modificarCliente.htm", method = RequestMethod.POST)
    public void modificarCliente(@RequestBody  FilaTablaCliente fila, HttpServletResponse response)
    {
        Boolean exito = servicioCliente.actualizarDatosCliente(null);

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
