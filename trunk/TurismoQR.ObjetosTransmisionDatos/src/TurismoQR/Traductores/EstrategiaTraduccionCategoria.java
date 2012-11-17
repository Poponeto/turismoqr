/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Chelo
 */
public class EstrategiaTraduccionCategoria implements IEstrategiaTraduccion<Categoria> {
    public IDTO<Categoria> traducir(Categoria objetoNegocio)
    {
        DTOCategoria dtoCategoria = new DTOCategoria();
        dtoCategoria.setNombreCategoria(objetoNegocio.getNombreCategoria());

        return dtoCategoria;
    }

    public Categoria traducir(IDTO<Categoria> dto)
    {
        Categoria idioma = new Categoria();
        idioma.setNombreCategoria(((DTOCategoria)dto).getNombreCategoria());

        return idioma;
    }
}
