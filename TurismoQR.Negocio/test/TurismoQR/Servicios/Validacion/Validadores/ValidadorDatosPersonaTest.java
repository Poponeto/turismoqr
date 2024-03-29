/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.Servicios.Validacion.Errores;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.SimpleFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Federico
 */
public class ValidadorDatosPersonaTest {

    public ValidadorDatosPersonaTest() {
    }

    /**
     * Test of soportaObjeto method, of class ValidadorDatosPersona.
     */
    @Test
    public void testSoportaObjeto() {
        DTOContacto dtoContacto = mock(DTOContacto.class);
        DTOCliente dtoCliente = mock(DTOCliente.class);
        DTOPersona dtoPersona = mock(DTOPersona.class);
        IAccesoDatos accesoDatos = mock(IAccesoDatos.class);

        ValidadorDatosPersona validadorDatosPersona = new ValidadorDatosPersona(accesoDatos);
        boolean resultadoDTOContacto = validadorDatosPersona.soportaObjeto(dtoContacto);
        boolean resultadoDTOCliente = validadorDatosPersona.soportaObjeto(dtoCliente);
        boolean resultadoDTOPersona = validadorDatosPersona.soportaObjeto(dtoPersona);

        assertFalse(resultadoDTOContacto);
        assertFalse(resultadoDTOCliente);
        assertTrue(resultadoDTOPersona);
    }

    /**
     * Test of validar method, of class ValidadorDatosPersona.
     */
    @Test
    public void testValidarExito() {
        Errores errores1 = mock(Errores.class);
        Errores errores2 = mock(Errores.class);

        DTOPersona dtoPersona = mock(DTOPersona.class);
        IAccesoDatos accesoDatos = mock(IAccesoDatos.class);


        Date fecha = new Date(1990 - 1900, 1, 25);
        System.out.println(fecha);
        when(dtoPersona.getFechaDeNacimiento()).thenReturn(fecha);
        when(dtoPersona.getSexo()).thenReturn("Masculino");
        when(dtoPersona.getApellido()).thenReturn("Gonzalez");
        when(dtoPersona.getNombre()).thenReturn("Pablo");
        when(dtoPersona.getDni()).thenReturn("32246572");

        ValidadorDatosPersona validadorDatosPersona = new ValidadorDatosPersona(accesoDatos);
        validadorDatosPersona.validar(dtoPersona, errores1);
        validadorDatosPersona.validar(dtoPersona, errores2);

        verificacionExito(errores1);
        verificacionExito(errores2);

//        verify(errores1, times(0)).agregarError(eq("fechaDeNacimiento"), eq("La fecha de nacimiento no puede ser posterior a la fecha actual."));
//        verify(errores2, times(0)).agregarError(eq("cantidadDePuntosPermitidos"), eq("La cantidad de puntos solicitada no puede ser mayor a 15."));

    }

    @Test
    public void testValidarFracaso() {
        Errores errores1 = mock(Errores.class);
        Errores errores2 = mock(Errores.class);
        Errores errores3 = mock(Errores.class);

        DTOPersona dtoPersona = mock(DTOPersona.class);
        IAccesoDatos accesoDatos = mock(IAccesoDatos.class);

        Date fecha = GregorianCalendar.getInstance().getTime();


        when(dtoPersona.getFechaDeNacimiento()).thenReturn(null).thenReturn(fecha).thenReturn(new Date(1995 - 1900, 1, 25)).thenReturn(new Date(2013-1900,0,1));
        when(dtoPersona.getSexo()).thenReturn(null).thenReturn("cualquiera").thenReturn("M");
        when(dtoPersona.getApellido()).thenReturn(null).thenReturn("").thenReturn("1234");
        when(dtoPersona.getNombre()).thenReturn(null).thenReturn("").thenReturn("5678");
        when(dtoPersona.getDni()).thenReturn(null).thenReturn("").thenReturn("33953934");

        ValidadorDatosPersona validadorDatosPersona = new ValidadorDatosPersona(accesoDatos);
        validadorDatosPersona.validar(dtoPersona, errores1);
        validadorDatosPersona.validar(dtoPersona, errores2);
        validadorDatosPersona.validar(dtoPersona, errores3);

        verificacionFracaso(errores1);
        verificacionFracaso2(errores2);
        verificacionFracaso3(errores3);


//
//        verify(errores1, times(1)).agregarError(eq("fechaDeNacimiento"), eq("Debes ser mayor de 18 años."));
//        verify(errores1, times(1)).agregarError(eq("sexo"), eq("Debe especificar genero."));
//        verify(errores1, times(1)).agregarError(eq("apellido"), eq("Debe especificar apellido."));
//        verify(errores1, times(1)).agregarError(eq("nombre"), eq("Debe especificar nombre."));
//
//        verify(errores2, times(1)).agregarError(eq("fechaDeNacimiento"), eq("La fecha de nacimiento no puede ser posterior a la fecha actual."));
//        verify(errores2, times(1)).agregarError(eq("sexo"), eq("El genero debe ser masculino o femenino."));
//        verify(errores2, times(1)).agregarError(eq("apellido"), eq("El apellido solo puede estar compuesto de letras."));
//        verify(errores2, times(1)).agregarError(eq("nombre"), eq("El nombre solo puede estar compuesto de letras."));
//
//        verify(errores3, times(1)).agregarError(eq("fechaDeNacimiento"), eq("Edad incorrecta, no puedes ser mayor de 110 años."));

    }

