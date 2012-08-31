/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ftacchini
 */
public class EstrategiaTraduccionPuntoTest {

    public EstrategiaTraduccionPuntoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of traducir method, of class EstrategiaTraduccionPunto.
     */
    @Test
    public void testTraducir() {
        System.out.println("traducir");
        Punto objetoNegocio = null;
        EstrategiaTraduccionPunto instance = new EstrategiaTraduccionPunto();
        IDTO expResult = null;
        IDTO result = instance.traducir(objetoNegocio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}