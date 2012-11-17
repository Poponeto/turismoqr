/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Idioma;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Manejadores.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */

@Service
public class ServicioIdioma implements IServicioIdioma
{

    private ManejadorIdiomas manejadorIdioma;
    private ITraductor traductor;
    private IAccesoDatos accesoDatos;

    @Autowired
    public ServicioIdioma(ManejadorIdiomas manejadorIdioma, ITraductor traductor, IAccesoDatos accesoDatos)
    {
        this.manejadorIdioma = manejadorIdioma;
        this.traductor = traductor;
        this.accesoDatos = accesoDatos;
    }


    public ManejadorIdiomas getManejadorIdioma()
    {
        return manejadorIdioma;
    }

    public void setManejadorIdioma(ManejadorIdiomas manejadorIdioma)
    {
        this.manejadorIdioma = manejadorIdioma;
    }

    public ITraductor getTraductor()
    {
        return traductor;
    }

    public void setTraductor(ITraductor traductor)
    {
        this.traductor = traductor;
    }

    /*
     * Devuelve todos los idiomas posibles para la información de un punto de interés
     */
    public Collection<DTOIdioma> consultarPosiblesIdiomas()
    {
        Collection<Idioma> idiomas = getManejadorIdioma().obtenerPosiblesIdiomas();
        Collection<DTOIdioma> dtoIdiomas = new ArrayList<DTOIdioma>();

        for (Idioma idioma : idiomas)
        {
            dtoIdiomas.add((DTOIdioma) getTraductor().traducir(idioma));
        }

        return dtoIdiomas;
    }

    /*
     * Devuelve todos los idiomas posibles para la información de un punto de interés
     * específico
     */
    public Collection<DTOIdioma> consultarPosiblesIdiomas(String idPuntoInteres)
    {

        Punto punto = accesoDatos.BuscarObjeto(Punto.class, idPuntoInteres);

        Collection<DTOIdioma> dtoIdiomas = new ArrayList<DTOIdioma>();

        for (InformacionEnIdioma informacionEnIdioma : punto.getInformacion().getInformacionEnIdiomas())
        {
            dtoIdiomas.add((DTOIdioma) getTraductor().traducir(informacionEnIdioma.getIdioma()));
        }

        //Agrega todos los idiomas posibles de las imagenes si estos no fueron ya agregados
        for (Imagen imagen : punto.getImagenes())
        {
            if(imagen.getInformacion() != null) {
                for (InformacionEnIdioma informacionEnIdioma : imagen.getInformacion().getInformacionEnIdiomas())
                {
                    DTOIdioma dtoIdioma = (DTOIdioma) getTraductor().traducir(informacionEnIdioma.getIdioma());

                    if (!dtoIdiomas.contains(dtoIdioma))
                    {
                        dtoIdiomas.add(dtoIdioma);
                    }
                }
            }
        }

        return dtoIdiomas;
    }
}
