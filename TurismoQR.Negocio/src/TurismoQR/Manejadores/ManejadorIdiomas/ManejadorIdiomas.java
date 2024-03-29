/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Manejadores.ManejadorIdiomas;

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
@Service("manejadorIdiomas")
public class ManejadorIdiomas {

    private AccesoDatosIdioma accesoDatosIdioma;

    @Autowired
    public ManejadorIdiomas(AccesoDatosIdioma accesoDatosIdioma) {
        this.accesoDatosIdioma = accesoDatosIdioma;
    }

    public Collection<Idioma> obtenerPosiblesIdiomas() {
        return accesoDatosIdioma.BuscarConjuntoObjetos(Idioma.class);
    }

    public InformacionEnIdioma seleccionarInformacionDePuntoEnIdioma(Punto punto, Idioma idioma) {
         return seleccionarInformacionEnIdioma(punto.getInformacion().getInformacionEnIdiomas(), idioma);
    }

    public InformacionEnIdioma seleccionarInformacionDeImagenEnIdioma(Imagen imagen, Idioma idioma) {
        return seleccionarInformacionEnIdioma(imagen.getInformacion().getInformacionEnIdiomas(), idioma);
    }

    private InformacionEnIdioma seleccionarInformacionEnIdioma(Collection<InformacionEnIdioma> InformacionEnIdiomas, Idioma idioma) {
        for (InformacionEnIdioma informacionEnIdioma : InformacionEnIdiomas) {
           
            if (informacionEnIdioma.getIdioma()==idioma) {
                return informacionEnIdioma;
            }
        }

        return null;
    }

    public Idioma obtenerIdioma(String nombreIdioma) {
        if (nombreIdioma != null) {
            return accesoDatosIdioma.BuscarIdiomaPorNombre(nombreIdioma);
        }

        //Si no se especifica el idioma, se retorna el idioma por default
        return accesoDatosIdioma.BuscarObjeto(Idioma.class, "default");

    }
}
