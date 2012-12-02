/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Persona;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.Servicios.Validacion.Errores;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Federico
 */
public class ValidadorDatosPersona implements Validador
{

    IAccesoDatos accesoDatos;

    public ValidadorDatosPersona(IAccesoDatos accesoDatos)
    {
        this.accesoDatos = accesoDatos;
    }

    public boolean soportaObjeto(Object objeto)
    {
        return objeto instanceof DTOPersona;
    }

    public void validar(Object objeto, Errores errores)
    {
        DTOPersona dtoPersona = (DTOPersona) objeto;

        Date fechaActual = Calendar.getInstance().getTime();

        if (dtoPersona.getFechaDeNacimiento() == null)
        {
            errores.agregarError("fechaDeNacimiento", "Debe especificar una fecha de nacimiento.");
        }
        else if (dtoPersona.getFechaDeNacimiento().after(fechaActual))
        {
            errores.agregarError("fechaDeNacimiento", "La fecha de nacimiento no puede ser posterior a la fecha actual.");
        }
        else if (dtoPersona.getFechaDeNacimiento().after(new Date(fechaActual.getYear() - 18 + 1900)))
        {
            errores.agregarError("fechaDeNacimiento", "Debes ser mayor de 18 años.");
        }
        else if (dtoPersona.getFechaDeNacimiento().before(new Date(fechaActual.getYear() - 110 + 1900)))
        {
            errores.agregarError("fechaDeNacimiento", "Edad incorrecta, no puedes ser mayor de 110 años.");
        }

        if (dtoPersona.getSexo() == null || dtoPersona.getSexo().isEmpty())
        {
            errores.agregarError("sexo", "Debe especificar genero.");
        }
        else if (!(dtoPersona.getSexo().equalsIgnoreCase("Masculino") || dtoPersona.getSexo().equalsIgnoreCase("Femenino")))
        {

            errores.agregarError("sexo", "El genero debe ser masculino o femenino.");
        }

        String regexNombreApellido = "[a-zA-Z]+";

        if (dtoPersona.getApellido() == null || dtoPersona.getApellido().isEmpty())
        {
            errores.agregarError("apellido", "Debe especificar apellido.");
        }
        else if (!dtoPersona.getApellido().matches(regexNombreApellido))
        {
            errores.agregarError("apellido", "El apellido solo puede estar compuesto de letras.");
        }

        if (dtoPersona.getNombre() == null || dtoPersona.getNombre().isEmpty())
        {
            errores.agregarError("nombre", "Debe especificar nombre.");
        }
        else if (!dtoPersona.getNombre().matches(regexNombreApellido))
        {
            errores.agregarError("nombre", "El nombre solo puede estar compuesto de letras.");
        }

        if (dtoPersona.getDni() == null || dtoPersona.getDni().isEmpty())
        {
            errores.agregarError("dni", "Debe especificar un numero de DNI");
        }
        else
        {
            Collection<Persona> personas =
                    accesoDatos.BuscarObjetosPorCaracteristica(
                    Persona.class,
                    "dni",
                    dtoPersona.getDni());

            if (!personas.isEmpty())
            {
                errores.agregarError("dni", "Ya existe un cliente con ese DNI creado.");
            }
        }
    }
}
