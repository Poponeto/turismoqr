/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */

@Service
public class Traductor implements ITraductor {

    private FabricaDeEstrategiaTraduccion fabricaDeEstrategiaTraduccion;

    @Autowired
    public Traductor(FabricaDeEstrategiaTraduccion fabrica)
    {
        fabricaDeEstrategiaTraduccion = fabrica;
    }

    public <E extends IObjetoNegocio> IDTO<E> traducir(E objetoNegocio)
    {
        IEstrategiaTraduccion estrategiaTraduccion = fabricaDeEstrategiaTraduccion.crearEstrategiaTraduccion(objetoNegocio);
        return estrategiaTraduccion.traducir(objetoNegocio);
    }

}
