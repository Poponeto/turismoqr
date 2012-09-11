/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public Usuario buscarUsuario(String nombreUsuario)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Usuario.class);
        DetachedCriteria buscarUsuario = criterioDeBusqueda.createCriteria("BuscarUsuario");

        buscarUsuario.add(Restrictions.eq("nombreUsuario", nombreUsuario));

        return BuscarObjeto(buscarUsuario);
    }

}
