/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */

@Service("servicioEnvioMail")
public class ServicioEnvioMail implements IServicioEnvioMail
{

    private JavaMailSender servicioEnvioMailJava;
    private SimpleMailMessage mensajeMail;

    @Autowired
    public ServicioEnvioMail(JavaMailSender servicioEnvioMailJava, SimpleMailMessage mensajeMail)
    {
        this.servicioEnvioMailJava = servicioEnvioMailJava;
        this.mensajeMail = mensajeMail;
    }

    public boolean enviarEmail(String mensaje, String subject, String destinatario)
    {
        SimpleMailMessage mail = new SimpleMailMessage(this.mensajeMail);
        mensajeMail.setSubject(subject);
        mensajeMail.setText(mensaje);
        mensajeMail.setTo(destinatario);

        try{
            servicioEnvioMailJava.send(mail);
        }
        catch(MailException ex) {
            return false;          
        }

        return true;
    }

}