    public void verificacionExito(Errores error) {

        System.out.println(error.parsearErrores());
        verify(error, times(0)).agregarError(eq("fechaDeNacimiento"), eq("Debe especificar una fecha de nacimiento."));
        verify(error, times(0)).agregarError(eq("fechaDeNacimiento"), eq("Debes ser mayor de 18 años."));
        verify(error, times(0)).agregarError(eq("fechaDeNacimiento"), eq("La fecha de nacimiento no puede ser posterior a la fecha actual."));
        verify(error, times(0)).agregarError(eq("fechaDeNacimiento"), eq("Edad incorrecta, no puedes ser mayor de 110 años."));
        verify(error, times(0)).agregarError(eq("sexo"), eq("Debe especificar genero."));
        verify(error, times(0)).agregarError(eq("sexo"), eq("El genero debe ser masculino o femenino."));
        verify(error, times(0)).agregarError(eq("apellido"), eq("Debe especificar apellido."));
        verify(error, times(0)).agregarError(eq("apellido"), eq("El apellido solo puede estar compuesto de letras."));
        verify(error, times(0)).agregarError(eq("nombre"), eq("Debe especificar nombre."));
        verify(error, times(0)).agregarError(eq("nombre"), eq("El nombre solo puede estar compuesto de letras."));
        verify(error, times(0)).agregarError(eq("dni"), eq("Debe especificar un numero de DNI"));
        verify(error, times(0)).agregarError(eq("dni"), eq("Ya existe un cliente con ese DNI creado."));

    }

    public void verificacionFracaso(Errores error) {

        verify(error, times(1)).agregarError(eq("fechaDeNacimiento"), eq("Debe especificar una fecha de nacimiento."));
        verify(error, times(1)).agregarError(eq("sexo"), eq("Debe especificar genero."));
        verify(error, times(1)).agregarError(eq("apellido"), eq("Debe especificar apellido."));
        verify(error, times(1)).agregarError(eq("nombre"), eq("Debe especificar nombre."));
        verify(error, times(1)).agregarError(eq("dni"), eq("Debe especificar un numero de DNI"));

    }

    public void verificacionFracaso2(Errores error) {
        verify(error, times(1)).agregarError(eq("fechaDeNacimiento"), eq("Debes ser mayor de 18 años."));
        verify(error, times(1)).agregarError(eq("sexo"), eq("El genero debe ser masculino o femenino."));
        verify(error, times(1)).agregarError(eq("apellido"), eq("El apellido solo puede estar compuesto de letras."));
        verify(error, times(1)).agregarError(eq("nombre"), eq("El nombre solo puede estar compuesto de letras."));
        }

    private void verificacionFracaso3(Errores error) {
        verify(error, times(1)).agregarError(eq("fechaDeNacimiento"), eq("La fecha de nacimiento no puede ser posterior a la fecha actual."));
        verify(error, times(1)).agregarError(eq("sexo"), eq("El genero debe ser masculino o femenino."));
        verify(error, times(1)).agregarError(eq("apellido"), eq("El apellido solo puede estar compuesto de letras."));
        verify(error, times(1)).agregarError(eq("nombre"), eq("El nombre solo puede estar compuesto de letras."));     
    }
}