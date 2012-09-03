/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioConsultaPuntoInteres;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Punto.ManejadorEstados.ManejadorEstados;
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
    @Resource
    private ManejadorEstados manejadorEstado;
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarPuntoInteres")
    public DTOPunto ConsultarPuntoInteres(@WebParam(name = "idPuntoInteres")
            final String idPuntoInteres,@WebParam(name = "nombreIdioma") final String nombreIdioma)
    {
        Punto punto = accesoDatos.BuscarObjeto(idPuntoInteres);

        if (punto != null && manejadorEstado.esEstadoValidoConsulta(punto.getEstado()))
        {
            Idioma idioma = manejadorIdioma.obtenerIdioma(nombreIdioma);
            InformacionEnIdioma informacionPunto = manejadorIdioma.seleccionarInformacionDePuntoEnIdioma(punto, idioma);

            DTOPunto dtoPunto = (DTOPunto) traductor.traducir(punto);
            DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionPunto);

            dtoPunto.setImagenes(crearDTOImagenes(punto.getImagenes(), idioma));
            dtoPunto.setInformacion(dtoInformacion);

            return dtoPunto;
        }

        return null;
    }

    public Collection<DTOImagen> crearDTOImagenes(Collection<Imagen> imagenes, final Idioma idioma)
    {
        Collection<DTOImagen> dtoImagenes = new ArrayList<DTOImagen>();

        for (Imagen imagen : imagenes)
        {
            dtoImagenes.add(crearDTOImagen(imagen, idioma));
        }

        return dtoImagenes;
    }

    public DTOImagen crearDTOImagen(Imagen imagen, final Idioma idioma)
    {
        InformacionEnIdioma informacionImagen = manejadorIdioma.seleccionarInformacionDeImagenEnIdioma(imagen, idioma);

        DTOImagen dtoImagen = (DTOImagen) traductor.traducir(imagen);
        DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionImagen);

        dtoImagen.setInformacion(dtoInformacion);

        return dtoImagen;
    }
}
