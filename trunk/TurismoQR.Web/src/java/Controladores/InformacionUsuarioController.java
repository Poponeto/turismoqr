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
import Utils.FilaTablaUsuario;
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
}
