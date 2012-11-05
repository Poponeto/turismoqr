/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosNegocio.Usuarios.ContactoEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.ObjetosTransmisionDatos.DTOContactoEmpresa;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionContactoEmpresa extends EstrategiaTraduccionContacto implements IEstrategiaTraduccion<ContactoEmpresa> {

    public IDTO<ContactoEmpresa> traducir(ContactoEmpresa objetoNegocio)
    {
        DTOContactoEmpresa dtoContactoEmpresa = (DTOContactoEmpresa) iniciarContacto(objetoNegocio);

        dtoContactoEmpresa.setApellido(objetoNegocio.getApellido());
        dtoContactoEmpresa.setNombre(objetoNegocio.getNombre());
        dtoContactoEmpresa.setSexo(objetoNegocio.getSexo());

        return dtoContactoEmpresa;
    }

    public ContactoEmpresa traducir(IDTO<ContactoEmpresa> dto)
    {
        ContactoEmpresa contactoEmpresa = (ContactoEmpresa) iniciarContacto((DTOContactoEmpresa)dto);

        contactoEmpresa.setApellido(((DTOContactoEmpresa)dto).getApellido());
        contactoEmpresa.setNombre(((DTOContactoEmpresa)dto).getNombre());
        contactoEmpresa.setSexo(((DTOContactoEmpresa)dto).getSexo());

        return contactoEmpresa;
    }

    @Override
    protected DTOContacto crearDTOContacto()
    {
        return new DTOContactoEmpresa();
    }

    @Override
    protected Contacto crearContacto()
    {
        return new ContactoEmpresa();
    }
}

