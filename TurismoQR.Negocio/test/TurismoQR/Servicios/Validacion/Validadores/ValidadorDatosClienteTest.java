/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.Servicios.Validacion.Errores;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Federico
 */
public class ValidadorDatosClienteTest {

    public ValidadorDatosClienteTest() {
    }

    /**
     * Test of soportaObjeto method, of class ValidadorDatosCliente.
     */
    @Test
    public void testSoportaObjeto()
    {        
        DTOContacto dtoContacto = mock(DTOContacto.class);
        DTOCliente dtoCliente = mock(DTOCliente.class);
        DTOPersona dtoPersona = mock(DTOPersona.class);

        ValidadorDatosCliente validadorDatosCliente = new ValidadorDatosCliente();
        boolean resultadoDTOContacto = validadorDatosCliente.soportaObjeto(dtoContacto);
        boolean resultadoDTOCliente = validadorDatosCliente.soportaObjeto(dtoCliente);
        boolean resultadoDTOPersona = validadorDatosCliente.soportaObjeto(dtoPersona);

        assertFalse(resultadoDTOContacto);
        assertTrue(resultadoDTOCliente);
        assertTrue(resultadoDTOPersona);
    }

    /**
     * Test of validar method, of class ValidadorDatosCliente.
     */
    @Test
    public void testValidar()
    {
        Errores errores1 = mock(Errores.class);
        Errores errores2 = mock(Errores.class);

        DTOCliente dtoCliente = mock(DTOCliente.class);

        when(Integer.parseInt(dtoCliente.getCantidadDePuntosPermitidos())).thenReturn(-1).thenReturn(16);

        ValidadorDatosCliente validadorDatosCliente = new ValidadorDatosCliente();
        validadorDatosCliente.validar(dtoCliente, errores1);
        validadorDatosCliente.validar(dtoCliente, errores2);
        
        verify(errores1, times(1)).agregarError(eq("cantidadDePuntosPermitidos"), eq("La cantidad de puntos solicitada no puede ser negativa."));
        verify(errores2, times(1)).agregarError(eq("cantidadDePuntosPermitidos"), eq("La cantidad de puntos solicitada no puede ser mayor a 15."));

    }

}