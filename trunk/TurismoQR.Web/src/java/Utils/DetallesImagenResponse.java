/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.io.Serializable;

/**
 *
 * @author Chelo
 */
public class DetallesImagenResponse implements Serializable {
    String estadoOperacion;
    String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public DetallesImagenResponse(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public DetallesImagenResponse() {
    }
}
