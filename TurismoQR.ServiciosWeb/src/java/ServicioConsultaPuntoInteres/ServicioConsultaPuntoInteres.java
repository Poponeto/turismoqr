/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioConsultaPuntoInteres;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Punto.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Federico
 */
@WebService()
public class ServicioConsultaPuntoInteres
{

    @Resource
    private IAccesoDatos accesoDatos;
    @Resource
    private ITraductor traductor;
    @Resource
    private ManejadorIdiomas manejadorIdioma;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarPuntoInteres")
    public DTOPunto ConsultarPuntoInteres(@WebParam(name = "idPuntoInteres")
            final String idPuntoInteres,@WebParam(name = "idioma") final String idioma)
    {
        Punto punto = accesoDatos.BuscarObjeto(idPuntoInteres);
        InformacionEnIdioma informacionPunto = manejadorIdioma.seleccionarInformacionDePuntoEnIdioma(punto);

        DTOPunto dtoPunto = (DTOPunto) traductor.traducir(punto);
        DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionPunto);

        dtoPunto.setImagenes(crearDTOImagenes(punto.getImagenes(), idioma));
        dtoPunto.setInformacion(dtoInformacion);

        return dtoPunto;
    }

    public Collection<DTOImagen> crearDTOImagenes(Collection<Imagen> imagenes, final String idioma)
    {
        Collection<DTOImagen> dtoImagenes = new ArrayList<DTOImagen>();

        for (Imagen imagen : imagenes)
        {
            dtoImagenes.add(crearDTOImagen(imagen, idioma));
        }

        return dtoImagenes;
    }

    public DTOImagen crearDTOImagen(Imagen imagen, final String idioma)
    {
        InformacionEnIdioma informacionImagen = manejadorIdioma.seleccionarInformacionDeImagenEnIdioma(imagen);

        DTOImagen dtoImagen = (DTOImagen) traductor.traducir(imagen);
        DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionImagen);

        dtoImagen.setInformacion(dtoInformacion);

        return dtoImagen;
    }
}
