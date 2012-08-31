/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
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
public class EstrategiaTraduccionImagenTest {

    public EstrategiaTraduccionImagenTest() {
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
     * Test of traducir method, of class EstrategiaTraduccionImagen.
     */
    @Test
    public void testTraducir() {

        Imagen objetoNegocio = new Imagen();
        objetoNegocio.setExtension("a");
        objetoNegocio.setUrl("b");
        EstrategiaTraduccionImagen instance = new EstrategiaTraduccionImagen();
        DTOImagen expResult = new DTOImagen();
        expResult.setExtension("a");
        expResult.setUrl("b");
        DTOImagen result = (DTOImagen) instance.traducir(objetoNegocio);
        assertEquals(expResult, result);
    }

}