/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Federico
 */
public class FabricaDeEstrategiaTraduccionTest {

    
    private FabricaDeEstrategiaTraduccion instance;

    public FabricaDeEstrategiaTraduccionTest() {
    }


    @Before
    public void setUp() {
        
        instance = new FabricaDeEstrategiaTraduccion();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of crearEstrategiaTraduccion method, of class FabricaDeEstrategiaTraduccion.
     */
    @Test
    public void testCrearEstrategiaTraduccion_IObjetoNegocio()
    {
        IObjetoNegocio objetoNegocio = new Punto();
        IEstrategiaTraduccion result = instance.crearEstrategiaTraduccion(objetoNegocio);
        assertTrue(result instanceof EstrategiaTraduccionPunto);

    }

    /**
     * Test of crearEstrategiaTraduccion method, of class FabricaDeEstrategiaTraduccion.
     */
    @Test
    public void testCrearEstrategiaTraduccion_IDTO()
    {
        IDTO dto = new DTOPunto();
        IEstrategiaTraduccion result = instance.crearEstrategiaTraduccion(dto);
        assertTrue(result instanceof EstrategiaTraduccionPunto);

    }

}