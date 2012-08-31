/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import javax.annotation.Resource;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionPunto implements IEstrategiaTraduccion<Punto>{

    @Resource
    private ITraductor traductor;

    public IDTO<Punto> traducir(Punto objetoNegocio)
    {
        return new DTOPunto();
    }

}
