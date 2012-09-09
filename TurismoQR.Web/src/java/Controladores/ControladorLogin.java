package Controladores;


import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Usuario.ManejadorLogin.ManejadorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Federico
 */

@Controller
@RequestMapping("/Login")
@SessionAttributes
public class ControladorLogin implements Validator {

    private ManejadorLogin manejadorLogin;

    @Autowired
    public void setManejadorLogin(ManejadorLogin manejadorLogin)
    {
        this.manejadorLogin = manejadorLogin;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("Usuario") DTOUsuario dtoUsuario)
    {
        manejadorLogin.esUsuarioDelSistema(dtoUsuario);
        return "";
    }

    public boolean supports(Class<?> type)
    {
        return DTOUsuario.class.equals(type);
    }

    public void validate(Object comando, Errors errors)
    {
        DTOUsuario usuario = (DTOUsuario)comando;

        if (manejadorLogin.esUsuarioDelSistema(usuario))
        {
            errors.reject("usuario.incorrecto");
        }
    }
}
