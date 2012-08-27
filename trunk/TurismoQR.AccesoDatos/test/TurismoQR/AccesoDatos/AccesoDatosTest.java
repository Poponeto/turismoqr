/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;
import org.hibernate.criterion.DetachedCriteria;
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
public class AccesoDatosTest {

    public AccesoDatosTest() {
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
     * Test of BuscarObjeto method, of class AccesoDatos.
     */
    @Test
    public void testBuscarObjeto_GenericType()
    {
        System.out.println("BuscarObjeto");
        Object Objeto = null;
        AccesoDatos instance = null;
        Object expResult = null;
        //Object result = instance.BuscarObjeto(Objeto);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarObjeto method, of class AccesoDatos.
     */
    @Test
    public void testBuscarObjeto_String()
    {
        System.out.println("BuscarObjeto");
        String idObjeto = "";
        AccesoDatos instance = null;
        Object expResult = null;
        Object result = instance.BuscarObjeto(idObjeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarConjuntoObjetos method, of class AccesoDatos.
     */
    @Test
    public void testBuscarConjuntoObjetos_GenericType()
    {
        System.out.println("BuscarConjuntoObjetos");
        Object Objeto = null;
        AccesoDatos instance = null;
        Collection expResult = null;
        //Collection result = instance.BuscarConjuntoObjetos(Objeto);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarConjuntoObjetos method, of class AccesoDatos.
     */
    @Test
    public void testBuscarConjuntoObjetos()
    {
        System.out.println("BuscarConjuntoObjetos");
        AccesoDatos instance = null;
        Collection expResult = null;
        Collection result = instance.BuscarConjuntoObjetos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarObjeto method, of class AccesoDatos.
     */
    @Test
    public void testBuscarObjeto()
    {
        System.out.println("BuscarObjeto");
        AccesoDatos instance = null;
        Object expResult = null;
        Object result = instance.BuscarObjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarObjeto method, of class AccesoDatos.
     */
    @Test
    public void testBuscarObjeto_DetachedCriteria()
    {
        System.out.println("BuscarObjeto");
        DetachedCriteria criteria = null;
        AccesoDatos instance = null;
        Object expResult = null;
        Object result = instance.BuscarObjeto(criteria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarConjuntoObjetos method, of class AccesoDatos.
     */
    @Test
    public void testBuscarConjuntoObjetos_DetachedCriteria()
    {
        System.out.println("BuscarConjuntoObjetos");
        DetachedCriteria criteria = null;
        AccesoDatos instance = null;
        Collection expResult = null;
        Collection result = instance.BuscarConjuntoObjetos(criteria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Guardar method, of class AccesoDatos.
     */
    @Test
    public void testGuardar_IObjetoNegocio()
    {
        System.out.println("Guardar");
        IObjetoNegocio objetoNegocio = null;
        AccesoDatos instance = null;
        instance.Guardar(objetoNegocio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Guardar method, of class AccesoDatos.
     */
    @Test
    public void testGuardar_Collection()
    {
        System.out.println("Guardar");
        Collection<IObjetoNegocio> objetosNegocio = null;
        AccesoDatos instance = null;
        instance.Guardar(objetosNegocio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}