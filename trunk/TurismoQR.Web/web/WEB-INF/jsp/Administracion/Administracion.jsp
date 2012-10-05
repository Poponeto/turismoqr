<%-- 
    Document   : PaginaAdministracion
    Created on : Sep 13, 2012, 10:37:56 AM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion TurismoQR</title>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();
            });
        </script>
    </head>
    <body>
        <div id="Contenedor">
            <div id="Cabecera">
                <h1>Turismo QR</h1>
            </div>
            <div id="Contenido">
                <h1>Mapa con ubicación actual y puntos de interés marcados</h1>
            </div>
            <div id="Menu">
                <div id="BotonPaginaInicio">
                    Home
                </div>
                <div id="menuAcordion">
                        <h3><a href="#">First header</a></h3>
                        <div>
                            <input id="boton" type="button" href=""/>
                        </div>
                        <h3><a href="#">Second header</a></h3>
                        <div>

                        </div>
                </div>
                <div id="BannerPaginaInicio">
                    Banner
                </div>
            </div>
            <div id="Pie">
                <h1>Pie</h1>
            </div>
        </div>
    </body>
</html>
