/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Informacion.Idioma;
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
public class AccesoDatosIdiomaTest {

    public AccesoDatosIdiomaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of BuscarIdiomaPorNombre method, of class AccesoDatosIdioma.
     */
    @Test
    public void testBuscarIdiomaPorNombre()
    {
        System.out.println("BuscarIdiomaPorNombre");
        String nombreIdioma = "";
        AccesoDatosIdioma instance = null;
        Idioma expResult = null;
        Idioma result = instance.BuscarIdiomaPorNombre(nombreIdioma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}