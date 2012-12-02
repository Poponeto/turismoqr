/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import java.util.Collection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Federico
 */

@Repository
public class AccesoDatosUsuario extends AccesoDatos  {
    
    @Autowired
    public AccesoDatosUsuario(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    public Usuario buscarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException
    {

                Collection<Usuario> usuarios =  BuscarObjetosPorCaracteristica(Usuario.class, "nombreUsuario", nombreUsuario);

                if (usuarios == null || usuarios.isEmpty())
                {
                    throw new UsernameNotFoundException("El usuario nombre de " +nombreUsuario+ " no existe.");
                }

                return (Usuario) usuarios.toArray()[0];


    }

}
