/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Usuarios.Empresa;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public class DTOEmpresa extends DTOCliente implements IDTO<Empresa> {

    private String cuit;
    private String razonSocial;
    private String rubro;

    private Collection<DTOContactoEmpresa> contactos;

    public Collection<DTOContactoEmpresa> getContactos()
    {
        return contactos;
    }

    public void setContactos(Collection<DTOContactoEmpresa> contactos)
    {
        this.contactos = contactos;
    }

    public String getRubro()
    {
        return rubro;
    }

    public void setRubro(String rubro)
    {
        this.rubro = rubro;
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
