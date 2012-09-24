/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Informacion;

import TurismoQR.ObjetosNegocio.Recurso.Recurso;

/**
 *
 * @author Federico
 */
public class Imagen extends Recurso {

    private String extension;
    private Informacion informacion;

    public Informacion getInformacion()
    {
        return informacion;
    }

    public void setInformacion(Informacion informacion)
    {
        this.informacion = informacion;
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }


}
