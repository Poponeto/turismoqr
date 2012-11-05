/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosNegocio.Usuarios.Persona;
import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionPersona extends EstrategiaTraduccionCliente implements IEstrategiaTraduccion<Persona> {

    @Override
    protected DTOContacto crearDTOContacto()
    {
        return new DTOPersona();
    }

    @Override
    protected Contacto crearContacto()
    {
        return new Persona();
    }

    public IDTO<Persona> traducir(Persona objetoNegocio)
    {
        DTOPersona dtoPersona = (DTOPersona)iniciarCliente(objetoNegocio);

        dtoPersona.setApellido(objetoNegocio.getApellido());
        dtoPersona.setDni(objetoNegocio.getDni());
        dtoPersona.setFechaDeNacimiento(objetoNegocio.getFechaDeNacimiento());
        dtoPersona.setNombre(objetoNegocio.getNombre());
        dtoPersona.setSexo(objetoNegocio.getSexo());

        return dtoPersona;
    }

    public Persona traducir(IDTO<Persona> dto)
    {
        Persona persona = (Persona) iniciarCliente((DTOPersona)dto);

        persona.setApellido(((DTOPersona)dto).getApellido());
        persona.setDni(((DTOPersona)dto).getDni());
        persona.setFechaDeNacimiento(((DTOPersona)dto).getFechaDeNacimiento());
        persona.setNombre(((DTOPersona)dto).getNombre());
        persona.setSexo(((DTOPersona)dto).getSexo());

        return persona;
    }

}
