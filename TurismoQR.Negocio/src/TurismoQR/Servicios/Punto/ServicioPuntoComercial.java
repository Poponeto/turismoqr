/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto;

import TurismoQR.AccesoDatos.AccesoDatosPunto;
import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Manejadores.GeneradorCodigo.GeneradorCodigoQR;
import TurismoQR.Manejadores.ManejadorCategoria.ManejadorCategoria;
import TurismoQR.Manejadores.ManejadorEstados.ManejadorEstados;
import TurismoQR.Manejadores.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.Traductores.ITraductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ftacchini
 */
@Transactional
@Service
public class ServicioPuntoComercial extends ServicioPunto implements IServicioPuntoComercial{

    @Autowired
    public ServicioPuntoComercial(ManejadorIdiomas manejadorIdioma,
            ManejadorEstados manejadorEstado,
            ManejadorCategoria manejadorCategoria,
            AccesoDatosPunto accesoDatos,
            ITraductor traductor,
            GeneradorCodigoQR generadorCodigo) {
        
       super(manejadorIdioma, manejadorEstado, manejadorCategoria, accesoDatos, traductor, generadorCodigo);
    }
}
