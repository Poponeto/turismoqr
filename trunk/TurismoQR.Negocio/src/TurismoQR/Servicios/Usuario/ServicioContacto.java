/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Traductores.ITraductor;

/**
 *
 * @author Federico
 */
public abstract class ServicioContacto {

    private ITraductor traductor;
    private IAccesoDatos accesoDatos;

    public ServicioContacto(
            IAccesoDatos accesoDatos,
            ITraductor traductor)
    {
        this.traductor = traductor;
        this.accesoDatos = accesoDatos;

    }

    protected Contacto registrarContacto(IDTO dtoContacto)
    {
        Contacto contacto = (Contacto) traductor.traducir(dtoContacto);

        return (contacto);
    }

    protected void actualizarDatosContacto(Contacto contacto, DTOContacto dtoContacto)
    {
        contacto.setMail(dtoContacto.getMail());
        contacto.setTelefonoFijo(dtoContacto.getTelefonoFijo());
        contacto.setCelular(dtoContacto.getCelular());
    }
    
    public IAccesoDatos getAccesoDatos()
    {
        return accesoDatos;
    }

    public void setAccesoDatos(IAccesoDatos accesoDatos)
    {
        this.accesoDatos = accesoDatos;
    }

    protected ITraductor getTraductor()
    {
        return traductor;
    }

    protected void setTraductor(ITraductor traductor)
    {
        this.traductor = traductor;
    }

}
