/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.AccesoDatos;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.MySQLDialect;

/**
 *
 * @author Federico
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccesoDatos instance = new AccesoDatos();
        instance.iniciaOperacion();
        Configuration cfg = new Configuration();
        cfg.addJar(new File("D://Documentos//Proyecto 2012//TurismoQR.AccesoDatos//dist//TurismoQR.AccesoDatos.jar"));
        String[] lines = cfg.generateSchemaCreationScript(new MySQLDialect());
        try {
            for (int i = 0; i < lines.length; i++) {
             // System.out.println(lines[i] + ";");
              instance.ejecutarSQL(lines[i]);
            }
        } catch (HibernateException ex) {
            instance.manejaExcepcion(ex);
        }
    }
}
