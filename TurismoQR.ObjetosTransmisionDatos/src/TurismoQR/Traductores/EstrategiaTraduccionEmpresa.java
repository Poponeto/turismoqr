/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosNegocio.Usuarios.Empresa;
import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionEmpresa extends EstrategiaTraduccionCliente implements IEstrategiaTraduccion<Empresa>
{

    @Override
    protected DTOContacto crearDTOContacto()
    {
        return new DTOEmpresa();
    }

    @Override
    protected Contacto crearContacto()
    {
        return new Empresa();
    }

    public IDTO<Empresa> traducir(Empresa objetoNegocio)
    {
        DTOEmpresa dtoEmpresa = (DTOEmpresa)iniciarCliente(objetoNegocio);

        dtoEmpresa.setCuit(objetoNegocio.getCuit());
        dtoEmpresa.setRazonSocial(objetoNegocio.getRazonSocial());

        return dtoEmpresa;
    }

    public Empresa traducir(IDTO<Empresa> dto)
    {
        Empresa empresa = (Empresa)iniciarCliente((DTOEmpresa)dto);

        empresa.setCuit(((DTOEmpresa)dto).getCuit());
        empresa.setRazonSocial(((DTOEmpresa)dto).getRazonSocial());

        return empresa;

    }

}
