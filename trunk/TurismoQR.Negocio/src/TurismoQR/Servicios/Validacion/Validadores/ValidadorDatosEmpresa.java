/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Empresa;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Servicios.Validacion.IServicioValidacionDatos;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public class ValidadorDatosEmpresa extends ValidarDatosEmpresaBase
{

    public ValidadorDatosEmpresa(IAccesoDatos accesoDatos, IServicioValidacionDatos servicioValidacionDatos)
    {
        super(accesoDatos,servicioValidacionDatos);
    }


    @Override
    protected boolean esActualizacion(DTOEmpresa dtoEmpresa)
    {
        return dtoEmpresa.getIdContacto() == null;
    }

    @Override
    protected void analizarErroresCUIT(DTOEmpresa dtoEmpresa, Errores errores)
    {
        Collection<Empresa> empresas = accesoDatos.BuscarObjetosPorCaracteristica(Empresa.class, "cuit", dtoEmpresa.getCuit());

            if (!empresas.isEmpty())
            {
                errores.agregarError("cuit", "Ya existe una empresa con ese numeor de CUIT cargada en el sistema.");
            }
    }
}
