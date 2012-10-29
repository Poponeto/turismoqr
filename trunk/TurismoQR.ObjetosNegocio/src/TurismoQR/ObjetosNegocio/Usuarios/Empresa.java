/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.Categorias.Rubro;
import java.util.Collection;

/**
 *
 * @author ftacchini
 */
public class Empresa extends Cliente{

    private String cuit;
    private String razonSocial;
    private Collection<ContactoEmpresa> contactos;
    private Rubro rubro;

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Collection<ContactoEmpresa> getContactos() {
        return contactos;
    }

    public void setContactos(Collection<ContactoEmpresa> contactos) {
        this.contactos = contactos;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
 
}
