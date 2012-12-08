/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Rol;
import TurismoQR.ObjetosTransmisionDatos.DTORol;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionRol implements IEstrategiaTraduccion<Rol>{

    public IDTO<Rol> traducir(Rol objetoNegocio)
    {
        DTORol dtoRol = new DTORol();
        
        dtoRol.setNombreRol(objetoNegocio.getIdObjeto());

        return dtoRol;
    }

    public Rol traducir(IDTO<Rol> dto)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
