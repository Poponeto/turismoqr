/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chelo
 */
@Controller("imagenesController")
@RequestMapping("imagenes/")
public class ImagenesController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    @RequestMapping("mostrarImagen")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String imagePath=request.getParameter("img");

            response.setContentType("image/gif");

            File f = new File(imagePath);
            FileInputStream fin = new FileInputStream(f);
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer);
            fin.close();
            OutputStream o = response.getOutputStream();
            o.write(buffer);

            o.flush();
            o.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
