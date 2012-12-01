/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */

@Service("traductor")
public class Traductor implements ITraductor {

    private FabricaDeEstrategiaTraduccion fabricaDeEstrategiaTraduccion;

    @Autowired
    public Traductor(FabricaDeEstrategiaTraduccion fabrica)
    {
        fabricaDeEstrategiaTraduccion = fabrica;
    }

    public <E extends IObjetoNegocio> IDTO<E> traducir(E objetoNegocio)
    {
        String a = objetoNegocio.getIdObjeto();
        IEstrategiaTraduccion estrategiaTraduccion = fabricaDeEstrategiaTraduccion.crearEstrategiaTraduccion(objetoNegocio);
        return estrategiaTraduccion.traducir(objetoNegocio);
    }

    public <E extends IObjetoNegocio> E traducir(IDTO<E> dto)
    {
        IEstrategiaTraduccion estrategiaTraduccion = fabricaDeEstrategiaTraduccion.crearEstrategiaTraduccion(dto);
        return (E) estrategiaTraduccion.traducir(dto);

    }

    public Collection<IDTO> traducir(Collection<IObjetoNegocio> objetosNegocio)
    { 
        Collection<IDTO> objetosNegocioTraducidos = new ArrayList<IDTO>();

        for(IObjetoNegocio objetoNegocio : objetosNegocio)
        {
            objetosNegocioTraducidos.add(traducir(objetoNegocio));
        }
        
        return objetosNegocioTraducidos;
    }

}
