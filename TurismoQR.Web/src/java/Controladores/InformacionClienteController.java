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
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

            filas.add(fila);
        }

        tabla.setRows(filas);
        return tabla;

    }
}
