/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Categorias.Rubro;
import TurismoQR.ObjetosTransmisionDatos.DTOContactoEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Servicios.Validacion.IServicioValidacionDatos;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public abstract class ValidarDatosEmpresaBase implements Validador{


    protected IAccesoDatos accesoDatos;
    protected IServicioValidacionDatos servicioValidacionDatos;

    public ValidarDatosEmpresaBase(IAccesoDatos accesoDatos, IServicioValidacionDatos servicioValidacionDatos)
    {
        this.accesoDatos = accesoDatos;
        this.servicioValidacionDatos = servicioValidacionDatos;
    }


    public boolean soportaObjeto(Object objeto)
    {
        //Si es nulo entonces no es actualizacion
        if(objeto instanceof DTOEmpresa && esActualizacion((DTOEmpresa)objeto))
        {
            return true;
        }

        return false;
    }

    public void validar(Object objeto, Errores errores)
    {
        DTOEmpresa dtoEmpresa = (DTOEmpresa) objeto;

        if(dtoEmpresa.getRazonSocial() == null || dtoEmpresa.getRazonSocial().isEmpty())
        {
            errores.agregarError("razonSocial", "Debe especificar Razon Social de la empresa.");
        }

        String regexCuitEmpresa = "\\d{2}\\-\\d{8}\\-\\d";

        if (dtoEmpresa.getCuit() == null || dtoEmpresa.getCuit().isEmpty())
        {
            errores.agregarError("cuit", "Debe especificar un numero de CUIT.");
        }
        else if (!dtoEmpresa.getCuit().matches(regexCuitEmpresa))
        {
            errores.agregarError("cuit", "El CUIT no tiene un formato valido. El formato es nn-nnnnnnnn-n");
        }
        else
        {
            analizarErroresCUIT(dtoEmpresa,errores);
        }

        if (dtoEmpresa.getRubro() == null || dtoEmpresa.getRubro().getNombreRubro() == null || dtoEmpresa.getRubro().getNombreRubro().isEmpty())
        {
            errores.agregarError("rubro", "Debe especificar un rubro para la empresa.");
        }
        else
        {
            Collection<Rubro> rubros = accesoDatos.BuscarObjetosPorCaracteristica(Rubro.class, "nombreRubro", dtoEmpresa.getRubro().getNombreRubro());

            if (rubros.isEmpty())
            {
                errores.agregarError("rubro", "El rubro especificado no existe.");
            }
        }

        Errores erroresContactosEmpresa = new Errores();

        for (DTOContactoEmpresa dtoContactoEmpresa : dtoEmpresa.getContactos())
        {
            Errores erroresContactos = servicioValidacionDatos.validarDatos(dtoContactoEmpresa);

            if (erroresContactos.hayErrores())
            {
                erroresContactosEmpresa.putAll(erroresContactos);
            }
        }

        if (erroresContactosEmpresa.hayErrores())
        {
            errores.put("contactos", erroresContactosEmpresa.parsearErrores());
        }
    }

    protected abstract boolean esActualizacion(DTOEmpresa dtoEmpresa);
    protected abstract void analizarErroresCUIT(DTOEmpresa dtoEmpresa, Errores errores);
}
