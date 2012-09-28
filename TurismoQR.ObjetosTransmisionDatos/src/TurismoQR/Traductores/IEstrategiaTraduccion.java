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
public interface IEstrategiaTraduccion<E extends IObjetoNegocio>
{

    public IDTO<E> traducir(E objetoNegocio);

    public E traducir(IDTO<E> dto);
}
