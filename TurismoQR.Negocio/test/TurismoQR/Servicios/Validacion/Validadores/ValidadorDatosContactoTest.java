/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.Servicios.Validacion.Errores;
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
public class ValidadorDatosContactoTest {

    public ValidadorDatosContactoTest() {
    }

    /**
     * Test of soportaObjeto method, of class ValidadorDatosContacto.
     */
    @Test
    public void testSoportaObjeto()
    {
        System.out.println("soportaObjeto");
        Object objeto = null;
        ValidadorDatosContacto instance = new ValidadorDatosContacto();
        boolean expResult = false;
        boolean result = instance.soportaObjeto(objeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validar method, of class ValidadorDatosContacto.
     */
    @Test
    public void testValidar()
    {
        System.out.println("validar");
        Object objeto = null;
        Errores errores = null;
        ValidadorDatosContacto instance = new ValidadorDatosContacto();
        instance.validar(objeto, errores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}