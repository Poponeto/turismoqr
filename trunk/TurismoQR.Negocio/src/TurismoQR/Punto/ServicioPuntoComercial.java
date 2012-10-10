/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Punto;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Punto.GeneradorCodigo.GeneradorCodigoQR;
import TurismoQR.Punto.ManejadorEstados.ManejadorEstados;
import TurismoQR.Punto.ManejadorIdiomas.ManejadorIdiomas;
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
            IAccesoDatos accesoDatos,
            ITraductor traductor,
            GeneradorCodigoQR generadorCodigo) {
        
       super(manejadorIdioma, manejadorEstado, accesoDatos, traductor, generadorCodigo);
    }
}
