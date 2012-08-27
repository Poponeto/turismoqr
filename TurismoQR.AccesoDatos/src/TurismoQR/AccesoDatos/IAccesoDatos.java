package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;
import org.hibernate.criterion.DetachedCriteria;

public interface IAccesoDatos
{

    public <E extends IObjetoNegocio> E BuscarObjeto(E Objeto);

    public <E extends IObjetoNegocio> E BuscarObjeto();

    public <E extends IObjetoNegocio> E BuscarObjeto(String idObjeto);

    public <E extends IObjetoNegocio> E BuscarObjeto(DetachedCriteria criteria);

    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos(DetachedCriteria criteria);

    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos(E Objeto);

    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos();

    public void Guardar(Collection<IObjetoNegocio> objetosNegocio);

    public void Guardar(IObjetoNegocio objetosNegocio);
}
