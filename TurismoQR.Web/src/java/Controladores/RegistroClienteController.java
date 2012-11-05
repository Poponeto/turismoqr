/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ftacchini
 */
@Controller
@RequestMapping("/cliente")
public class RegistroClienteController
{

    private IServicioCliente servicioEmpresa;
    private IServicioCliente servicioPersona;

    private static final String paginaRegistrarEmpresa = "paginaRegistrarEmpresa.htm";
    private static final String paginaRegistrarPersona = "paginaRegistrarPersona.htm";

    private static final String registrarEmpresa = "registrarEmpresa.htm";
    private static final String registrarPersona = "registrarPersona.htm";

    @Autowired
    public RegistroClienteController (
            IServicioCliente servicioEmpresa,
            IServicioCliente servicioPersona
            )
    {
        this.servicioEmpresa = servicioEmpresa;
        this.servicioPersona = servicioPersona;
    }

    public static String generarURLFormularioEmpresa()
    {
        return "cliente/" + paginaRegistrarEmpresa;
    }

    public static String generarURLFormularioPersona()
    {
        return "cliente/" + paginaRegistrarPersona;
    }

    public static String generarURLRegistrarEmpresa()
    {
        return "cliente/" + registrarEmpresa;
    }

    public static String generarURLRegistrarPersona()
    {
        return "cliente/" + registrarPersona;
    }

    @RequestMapping(value = "{tipoCliente}/paginaRegistrarCliente.htm", method = RequestMethod.GET)
    public String redirigir(
            @PathVariable String tipoCliente,
            ModelMap model)
    {
        if (tipoCliente.equalsIgnoreCase("empresa"))
        {
            model.addAttribute("formularioCliente", generarURLFormularioEmpresa());
            model.addAttribute("registro", generarURLRegistrarEmpresa());
        }
        else
        {
            model.addAttribute("formularioCliente", generarURLFormularioPersona());
            model.addAttribute("registro", generarURLRegistrarPersona());
        }

        return "Registro/RegistroCliente";
    }

    @RequestMapping(value = "/" +paginaRegistrarEmpresa, method = RequestMethod.GET)
    public String formularioEmpresa()
    {
        return "Registro/FormularioEmpresa";
    }

    @RequestMapping(value = "/" + paginaRegistrarPersona, method = RequestMethod.GET)
    public String formularioPersona()
    {
        return "Registro/FormularioPersona";
    }

    @RequestMapping(value = "/" + registrarEmpresa, method = RequestMethod.POST)
    public void registrarEmpresa( DTOEmpresa dtoEmpresa)
    {
        servicioEmpresa.registrarCliente(dtoEmpresa);
    }

    @RequestMapping(value = "/" + registrarPersona, method = RequestMethod.POST)
    public void registrarPersona(DTOPersona dtoPersona)
    {
        servicioPersona.registrarCliente(dtoPersona);
    }


}
