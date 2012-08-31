/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
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
public class EstrategiaTraduccionInformacionEnIdiomaTest {

    public EstrategiaTraduccionInformacionEnIdiomaTest() {
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
     * Test of traducir method, of class EstrategiaTraduccionInformacionEnIdioma.
     */
    @Test
    public void testTraducir() {

        InformacionEnIdioma objetoNegocio = new InformacionEnIdioma();
        objetoNegocio.setTexto("info");
        EstrategiaTraduccionInformacionEnIdioma instance = new EstrategiaTraduccionInformacionEnIdioma();
        DTOInformacionEnIdioma expResult = new DTOInformacionEnIdioma();
        expResult.setTexto("info");
        DTOInformacionEnIdioma result = (DTOInformacionEnIdioma) instance.traducir(objetoNegocio);
        assertEquals(expResult, result);
 
    }

}