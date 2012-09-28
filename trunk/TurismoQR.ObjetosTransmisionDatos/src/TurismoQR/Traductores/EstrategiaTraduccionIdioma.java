/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionIdioma implements IEstrategiaTraduccion<Idioma> {

    public IDTO<Idioma> traducir(Idioma objetoNegocio)
    {
        DTOIdioma dtoIdioma = new DTOIdioma();
        dtoIdioma.setNombreIdioma(objetoNegocio.getNombreIdioma());

        return dtoIdioma;
    }

    public Idioma traducir(IDTO<Idioma> dto)
    {
        Idioma idioma = new Idioma();
        idioma.setNombreIdioma(((DTOIdioma)dto).getNombreIdioma());

        return idioma;
    }

}
