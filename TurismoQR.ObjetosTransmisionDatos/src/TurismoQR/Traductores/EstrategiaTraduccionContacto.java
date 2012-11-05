/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public abstract class EstrategiaTraduccionContacto {

    protected DTOContacto iniciarContacto(Contacto objetoNegocio)
    {
        DTOContacto dtoContacto = this.crearDTOContacto();
        
        dtoContacto.setCelular(objetoNegocio.getCelular());
        dtoContacto.setMail(objetoNegocio.getMail());
        dtoContacto.setTelefonoFijo(objetoNegocio.getTelefonoFijo());

        return dtoContacto;
    }

    protected Contacto iniciarContacto(DTOContacto dto)
    {
        Contacto contacto = this.crearContacto();

        contacto.setCelular(dto.getCelular());
        contacto.setMail(dto.getMail());
        contacto.setTelefonoFijo(dto.getTelefonoFijo());

        return contacto;
    }

    protected abstract DTOContacto crearDTOContacto();
    protected abstract Contacto crearContacto();
}
