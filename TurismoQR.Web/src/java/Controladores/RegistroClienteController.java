/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Servicios.Validacion.IServicioValidacionDatos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private IServicioValidacionDatos servicioValidacionDatos;
    private static final String paginaRegistrarCliente = "paginaRegistrarCliente.htm";
    private static final String paginaRegistrarEmpresa = "paginaRegistrarEmpresa.htm";
    private static final String paginaRegistrarPersona = "paginaRegistrarPersona.htm";
    private static final String registrarEmpresa = "registrarEmpresa.htm";
    private static final String registrarPersona = "registrarPersona.htm";
    private static final String confirmacionRegistroCliente = "confirmacionRegistroCliente.htm";

    @Autowired
    public RegistroClienteController(
            IServicioCliente servicioEmpresa,
            IServicioCliente servicioPersona,
            IServicioValidacionDatos servicioValidacionDatos)
    {
        this.servicioEmpresa = servicioEmpresa;
        this.servicioPersona = servicioPersona;
        this.servicioValidacionDatos = servicioValidacionDatos;
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

    public static String generarURLRegistrarCliente(String tipoCliente)
    {
        return "cliente/" + tipoCliente + "/" + paginaRegistrarCliente;
    }

    public static String generarURLConfirmacionRegistroCliente()
    {
        return "cliente/" + confirmacionRegistroCliente;
    }

    @RequestMapping(value = "/opcionesRegistroCliente.htm", method = RequestMethod.GET)
    public String redirigir(ModelMap model)
    {
        model.put("registroEmpresa", generarURLRegistrarCliente("Empresa"));
        model.put("registroPersona", generarURLRegistrarCliente("Persona"));

        return "Registro/EmpresaPersonaPopUp";
    }

    @RequestMapping(value = "{tipoCliente}/" + paginaRegistrarCliente, method = RequestMethod.GET)
    public String redirigir(
            @PathVariable String tipoCliente,
            ModelMap model)
    {
        model.put("tipoCliente", tipoCliente);

        if (tipoCliente.equalsIgnoreCase("empresa"))
        {
            model.put("formularioCliente", generarURLFormularioEmpresa());
            model.put("registro", generarURLRegistrarEmpresa());
        }
        else
        {
            model.put("formularioCliente", generarURLFormularioPersona());
            model.put("registro", generarURLRegistrarPersona());
        }

        return "Registro/RegistroCliente";
    }

    @RequestMapping(value = "/" + paginaRegistrarEmpresa, method = RequestMethod.GET)
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
    public void registrarEmpresa(@RequestBody DTOEmpresa dtoEmpresa)
    {
        servicioEmpresa.registrarCliente(dtoEmpresa);
    }

    @RequestMapping(value = "/" + registrarPersona, method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, String> registrarPersona(@RequestBody DTOPersona dtoPersona, HttpServletResponse response)
    {

        Errores errores = servicioValidacionDatos.validarDatos(dtoPersona);

        response.setContentType("application/json");
        
        if (errores.hayErrores())
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return errores;
        }
        else
        {
            boolean exito = servicioPersona.registrarCliente(dtoPersona);

            Map<String, String> datos = new HashMap<String, String>();

            if (exito)
            {
                response.setStatus(HttpServletResponse.SC_OK);
                datos.put("mail", dtoPersona.getMail());
                datos.put("urlConfirmacion", generarURLConfirmacionRegistroCliente());
            }
            else
            {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            
            return datos;

        }
    }

    @RequestMapping(value = "/" + confirmacionRegistroCliente, method = RequestMethod.GET)
    public String confirmarRegistroCliente(String mail, Model modelo)
    {
        modelo.addAttribute("mail", mail);
        return "Registro/ConfirmacionRegistroCliente";
    }
}
