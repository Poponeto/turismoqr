/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Persona;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.Servicios.Validacion.Errores;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public class ValidadorDatosPersonaActualizacion extends ValidarDatosPersonaBase{

    public ValidadorDatosPersonaActualizacion(IAccesoDatos accesoDatos)
    {
        super(accesoDatos);
    }

    @Override
    protected boolean esActualizacion(DTOPersona dtoPersona)
    {
        return dtoPersona.getIdContacto() != null;
    }

    @Override
    protected void analizarErroresDNI(DTOPersona dtoPersona, Errores errores)
    {
        Collection<Persona> personas =
                    accesoDatos.BuscarObjetosPorCaracteristica(
                    Persona.class,
                    "dni",
                    dtoPersona.getDni());

        for(Persona persona : personas)
        {
            if (!persona.getIdObjeto().equals(dtoPersona.getIdContacto()))
            {
                errores.agregarError("dni", "Ya existe un cliente con ese DNI creado.");
            }

        }
    }
}
