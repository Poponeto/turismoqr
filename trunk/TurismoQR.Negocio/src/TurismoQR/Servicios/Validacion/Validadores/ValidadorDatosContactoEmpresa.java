/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.ObjetosTransmisionDatos.DTOContactoEmpresa;
import TurismoQR.Servicios.Validacion.Errores;

/**
 *
 * @author Federico
 */
public class ValidadorDatosContactoEmpresa implements Validador
{

    public boolean soportaObjeto(Object objeto)
    {
        return objeto instanceof DTOContactoEmpresa;
    }

    public void validar(Object objeto, Errores errores)
    {
        DTOContactoEmpresa dtoContactoEmpresa = (DTOContactoEmpresa) objeto;

        String regexNombreApellido = "^[a-zA-Z áéíóúAÉÍÓÚÑñ]+$";

        if (dtoContactoEmpresa.getApellido() == null || dtoContactoEmpresa.getApellido().isEmpty())
        {
            errores.agregarError("apellido", "Debe especificar apellido del contacto.");
        }
        else if (!dtoContactoEmpresa.getApellido().matches(regexNombreApellido))
        {
            errores.agregarError("apellido", "El apellido del contacto solo puede estar compuesto de letras.");
        }

        if (dtoContactoEmpresa.getNombre() == null || dtoContactoEmpresa.getNombre().isEmpty())
        {
            errores.agregarError("nombre", "Debe especificar nombre del contacto.");
        }
        else if (!dtoContactoEmpresa.getNombre().matches(regexNombreApellido))
        {
            errores.agregarError("nombre", "El nombre del contacto solo puede estar compuesto de letras.");
        }

        if (dtoContactoEmpresa.getSexo() == null || dtoContactoEmpresa.getSexo().isEmpty())
        {
            errores.agregarError("sexo", "Debe especificar genero del contacto.");
        }
        else if (!(dtoContactoEmpresa.getSexo().equalsIgnoreCase("Masculino") || dtoContactoEmpresa.getSexo().equalsIgnoreCase("Femenino")))
        {
            errores.agregarError("sexo", "El genero debe ser masculino o femenino.");
        }
    }
}
