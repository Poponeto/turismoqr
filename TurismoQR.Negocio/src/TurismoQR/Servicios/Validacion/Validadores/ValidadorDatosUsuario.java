/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
//import TurismoQR.ObjetosNegocio.Usuarios.Persona;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
//import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Validacion.Errores;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MARIANO
 */
public class ValidadorDatosUsuario {
    
        IAccesoDatos accesoDatos;

    public ValidadorDatosUsuario(IAccesoDatos accesoDatos)
    {
        this.accesoDatos = accesoDatos;
    }
    
    
    ValidadorDatosUsuario() {
        //throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    public boolean soportaObjeto(Object objeto)
    {
        return objeto instanceof DTOUsuario;
    }
    
    public void validar(Object objeto, Errores errores)
    {
        DTOUsuario dtoUsuario = (DTOUsuario) objeto;
        
         String regexNombreUsuario = "[a-zA-Z]+";
        
        if (dtoUsuario.getNombreUsuario() == null || dtoUsuario.getNombreUsuario().isEmpty())
        {
            errores.agregarError("nombreUsuario", "Debe especificar un nombre de usuario.");
        }
        else if (!dtoUsuario.getNombreUsuario().matches(regexNombreUsuario))
        {
            errores.agregarError("nombreUsuario", "El nombre de usuario es inválido. Debe contener sólo letras.");
        }

        
        if (dtoUsuario.getContraseña() == null || dtoUsuario.getContraseña().isEmpty())
        {
            errores.agregarError("contraseña", "Debe especificar una contraseña.");
        }
        else if (dtoUsuario.getContraseña().length() < 6)
        {
            errores.agregarError("contraseña", "Debe contener al menos 6 caracteres.");
        }
        else if (dtoUsuario.getContraseña().length() > 20)
        {
            errores.agregarError("contraseña", "Debe contener no más de 20 caracteres.");
        }

        
        if (dtoUsuario.getUsername() == null || dtoUsuario.getUsername().isEmpty())
        {
            errores.agregarError("username", "Debe especificar un username.");
        }
        else if (!dtoUsuario.getUsername().equals(dtoUsuario.getNombreUsuario()))
        {
        errores.agregarError("username", "El username debe ser igual que el nombre de usuario.");
        }
        
        
        if (dtoUsuario.getPassword() == null || dtoUsuario.getPassword().isEmpty())
        {
            errores.agregarError("password", "Debe especificar un password.");
        }
        else if (!dtoUsuario.getPassword().equals(dtoUsuario.getContraseña()))
        {
        errores.agregarError("password", "El password debe ser igual que la contraseña.");
        }
        
    }
}
