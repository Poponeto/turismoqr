/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.ObjetosNegocio.Usuarios.Permisos;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;

/**
 *
 * @author Federico
 */
public class Permiso implements IObjetoNegocio
{

    private String descripcion;
    private String nombre;
    private String idObjeto;

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
