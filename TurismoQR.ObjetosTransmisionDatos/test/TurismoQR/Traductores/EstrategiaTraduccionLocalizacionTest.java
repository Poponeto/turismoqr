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

    Localizacion objetoNegocio;
    DTOLocalizacion dto;
    EstrategiaTraduccionLocalizacion instance;

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
        objetoNegocio = new Localizacion();
        objetoNegocio.setLatitud("1");
        objetoNegocio.setLongitud("1");
        instance = new EstrategiaTraduccionLocalizacion();
        dto = new DTOLocalizacion();
        dto.setLatitud("1");
        dto.setLongitud("1");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of traducir method, of class EstrategiaTraduccionLocalizacion.
     */
    @Test
    public void testTraducir_Localizacion() {
 
        DTOLocalizacion result = (DTOLocalizacion) instance.traducir(objetoNegocio);
        assertEquals(dto, result);
    
    }

    @Test
    public void testTraducir_DTOLocalizacion() {

        Localizacion result = instance.traducir(dto);
        assertEquals(objetoNegocio.getLatitud(), result.getLatitud());
        assertEquals(objetoNegocio.getLongitud(), result.getLongitud());

    }

}