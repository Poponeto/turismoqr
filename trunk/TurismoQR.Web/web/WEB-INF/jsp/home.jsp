<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a TurismoQR</title>
        <link rel="stylesheet" type="text/css" href="./Vistas/HojasDeEstilo/Home.css">
        <script type="text/javascript" src="./Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="./Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="./Vistas/JavaScript/JQuery/jquery.nivo.slider.js"></script>
        <script type="text/javascript" src="./Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" href="./Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="./Vistas/HojasDeEstilo/nivo-slider.css">
        <link rel="stylesheet" type="text/css" href="./Vistas/HojasDeEstilo/default.css">
        <script type="text/javascript">
            $(document).ready(function(){
                inicializarComponentes();
            });
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
        </script>
    </head>

    <body style="margin: 0px;">
        <div id="Contenedor">
            <div id="Cabecera" style="padding: 15px 30px; height: 70px;">
                <img alt="" src="./Vistas/Imagenes/TurismoQRLogo.jpg" style="display: inline-block; margin-right: 15px;  height: 70px;"/>
                <img alt="" src="./Vistas/Imagenes/TurismoQRTitulo.png" style="display: inline-block;  height: 60px;"/>
            </div>
            <div>
                <table id="contenidoPrincipal" style="width: 100%;">
                    <tr>
                        <td>
                            <div id="Contenido">
                                <div class="slider-wrapper theme-default" style="background-color: black;">
                                    <div id="slider" class="nivoSlider" style="height: 500px;">
                                        <img src="./Vistas/Imagenes/TQR1.jpg" data-thumb="./Vistas/Imagenes/TQR1.jpg" alt="" />
                                        <img src="./Vistas/Imagenes/TQR2.jpg" data-thumb="./Vistas/Imagenes/TQR2.jpg" alt="" />
                                        <img src="./Vistas/Imagenes/TQR3.jpg" data-thumb="./Vistas/Imagenes/TQR3.jpg" alt="" />
                                        <img src="./Vistas/Imagenes/TQR4.jpg" data-thumb="./Vistas/Imagenes/TQR4.jpg" alt="" />
                                        <img src="./Vistas/Imagenes/TQR5.jpg" data-thumb="./Vistas/Imagenes/TQR5.jpg" alt="" />
                                        <img src="./Vistas/Imagenes/TQR6.jpg" data-thumb="./Vistas/Imagenes/TQR6.jpg" alt="" />
                                        <img src="./Vistas/Imagenes/TQR7.jpg" data-thumb="./Vistas/Imagenes/TQR7.jpg" alt="" />
                                        
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td style="width: 35%;">
                            <div id="Menu">
                                <div>
                                    <%@ include  file="Login.jsp" %>
                                </div>
                                <div style="padding: 10px; padding-bottom: 0px;">
                                    <form name="loginComoTurista" action="<core:url value='login/ingresarComoTurista.htm'/>" method="GET">
                                        <div>
                                            <input id="botonIngresarComoTurista" type="submit" value="Ingresar como turista!"/>
                                        </div>
                                    </form>
                                    <form name="registrarCliente" action="<core:url value='registro/accederRegistrarCliente.htm'/>" method="GET">
                                        <div>
                                            <input id="botonRegistrarCliente" type="submit" value="Registrarse como Cliente" />
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
