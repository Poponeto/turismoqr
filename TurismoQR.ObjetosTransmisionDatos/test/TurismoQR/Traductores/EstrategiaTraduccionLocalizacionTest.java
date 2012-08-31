/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Punto.Localizacion;
import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
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
public class EstrategiaTraduccionLocalizacionTest {

    public EstrategiaTraduccionLocalizacionTest() {
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
     * Test of traducir method, of class EstrategiaTraduccionLocalizacion.
     */
    @Test
    public void testTraducir() {

        Localizacion objetoNegocio = new Localizacion();
        objetoNegocio.setLatitud("1");
        objetoNegocio.setLongitud("1");
        EstrategiaTraduccionLocalizacion instance = new EstrategiaTraduccionLocalizacion();
        DTOLocalizacion expResult = new DTOLocalizacion();
        expResult.setLatitud("1");
        expResult.setLongitud("1");
        DTOLocalizacion result = (DTOLocalizacion) instance.traducir(objetoNegocio);
        assertEquals(expResult, result);
    
    }

}