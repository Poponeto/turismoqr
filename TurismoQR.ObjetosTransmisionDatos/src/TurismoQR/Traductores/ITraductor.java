/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public interface ITraductor
{

    public <E extends IObjetoNegocio> IDTO<E> traducir(E objetoNegocio);

    public <E extends IObjetoNegocio> E traducir(IDTO<E> objetoNegocio);
}
