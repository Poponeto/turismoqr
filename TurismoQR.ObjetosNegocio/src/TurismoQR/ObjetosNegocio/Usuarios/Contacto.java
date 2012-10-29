/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;

/**
 *
 * @author ftacchini
 */
public abstract class Contacto implements IObjetoNegocio {

    private String mail;
    private String celular;
    private String telefonoFijo;
    private String idObjeto;
    
    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getTelefonoFijo()
    {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo)
    {
        this.telefonoFijo = telefonoFijo;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

}
