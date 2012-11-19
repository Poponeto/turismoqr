/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Mail;

/**
 *
 * @author Federico
 */
public interface IServicioEnvioMail {

    public boolean enviarEmail(String mensaje, String subject, String destinatario);
}
