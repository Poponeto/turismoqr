/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 *
 * @author Chelo
 */
public class FormularioArchivo {
    CommonsMultipartFile[] fichero;

    public CommonsMultipartFile[] getFichero() {
        return fichero;
    }

    public void setFichero(CommonsMultipartFile[] fichero) {
        this.fichero = fichero;
    } 
}
