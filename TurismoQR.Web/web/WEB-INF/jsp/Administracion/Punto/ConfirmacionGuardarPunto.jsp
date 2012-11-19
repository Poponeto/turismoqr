<%-- 
    Document   : ConfirmacionGuardarPunto
    Created on : 25/09/2012, 01:16:13
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmacion Guardar Punto</title>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/FileUploadPlugin/vendor/jquery.ui.widget.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <script type="text/javascript" src="../../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <script type="text/javascript">
            $(document).ready(function(){
                inicializarComponentes();
            });

            function obtenerCodigoQR() {
                $.ajax({
                    url: $('#requestContext').text() + '/administracion/crearPunto/' + $('#idPunto').text() + $('#requestContext').text() + '/obtenerCodigo.htm',
                    success : function(data) {
                        // TurismoQR.Web/imagenes/mostrarImagen?img=C:\Users\Chelo\Mendoza (2).jpg
                        $('#codigoQR').append('<img id="imagenCodigo" src="' + $('#requestContext').text() + '/imagenes/mostrarImagen?img=' + data.mensaje + '"/>');
                        $('#codigoQR').fadeIn(1000);
                    }
                });
            }
        </script>
    </head>
    <body>
        <div id="Cabecera" style="padding: 15px 30px; height: 70px;">
            <img alt="" src="../../Vistas/Imagenes/TurismoQRLogo.jpg" style="display: inline-block; margin-right: 15px;  height: 70px;"/>
            <img alt="" src="../../Vistas/Imagenes/TurismoQRTitulo.png" style="display: inline-block;  height: 60px;"/>
        </div>
        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>
        <div id="Contenido" style="padding: 15px 30px;" class="ui-widget-content">
            <h1>Punto guardado satisfactoriamente!</h1>
            El punto de interes <b>${nombrePunto}</b> ha sido creado correctamente.<br>
            Si desea generar el codigo QR para este punto haga click <a href="javascript:obtenerCodigoQR();">aqui</a><br>
            <div id="codigoQR" style="display: none; margin-top: 10px; text-align: center;"></div>
        </div>
        <div id="idPunto" style="display: none;">${idPuntoGuardado}</div>
        <div id="requestContext" style="display: none;">${pageContext.request.contextPath}</div>
    </body>
</html>
