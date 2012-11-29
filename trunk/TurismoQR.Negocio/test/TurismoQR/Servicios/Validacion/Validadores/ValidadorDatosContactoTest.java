/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.Servicios.Validacion.Errores;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import TurismoQR.Servicios.Validacion.Errores;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Federico
 */
public class ValidadorDatosContactoTest {

    public ValidadorDatosContactoTest() {
    }

    /**
     * Test of soportaObjeto method, of class ValidadorDatosContacto.
     */
    @Test
    public void testSoportaObjeto() {
        System.out.println("soportaObjeto");

        DTOContacto dtoContacto = mock(DTOContacto.class);
        ValidadorDatosContacto instance = new ValidadorDatosContacto();
        boolean expResult = true;
        boolean resultadoDTOContacto = instance.soportaObjeto(dtoContacto);
        assertEquals(expResult, resultadoDTOContacto);

    }

    /**
     * Test of validar method, of class ValidadorDatosContacto.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        Errores errores1 = mock(Errores.class);
        Errores errores2 = mock(Errores.class);
        Errores errores3 = mock(Errores.class);
        Errores errores4 = mock(Errores.class);
        DTOContacto dtoContacto = mock(DTOContacto.class);

        when(dtoContacto.getMail()).thenReturn(null).thenReturn("cualquiera");
        when(dtoContacto.getCelular()).thenReturn(null).thenReturn("otra cosa");

        ValidadorDatosContacto validadorDatosContacto = new ValidadorDatosContacto();
        validadorDatosContacto.validar(dtoContacto, errores1);
        validadorDatosContacto.validar(dtoContacto, errores2);
        validadorDatosContacto.validar(dtoContacto, errores3);
        validadorDatosContacto.validar(dtoContacto, errores4);

        verify(errores1, times(1)).agregarError(eq("mail"), eq("La direccion de Email no puede ser nula."));
        verify(errores2, times(1)).agregarError(eq("mail"), eq("La direccion de Email no tiene un formato valido."));
        verify(errores3, times(1)).agregarError(eq("celular"), eq("La numero de celular no puede ser nulo."));
        verify(errores4, times(1)).agregarError(eq("celular"), eq("El numero de celular no tiene un formato válido."));

    }

   
    
}