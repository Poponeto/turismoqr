/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Punto.ManejadorIdiomas;

import TurismoQR.AccesoDatos.AccesoDatosIdioma;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */
@Service
public class ManejadorIdiomas
{
    private Idioma idioma;

    @Resource
    private AccesoDatosIdioma accesoDatosIdioma;

    @Autowired
    public ManejadorIdiomas(Idioma idioma)
    {
        this.idioma = idioma;
    }

    public InformacionEnIdioma seleccionarInformacionDePuntoEnIdioma(Punto punto)
    {
        return seleccionarInformacionEnIdioma(punto.getInformacion().getInformacionEnIdiomas());
    }
    
    public InformacionEnIdioma seleccionarInformacionDeImagenEnIdioma(Imagen imagen)
    {
        return seleccionarInformacionEnIdioma(imagen.getInformacion().getInformacionEnIdiomas());
    }

    private InformacionEnIdioma seleccionarInformacionEnIdioma(Collection<InformacionEnIdioma> InformacionEnIdiomas)
    {
        for (InformacionEnIdioma informacionEnIdioma : InformacionEnIdiomas)
        {
            if (informacionEnIdioma.getIdioma().equals(idioma))
            {
                return informacionEnIdioma;
            }
        }

        return null;
    }

    public Idioma obtenerIdioma(String nombreIdioma)
    {
        try
        {
            return accesoDatosIdioma.BuscarIdiomaPorNombre(nombreIdioma);
        }
        catch(Exception e)
        {
            //TODO
            return accesoDatosIdioma.BuscarIdiomaPorNombre("DEFAULT");
        }

    }

}
