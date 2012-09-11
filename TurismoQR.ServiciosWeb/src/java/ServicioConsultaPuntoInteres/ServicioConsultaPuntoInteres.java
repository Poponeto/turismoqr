/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioConsultaPuntoInteres;


import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Punto.IServicioPunto;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.annotation.Resource;
import javax.jws.WebMethod;

/**
 *
 * @author Federico
 */
@WebService()
public class ServicioConsultaPuntoInteres
{
    
    @Resource
    IServicioPunto servicioPunto;
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarPuntoInteres")
    public DTOPunto ConsultarPuntoInteres(@WebParam(name = "idPuntoInteres")
            final String idPuntoInteres,@WebParam(name = "nombreIdioma") final String nombreIdioma)
    {
        return servicioPunto.ConsultarPuntoInteres(idPuntoInteres, nombreIdioma);
    }

}
