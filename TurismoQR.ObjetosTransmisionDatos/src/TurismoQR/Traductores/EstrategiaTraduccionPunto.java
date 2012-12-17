/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionPunto implements IEstrategiaTraduccion<Punto>{

    public IDTO<Punto> traducir(Punto objetoNegocio)
    {
        DTOPunto dtoPunto = new DTOPunto();
        dtoPunto.setIdPunto(objetoNegocio.getIdObjeto());
        dtoPunto.setNombrePunto(objetoNegocio.getNombre());
        dtoPunto.setFechaCreacion(objetoNegocio.getFechaCreacion());
        dtoPunto.setFechaModificacion(objetoNegocio.getFechaModificacion());
        dtoPunto.setCantidadDeVisitas(objetoNegocio.getCantidadDeVisitas());
        return dtoPunto;
    }

    public Punto traducir(IDTO<Punto> dto)
    {
        Punto punto = new Punto();
        punto.setIdObjeto(((DTOPunto)dto).getIdPunto());
        punto.setNombre(((DTOPunto)dto).getNombrePunto());
        punto.setFechaCreacion(((DTOPunto)dto).getFechaCreacion());
        punto.setFechaModificacion(((DTOPunto)dto).getFechaModificacion());
        punto.setCantidadDeVisitas(((DTOPunto)dto).getCantidadDeVisitas());
        return punto;
    }

}
