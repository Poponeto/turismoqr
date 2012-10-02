/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioConsultaPuntoInteres;


import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Punto.IServicioPunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Element;

/**
 *
 * @author Federico
 */
@Endpoint
public class ServicioConsultaPuntoInteres
{
    
    IServicioPunto servicioPunto;
    
    @Autowired
    public ServicioConsultaPuntoInteres(IServicioPunto servicioPunto)
    {
        this.servicioPunto = servicioPunto;
    }
    
    /**
     * Web service operation
     */
    @PayloadRoot(localPart = "ConsultarPuntoInteres", namespace = "http://TurismoQR.ServiciosWeb")

    public @ResponsePayload DTOPunto ConsultarPuntoInteres(
            @RequestPayload Element mensaje
            )
    {
        String idPuntoInteres = obtenerIdPuntoInteres(mensaje);
        String nombreIdioma = obtenerIdiomaPuntoInteres(mensaje);

        return servicioPunto.ConsultarPuntoInteres(idPuntoInteres, nombreIdioma);
    }

    private String obtenerIdPuntoInteres(Element mensaje)
    {
        return null;
    }

    private String obtenerIdiomaPuntoInteres(Element mensaje)
    {
        return null;
    }
}
