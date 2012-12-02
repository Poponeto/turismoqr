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
        dtoCategoria.setIdCategoria(objetoNegocio.getIdObjeto());
        dtoCategoria.setNombreCategoria(objetoNegocio.getNombreCategoria());

        return dtoCategoria;
    }

    public Categoria traducir(IDTO<Categoria> dto)
    {
        Categoria categoria = new Categoria();
        categoria.setIdObjeto(((DTOCategoria)dto).getIdCategoria());
        categoria.setNombreCategoria(((DTOCategoria)dto).getNombreCategoria());

        return categoria;
    }
}
