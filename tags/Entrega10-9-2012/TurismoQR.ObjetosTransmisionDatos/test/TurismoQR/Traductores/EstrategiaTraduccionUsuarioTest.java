/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import java.util.Collection;
import java.util.ArrayList;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.Permiso;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionUsuarioTest {

    private Usuario objetoNegocio;
    private DTOUsuario dto;
    private  EstrategiaTraduccionUsuario instance;

    @Before
    public void setUp() {
        objetoNegocio = new Usuario();

        objetoNegocio.setContraseña("a");
        objetoNegocio.setNombreUsuario("a");

        Permiso permiso = new Permiso();
        permiso.setNombre("a");

        PermisoUsuario permisoUsuario = new PermisoUsuario();
        permisoUsuario.setPermiso(permiso);
        
        Collection permisos = new ArrayList<PermisoUsuario>();
        permisos.add(permisoUsuario);
        
        objetoNegocio.setPermisosUsuario(permisos);

        instance = new EstrategiaTraduccionUsuario();
        dto = new DTOUsuario();

        dto.setContraseña("a");
        dto.setNombreUsuario("a");

        dto.agregarPermiso("a");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of traducir method, of class EstrategiaTraduccionUsuario.
     */
    @Test
    public void testTraducir_Usuario()
    {
        DTOUsuario result = (DTOUsuario) instance.traducir(objetoNegocio);
        assertEquals(dto, result);

    }


}