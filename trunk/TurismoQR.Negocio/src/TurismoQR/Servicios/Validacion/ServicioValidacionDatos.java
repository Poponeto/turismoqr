/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Validacion.Validadores.Validador;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosCliente;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosContacto;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosContactoEmpresa;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosEmpresa;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosEmpresaActualizacion;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosPersona;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosPersonaActualizacion;
import TurismoQR.Servicios.Validacion.Validadores.ValidadorDatosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */

@Service
@Transactional
public class ServicioValidacionDatos implements IServicioValidacionDatos
{

    private IAccesoDatos accesoDatos;

    private Validador[] validadores;

    public Validador[] getValidadores()
    {
        return validadores;
    }

    public void setValidadores(Validador[] validadores)
    {
        this.validadores = validadores;
    }

    @Autowired
    public ServicioValidacionDatos(IAccesoDatos accesoDatos)
    {
        this.accesoDatos = accesoDatos;
    }

    public Errores validarDatos(IDTO dto)
    {
        Validador[] validadoresCreados = {
            new ValidadorDatosContacto(),
            new ValidadorDatosCliente(),
            new ValidadorDatosPersona(accesoDatos),
            new ValidadorDatosPersonaActualizacion(accesoDatos),
            new ValidadorDatosEmpresa(accesoDatos, this),
            new ValidadorDatosEmpresaActualizacion(accesoDatos, this),
            new ValidadorDatosContactoEmpresa(),
            new ValidadorDatosUsuario(accesoDatos)
        };

        this.setValidadores(validadoresCreados);

        Errores errores = new Errores();

        for(Validador validador : validadores)
        {
            if (validador.soportaObjeto(dto))
            {
                validador.validar(dto, errores);
            }
        }
        
        return errores;
    }
}
