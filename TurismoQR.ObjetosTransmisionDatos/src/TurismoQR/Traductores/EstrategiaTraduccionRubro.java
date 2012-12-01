/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Categorias.Rubro;
import TurismoQR.ObjetosTransmisionDatos.DTORubro;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionRubro implements IEstrategiaTraduccion<Rubro>{

    public IDTO<Rubro> traducir(Rubro objetoNegocio)
    {
        DTORubro dtoRubro = new DTORubro();
        dtoRubro.setNombreRubro(objetoNegocio.getNombreRubro());
        return dtoRubro;
    }

    public Rubro traducir(IDTO<Rubro> dto)
    {
        Rubro rubro = new Rubro();
        rubro.setNombreRubro(((DTORubro)dto).getNombreRubro());
        return rubro;
    }

}
