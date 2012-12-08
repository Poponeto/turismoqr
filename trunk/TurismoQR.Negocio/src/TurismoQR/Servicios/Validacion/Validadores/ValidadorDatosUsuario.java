/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
//import TurismoQR.ObjetosNegocio.Usuarios.Persona;
import TurismoQR.ConstantesDeNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Rol;
//import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Validacion.Errores;

/**
 *
 * @author MARIANO
 */
public class ValidadorDatosUsuario implements Validador{
    
        IAccesoDatos accesoDatos;

    public ValidadorDatosUsuario(IAccesoDatos accesoDatos)
    {
        this.accesoDatos = accesoDatos;
    }
    
    
    public boolean soportaObjeto(Object objeto)
    {
        return objeto instanceof DTOUsuario;
    }
    
    public void validar(Object objeto, Errores errores)
    {
        DTOUsuario dtoUsuario = (DTOUsuario) objeto;
        
         String regexNombreUsuario = "[a-zA-Z0-9]+";
        
        if (dtoUsuario.getNombreUsuario() == null || dtoUsuario.getNombreUsuario().isEmpty())
        {
            errores.agregarError("nombreUsuario", "Debe especificar un nombre de usuario.");
        }
        else if (!dtoUsuario.getNombreUsuario().matches(regexNombreUsuario))
        {
            errores.agregarError("nombreUsuario", "El nombre de usuario es inválido. Debe contener sólo caracteres alfanumericos.");
        }

        
        if (dtoUsuario.getContraseña() == null || dtoUsuario.getContraseña().isEmpty())
        {
            errores.agregarError("contraseña", "Debe especificar una contraseña.");
        }
        else if (dtoUsuario.getContraseña().length() < ConstantesDeNegocio.MIN_LONGUITUD_PASS)
        {
            errores.agregarError("contraseña", "Debe contener al menos "+ConstantesDeNegocio.MIN_LONGUITUD_PASS+" caracteres.");
        }

        Rol rol = accesoDatos.BuscarObjeto(Rol.class, dtoUsuario.getDtoRol().getNombreRol());
        
        if(rol == null)
        {
            errores.agregarError("rol", "El rol especificado no existe.");
        }
    }
}
