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
    CommonsMultipartFile files;

    public CommonsMultipartFile getFiles() {
        return files;
    }

    public void setFiles(CommonsMultipartFile files) {
        this.files = files;
    } 
}
