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

    private InformacionEnIdioma objetoNegocio;
    private DTOInformacionEnIdioma dto;
    private  EstrategiaTraduccionInformacionEnIdioma instance;

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
        objetoNegocio = new InformacionEnIdioma();
        objetoNegocio.setTexto("info");

        dto = new DTOInformacionEnIdioma();
        dto.setTexto("info");

        instance = new EstrategiaTraduccionInformacionEnIdioma();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of traducir method, of class EstrategiaTraduccionInformacionEnIdioma.
     */
    @Test
    public void testTraducir_InformacionEnIdioma() {
        DTOInformacionEnIdioma result = (DTOInformacionEnIdioma) instance.traducir(objetoNegocio);
        assertEquals(dto, result);
    }

    @Test
    public void testTraducir_DTOInformacionEnIdioma() {
        InformacionEnIdioma result = instance.traducir(dto);
        assertEquals(objetoNegocio.getNombre(), result.getNombre());
        assertEquals(objetoNegocio.getTexto(), result.getTexto());
    }

}