/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Manejadores.GeneradorCodigo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;

/**
 * Clase que genera el codigo QR requerido para cada punto de interes.
 * @author Chelo
 */
@Service("generadorCodigoQR")
public class GeneradorCodigoQR {
    private static final String FORMATO_IMAGEN = "gif";
    private static final String RUTA_HOME = System.getProperty("user.home"); 
    private static final String DIRECCION_CONSULTA = "/informacionPunto/";
    private static final String VISTA_MOVIL = "/infoPuntoMobile.htm";
    private static final int ancho = 500; 
    private static final int alto = 500;


    public String generarCodigoQR(String idPuntoInteres, int tamaño, String requestContext, String formatoImagen){
        BitMatrix qrCode;
        Writer qrCodeWriter = new QRCodeWriter();
                
        if (tamaño == 0) {
            tamaño = ancho;
        }
        
        String rutaImagen = RUTA_HOME + "/CodigoQR" + idPuntoInteres + "." + formatoImagen;
        
        if (formatoImagen == null) {
            formatoImagen = FORMATO_IMAGEN;
        }
               
        String datos = requestContext + DIRECCION_CONSULTA + idPuntoInteres + VISTA_MOVIL;
        
        try{
            qrCode = qrCodeWriter.encode(datos, BarcodeFormat.QR_CODE, tamaño, tamaño);

            BufferedImage qrCodeImage = escribirImagen(qrCode);
            
            FileOutputStream qrCodeFile = new FileOutputStream(rutaImagen); 
            ImageIO.write(qrCodeImage, FORMATO_IMAGEN, qrCodeFile); 

            qrCodeFile.close();
            
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }

       return rutaImagen;
    }
    
    /**
     * Genera la imagen que contiene el codigo QR para ser guardada en el disco.
     * @param qrCode Matriz de datos correspondiente al codigo QR.
     * @return Imagen correspondiente al codigo QR a ser guardada en disco.
     */
    private static BufferedImage escribirImagen(BitMatrix qrCode){
        BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        
        for (int y = 0; y < ancho; y++) { 
            for (int x = 0; x < alto; x++) { 
                int grayValue = (qrCode.get(x, y) ? 1 : 0) & 0xff; 
                image.setRGB(x, y, (grayValue == 0 ? 0xFFFFFF : 0)); 
            } 
        } 
        
        return image;
    }
    
    /**
     * Debido a un bug de la API la imagen se genera con los colores blanco y negro invertidos, 
     * por lo que se debe realizar la conversion a los colores correctos.
     * @param imagen Imagen que necesita inversion de colores.
     * @return Imagen con colores blanco y negro invertidos.
     */
    @Deprecated
    private static BufferedImage invertirColores(BufferedImage imagen) { 
        for (int x = 0; x < ancho; x++) { 
            for (int y = 0; y < alto; y++) { 
                int rgb = imagen.getRGB(x, y); 
                if (rgb == -16777216) { 
                    imagen.setRGB(x, y, -1); 
                } else { 
                    imagen.setRGB(x, y, -16777216); 
                } 
            } 
        } 
        return imagen; 
    }
}
