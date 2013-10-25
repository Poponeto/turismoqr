/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.Servicios.Validacion.Errores;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Federico
 */
public abstract class ValidarDatosPersonaBase implements Validador {

    IAccesoDatos accesoDatos;

    public ValidarDatosPersonaBase(IAccesoDatos accesoDatos) {
        this.accesoDatos = accesoDatos;
    }

    public boolean soportaObjeto(Object objeto) {
        //Si es nulo entonces no es actualizacion
        if (objeto instanceof DTOPersona && esActualizacion((DTOPersona) objeto)) {
            return true;
        }

        return false;
    }

    public void validar(Object objeto, Errores errores) {
        DTOPersona dtoPersona = (DTOPersona) objeto;
        if (dtoPersona.getFechaDeNacimiento() != null) {
            int dia = dtoPersona.getFechaDeNacimiento().getDate();
            dtoPersona.getFechaDeNacimiento().setDate(dia + 1);
        }
       Date fechaActual = Calendar.getInstance().getTime();
        Calendar calendario = (Calendar) Calendar.getInstance().clone();
        calendario.add(Calendar.YEAR, -18);
        Date fechaHace18Años = calendario.getTime();

        calendario.add(Calendar.YEAR, -92);
        Date fechaHace110Años = calendario.getTime();

        if (dtoPersona.getFechaDeNacimiento() == null) {
            errores.agregarError("fechaDeNacimiento", "Debe especificar una fecha de nacimiento.");
        } else if (dtoPersona.getFechaDeNacimiento().after(fechaActual)) {
            errores.agregarError("fechaDeNacimiento", "La fecha de nacimiento no puede ser posterior a la fecha actual.");
        } else if (dtoPersona.getFechaDeNacimiento().after(fechaHace18Años)) {
            errores.agregarError("fechaDeNacimiento", "Debes ser mayor de 18 años.");
        } else if (dtoPersona.getFechaDeNacimiento().before(fechaHace110Años)) {
            errores.agregarError("fechaDeNacimiento", "Edad incorrecta, no puedes ser mayor de 110 años.");
        }

        if (dtoPersona.getSexo() == null || dtoPersona.getSexo().isEmpty()) {
            errores.agregarError("sexo", "Debe especificar genero.");
        } else if (!(dtoPersona.getSexo().equalsIgnoreCase("Masculino") || dtoPersona.getSexo().equalsIgnoreCase("Femenino"))) {

            errores.agregarError("sexo", "El genero debe ser masculino o femenino.");
        }

        String regexNombreApellido = "^[a-zA-Z áéíóúAÉÍÓÚÑñ]+$";

        if (dtoPersona.getApellido() == null || dtoPersona.getApellido().isEmpty()) {
            errores.agregarError("apellido", "Debe especificar apellido.");
        } else if (!dtoPersona.getApellido().matches(regexNombreApellido)) {
            errores.agregarError("apellido", "El apellido solo puede estar compuesto de letras.");
        }

        if (dtoPersona.getNombre() == null || dtoPersona.getNombre().isEmpty()) {
            errores.agregarError("nombre", "Debe especificar nombre.");
        } else if (!dtoPersona.getNombre().matches(regexNombreApellido)) {
            errores.agregarError("nombre", "El nombre solo puede estar compuesto de letras.");
        }

        if (dtoPersona.getDni() == null || dtoPersona.getDni().isEmpty()) {
            errores.agregarError("dni", "Debe especificar un numero de DNI");
        } else {
            analizarErroresDNI(dtoPersona, errores);
        }
    }

    protected abstract boolean esActualizacion(DTOPersona dtoPersona);

    protected abstract void analizarErroresDNI(DTOPersona dtoPersona, Errores errores);
}
