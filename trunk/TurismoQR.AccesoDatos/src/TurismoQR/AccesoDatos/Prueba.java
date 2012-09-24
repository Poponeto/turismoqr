/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Rodrius
 */
public class Prueba {

    private static SessionFactory session;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario user = new Usuario();
        user.setNombreUsuario("rodrius");
        user.setContrasenia("1234");
        try {

            session = new AnnotationConfiguration().configure("/TurismoQR/ConfiguracionAccesoDatos/hibernate.cfg.xml").buildSessionFactory();
//GUARDAR USUARIO---------------
//            AccesoDatos instance = new AccesoDatos(session);
//            instance.iniciaOperacion();
//            instance.Guardar(user);
//            instance.terminaOperacion();
//            System.out.println("Guardado con exito");
//---------------------
           
 AccesoDatos instance = new AccesoDatos(session);
          instance.iniciaOperacion();
          user=instance.BuscarObjeto(user);
            System.out.println("Usuario: "+ user.getIdObjeto());
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}
