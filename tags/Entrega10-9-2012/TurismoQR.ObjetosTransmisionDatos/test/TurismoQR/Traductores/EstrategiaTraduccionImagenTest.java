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

    private Imagen objetoNegocio;
    private DTOImagen dto;
    EstrategiaTraduccionImagen instance;

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
        objetoNegocio = new Imagen();
        objetoNegocio.setExtension("a");
        objetoNegocio.setUrl("b");

        dto = new DTOImagen();
        dto.setExtension("a");
        dto.setUrl("b");

        instance = new EstrategiaTraduccionImagen();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of traducir method, of class EstrategiaTraduccionImagen.
     */
    @Test
    public void testTraducir_Imagen() {

        DTOImagen result = (DTOImagen) instance.traducir(objetoNegocio);
        assertEquals(dto, result);
    }

    @Test
    public void testTraducir_DTOImagen() {

        Imagen result = instance.traducir(dto);
        assertEquals(objetoNegocio.getExtension(), result.getExtension());
        assertEquals(objetoNegocio.getInformacion(), result.getInformacion());
    }

}