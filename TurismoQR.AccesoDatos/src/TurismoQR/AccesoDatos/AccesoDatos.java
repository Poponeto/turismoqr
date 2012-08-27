package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
class AccesoDatos extends HibernateDaoSupport implements IAccesoDatos
{

    @Autowired
    public AccesoDatos(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

    @Transactional
    public <E extends IObjetoNegocio> E BuscarObjeto(E Objeto)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional
    public <E extends IObjetoNegocio> E BuscarObjeto(String idObjeto)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional
    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos(E Objeto)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional
    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional
    public <E extends IObjetoNegocio> E BuscarObjeto()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional
    public <E extends IObjetoNegocio> E BuscarObjeto(DetachedCriteria criteria)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional
    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos(DetachedCriteria criteria)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional
    public void Guardar(IObjetoNegocio objetoNegocio)
    {
        getHibernateTemplate().saveOrUpdate(objetoNegocio);
    }

    @Transactional
    public void Guardar(Collection<IObjetoNegocio> objetosNegocio)
    {
        for (IObjetoNegocio objetoNegocio : objetosNegocio)
        {
            getHibernateTemplate().saveOrUpdate(objetoNegocio);
        }
    }
}
