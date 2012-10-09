/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
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
public class EstrategiaTraduccionIdiomaTest {

    Idioma objetoNegocio;
    EstrategiaTraduccionIdioma instance;
    DTOIdioma dto;

    public EstrategiaTraduccionIdiomaTest() {
    }

    @Before
    public void setUp() {
        objetoNegocio = new Idioma();
        objetoNegocio.setNombreIdioma("idioma");
        dto = new DTOIdioma();
        dto.setNombreIdioma("idioma");
        instance = new EstrategiaTraduccionIdioma();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of traducir method, of class EstrategiaTraduccionIdioma.
     */
    @Test
    public void testTraducir_Idioma()
    {       
        DTOIdioma result = (DTOIdioma) instance.traducir(objetoNegocio);
        assertEquals(dto, result);
    }

    /**
     * Test of traducir method, of class EstrategiaTraduccionIdioma.
     */
    @Test
    public void testTraducir_IDTO()
    {
        Idioma result = instance.traducir(dto);
        assertEquals(objetoNegocio.getNombreIdioma(), result.getNombreIdioma());
    }

}