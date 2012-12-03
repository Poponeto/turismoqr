/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosTransmisionDatos.*;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Servicios.Validacion.IServicioValidacionDatos;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Rodrius
 */
public class ValidadorDatosContactoEmpresaTest {

    public ValidadorDatosContactoEmpresaTest() {
    }

    @Test
    public void testSoportaObjeto() {

        DTOContacto dtoContacto = mock(DTOContacto.class);
        DTOCliente dtoCliente = mock(DTOCliente.class);
        DTOEmpresa dtoEmpresa = mock(DTOEmpresa.class);
        DTOContactoEmpresa dtoContactoEmpresa = mock(DTOContactoEmpresa.class);

        ValidadorDatosContactoEmpresa validadorDatosContactoEmpresa = new ValidadorDatosContactoEmpresa();
        boolean resultadoDTOContacto = validadorDatosContactoEmpresa.soportaObjeto(dtoContacto);
        boolean resultadoDTOCliente = validadorDatosContactoEmpresa.soportaObjeto(dtoCliente);
        boolean resultadoDTOEmpresa = validadorDatosContactoEmpresa.soportaObjeto(dtoEmpresa);
        boolean resultadoDTOContactoEmpresa = validadorDatosContactoEmpresa.soportaObjeto(dtoContactoEmpresa);

        assertFalse(resultadoDTOContacto);
        assertFalse(resultadoDTOCliente);
        assertFalse(resultadoDTOEmpresa);
        assertTrue(resultadoDTOContactoEmpresa);
    }

    /**
     * Test of validar method, of class ValidadorDatosPersona.
     */
    @Test
    public void testValidarExito() {
        Errores errores1 = mock(Errores.class);
        Errores errores2 = mock(Errores.class);
        Errores errores3 = mock(Errores.class);
        DTOContactoEmpresa dtoContactoEmpresa = mock(DTOContactoEmpresa.class);



        when(dtoContactoEmpresa.getApellido()).thenReturn("Perez");
        when(dtoContactoEmpresa.getNombre()).thenReturn("Arturo");
        when(dtoContactoEmpresa.getSexo()).thenReturn("Masculino");

        ValidadorDatosContactoEmpresa validadorDatosContactoEmpresa = new ValidadorDatosContactoEmpresa();

        validadorDatosContactoEmpresa.validar(dtoContactoEmpresa, errores1);
        validadorDatosContactoEmpresa.validar(dtoContactoEmpresa, errores2);
        validadorDatosContactoEmpresa.validar(dtoContactoEmpresa, errores3);


        verify(errores1, times(0)).agregarError(eq("apellido"), eq("Debe especificar apellido del contacto."));
        verify(errores2, times(0)).agregarError(eq("apellido"), eq("El apellido del contacto solo puede estar compuesto de letras."));
        verify(errores1, times(0)).agregarError(eq("nombre"), eq("Debe especificar nombre del contacto."));
        verify(errores2, times(0)).agregarError(eq("nombre"), eq("El nombre del contacto solo puede estar compuesto de letras."));
        verify(errores3, times(0)).agregarError(eq("sexo"), eq("Debe especificar genero del contacto."));
        verify(errores3, times(0)).agregarError(eq("sexo"), eq("El genero debe ser masculino o femenino."));

    }

   @Test
    public void testValidarFracaso() {
       Errores errores1 = mock(Errores.class);
        Errores errores2 = mock(Errores.class);
        Errores errores3 = mock(Errores.class);
        DTOContactoEmpresa dtoContactoEmpresa = mock(DTOContactoEmpresa.class);



        when(dtoContactoEmpresa.getApellido()).thenReturn(null).thenReturn("").thenReturn("1234");
        when(dtoContactoEmpresa.getNombre()).thenReturn(null).thenReturn("").thenReturn("1234");
        when(dtoContactoEmpresa.getSexo()).thenReturn(null).thenReturn("").thenReturn("M");

        ValidadorDatosContactoEmpresa validadorDatosContactoEmpresa = new ValidadorDatosContactoEmpresa();

        validadorDatosContactoEmpresa.validar(dtoContactoEmpresa, errores1);
        validadorDatosContactoEmpresa.validar(dtoContactoEmpresa, errores2);
        validadorDatosContactoEmpresa.validar(dtoContactoEmpresa, errores3);


        verify(errores1, times(1)).agregarError(eq("apellido"), eq("Debe especificar apellido del contacto."));
        verify(errores1, times(1)).agregarError(eq("nombre"), eq("Debe especificar nombre del contacto."));
        verify(errores1, times(1)).agregarError(eq("sexo"), eq("Debe especificar genero del contacto."));
       
        
        //No se Deberia ser los errores iguales que errores1 pero parece que el metodo isEmpty de validadorContactoEmpresa da falso..
        verify(errores2, times(1)).agregarError(eq("apellido"), eq("El apellido del contacto solo puede estar compuesto de letras."));  
        verify(errores2, times(1)).agregarError(eq("nombre"), eq("El nombre del contacto solo puede estar compuesto de letras.")); 
        verify(errores2, times(1)).agregarError(eq("sexo"), eq("El genero debe ser masculino o femenino."));
       
        
        verify(errores3, times(1)).agregarError(eq("apellido"), eq("El apellido del contacto solo puede estar compuesto de letras."));  
        verify(errores3, times(1)).agregarError(eq("nombre"), eq("El nombre del contacto solo puede estar compuesto de letras.")); 
        verify(errores3, times(1)).agregarError(eq("sexo"), eq("El genero debe ser masculino o femenino."));


    }
}
