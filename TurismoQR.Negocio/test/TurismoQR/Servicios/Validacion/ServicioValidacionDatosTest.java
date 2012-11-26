/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Servicios.Validacion.Validadores.*;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Federico
 */
public class ServicioValidacionDatosTest {

    public ServicioValidacionDatosTest() {
    }

    /**
     * Test of validarDatos method, of class ServicioValidacionDatos.
     */
    @Test
    public void testValidarDatos()
    {
        Validador validador1 = mock(Validador.class);
        Validador validador2 = mock(Validador.class);

        IDTO dto = mock(IDTO.class);

        when(validador1.soportaObjeto(anyObject())).thenReturn(Boolean.TRUE);
        when(validador2.soportaObjeto(anyObject())).thenReturn(Boolean.FALSE);
        
        IAccesoDatos accesoDatos = mock(IAccesoDatos.class);

        ServicioValidacionDatos servicioValidacionDatos = new ServicioValidacionDatos(accesoDatos);
        servicioValidacionDatos.setValidadores(new Validador[]{validador1, validador2});
        servicioValidacionDatos.validarDatos(dto);

        verify(validador1, times(1)).soportaObjeto( eq(dto) );
        verify(validador2, times(1)).soportaObjeto( eq(dto));
        verify(validador1, times(1)).validar( eq(dto), any(Errores.class));
        verify(validador2, never()).validar( eq(dto), any(Errores.class));

    }

}