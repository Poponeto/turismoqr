/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import java.lang.reflect.ParameterizedType;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */
@Service("fabricaDeEstrategiaTraduccion")
public class FabricaDeEstrategiaTraduccion
{

    private final Class[] estrategias =
    {
        EstrategiaTraduccionImagen.class,
        EstrategiaTraduccionInformacionEnIdioma.class,
        EstrategiaTraduccionLocalizacion.class,
        EstrategiaTraduccionPunto.class,
        EstrategiaTraduccionUsuario.class,
        EstrategiaTraduccionIdioma.class
    };

    public IEstrategiaTraduccion crearEstrategiaTraduccion(IObjetoNegocio objetoNegocio)
    {
       return buscarEstrategiaTraduccion(objetoNegocio.getClass());
    }

    public IEstrategiaTraduccion crearEstrategiaTraduccion(IDTO dto)
    {
        ParameterizedType interfaceType = (ParameterizedType) dto.getClass().getGenericInterfaces()[0];

        return buscarEstrategiaTraduccion(((Class)interfaceType.getActualTypeArguments()[0]));
    }

    private IEstrategiaTraduccion buscarEstrategiaTraduccion(Class claseDeEstrategia)
    {
        for(Class estrategia : estrategias)
        {

            ParameterizedType interfaceType = (ParameterizedType)estrategia.getGenericInterfaces()[0];
            Class argumentClass = (Class)interfaceType.getActualTypeArguments()[0];

            if (argumentClass.equals(claseDeEstrategia))
            {
                try
                {
                    return (IEstrategiaTraduccion) estrategia.newInstance();
                }
                catch (InstantiationException ex)
                {
                    Logger.getLogger(FabricaDeEstrategiaTraduccion.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IllegalAccessException ex)
                {
                    Logger.getLogger(FabricaDeEstrategiaTraduccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }

        for(Class estrategia : estrategias)
        {

            ParameterizedType interfaceType = (ParameterizedType)estrategia.getGenericInterfaces()[0];
            Class argumentClass = (Class)interfaceType.getActualTypeArguments()[0];

            if (argumentClass.equals(claseDeEstrategia.getSuperclass()))
            {
                try
                {
                    return (IEstrategiaTraduccion) estrategia.newInstance();
                }
                catch (InstantiationException ex)
                {
                    Logger.getLogger(FabricaDeEstrategiaTraduccion.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IllegalAccessException ex)
                {
                    Logger.getLogger(FabricaDeEstrategiaTraduccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }

        return null;
    }
}
