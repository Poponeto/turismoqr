/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Punto.ManejadorIdiomas;

import java.util.Collection;
import java.util.ArrayList;
import TurismoQR.ObjetosNegocio.Informacion.Informacion;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
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
public class ManejadorIdiomasTest {

    public ManejadorIdiomasTest() {
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
     * Test of seleccionarInformacionDePuntoEnIdioma method, of class ManejadorIdiomas.
     */
    @Test
    public void testSeleccionarInformacionDePuntoEnIdioma()
    {
        System.out.println("seleccionarInformacionDePuntoEnIdioma");
        Punto punto = new Punto();
        Informacion informacion = new Informacion();

        Idioma idioma1 = new Idioma();
        Idioma idioma2 = new Idioma();
        idioma1.setIdObjeto("1");
        idioma2.setIdObjeto("2");

        Collection<InformacionEnIdioma> informacionEnIdiomas = new ArrayList<InformacionEnIdioma>();
        InformacionEnIdioma informacionEnIdioma1 = new InformacionEnIdioma();
        InformacionEnIdioma informacionEnIdioma2 = new InformacionEnIdioma();
        informacionEnIdioma1.setIdObjeto("1");
        informacionEnIdioma2.setIdObjeto("2");
        informacionEnIdioma1.setIdioma(idioma1);
        informacionEnIdioma2.setIdioma(idioma2);
        informacionEnIdiomas.add(informacionEnIdioma1);
        informacionEnIdiomas.add(informacionEnIdioma2);

        informacion.setInformacionEnIdiomas(informacionEnIdiomas);
        punto.setInformacion(informacion);

        ManejadorIdiomas manejadorIdiomas1 = new ManejadorIdiomas();
        InformacionEnIdioma resultado1 = manejadorIdiomas1.seleccionarInformacionDePuntoEnIdioma(punto, idioma1);
        assertEquals(informacionEnIdioma1, resultado1);

        ManejadorIdiomas manejadorIdiomas2 = new ManejadorIdiomas();
        InformacionEnIdioma resultado2 = manejadorIdiomas2.seleccionarInformacionDePuntoEnIdioma(punto, idioma2);
        assertEquals(informacionEnIdioma2, resultado2);
    }

    /**
     * Test of seleccionarInformacionDeImagenEnIdioma method, of class ManejadorIdiomas.
     */
    @Test
    public void testSeleccionarInformacionDeImagenEnIdioma()
    {
        System.out.println("seleccionarInformacionDePuntoEnIdioma");
        Imagen imagen = new Imagen();
        Informacion informacion = new Informacion();

        Idioma idioma1 = new Idioma();
        Idioma idioma2 = new Idioma();
        idioma1.setIdObjeto("1");
        idioma2.setIdObjeto("2");

        Collection<InformacionEnIdioma> informacionEnIdiomas = new ArrayList<InformacionEnIdioma>();
        InformacionEnIdioma informacionEnIdioma1 = new InformacionEnIdioma();
        InformacionEnIdioma informacionEnIdioma2 = new InformacionEnIdioma();
        informacionEnIdioma1.setIdObjeto("1");
        informacionEnIdioma2.setIdObjeto("2");
        informacionEnIdioma1.setIdioma(idioma1);
        informacionEnIdioma2.setIdioma(idioma2);
        informacionEnIdiomas.add(informacionEnIdioma1);
        informacionEnIdiomas.add(informacionEnIdioma2);

        informacion.setInformacionEnIdiomas(informacionEnIdiomas);
        imagen.setInformacion(informacion);

        ManejadorIdiomas manejadorIdiomas1 = new ManejadorIdiomas();
        InformacionEnIdioma resultado1 = manejadorIdiomas1.seleccionarInformacionDeImagenEnIdioma(imagen, idioma1);
        assertEquals(informacionEnIdioma1, resultado1);

        ManejadorIdiomas manejadorIdiomas2 = new ManejadorIdiomas();
        InformacionEnIdioma resultado2 = manejadorIdiomas2.seleccionarInformacionDeImagenEnIdioma(imagen, idioma2);
        assertEquals(informacionEnIdioma2, resultado2);
    }

    /**
     * Test of obtenerIdioma method, of class ManejadorIdiomas.
     */
    @Test
    public void testObtenerIdioma()
    {
        System.out.println("obtenerIdioma");
        String nombreIdioma = "";
        ManejadorIdiomas instance = null;
        Idioma expResult = null;
        Idioma result = instance.obtenerIdioma(nombreIdioma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}