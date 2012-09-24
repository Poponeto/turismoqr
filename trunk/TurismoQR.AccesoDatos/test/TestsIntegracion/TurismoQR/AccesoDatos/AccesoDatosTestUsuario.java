/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrius
 */
public class AccesoDatosTestUsuario {

    private static SessionFactory session;

    public AccesoDatosTestUsuario() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void testGuardarUsuario() {
        Usuario user = new Usuario();
        user.setNombreUsuario("rodrius");
        user.setContrasenia("1234");
       
        try{
        session = new AnnotationConfiguration().configure("/TurismoQR/ConfiguracionAccesoDatos/hibernate.cfg.xml").buildSessionFactory();

        //   GUARDAR USUARIO---------------
        AccesoDatos instance = new AccesoDatos(session);
        instance.iniciaOperacion();
        instance.Guardar(user);
        instance.terminaOperacion();
        System.out.println("Guardado con exito");}
        catch(HibernateException ex){
             // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
