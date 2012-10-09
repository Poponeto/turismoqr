<%-- 
    Document   : MenuCabecera
    Created on : Oct 5, 2012, 2:49:06 PM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Cabecera</title>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/MenuCabecera.js"></script>
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/MenuCabecera.css">
        <link rel="stylesheet" type="text/css" media="screen" href="../Vistas/HojasDeEstilo/jquery.ui.potato.menu.css" />
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery.ui.potato.menu.js"></script>



        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();
                inicializarComponentesMenuCabecera();
            });
        </script>
    </head>
    <body>
        <div style="display: inline-block;">
            <ul id ="contenedorDeMenusInicio" style="display: inline-block;">
                <li id ="menuDeOpcionesPunto">
                    <a href="#">
                        <img id="imagenMenu0" alt="" src="../Vistas/HojasDeEstilo/images/profile.gif"/>&nbsp;Punto&nbsp;&nbsp;&nbsp<img id="imagenMenu1" alt="" src="../Vistas/HojasDeEstilo/images/down.png"/>
                    </a>
                    <ul>
                        <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                            <li style="width:220px">
                                <a href="./crearPunto/crearPuntoDeInteres.htm">Crear Punto de Interés</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                            <li style="width:220px">
                                <a href="#">Crear Punto Comercial</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                            <li style="width:220px">
                                <a href="./buscarPunto/paginaBuscarPunto.htm">Buscar Punto</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize url="./buscarPunto/paginaBuscarPunto.htm">
                            <li style="width:220px">
                                <a href="#">Genrar Código QR de Punto</a>
                            </li>
                        </sec:authorize>
                    </ul>
                </li>

                <li id ="menuDeOpcionesUsuario">
                    <a href="#">
                        <img id="imagenMenu2" alt="" src="../Vistas/HojasDeEstilo/images/action.gif"/>&nbsp;Usuario&nbsp;&nbsp;&nbsp<img alt=""  id="imagenMenu3" src="../Vistas/HojasDeEstilo/images/down.png"/>
                    </a>

                    <ul>
                        <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                            <li style="width:170px">
                                <a href="./crearPunto/crearPuntoDeInteres.htm">Información Personal</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                            <li style="width:170px">
                                <a href="./crearPunto/crearPuntoDeInteres.htm">Usuarios del Sistema</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                            <li style="width:170px">
                                <a href="./crearPunto/crearPuntoDeInteres.htm">Clientes del Sistema</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                            <li style="width:170px">
                                <a href="./crearPunto/crearPuntoDeInteres.htm">Crear Usuario</a>
                            </li>
                        </sec:authorize>
                    </ul>
                </li>

                <!--sec:authorize ifAnyGranted="PERMISO_VERINFORMES"-->
                    <li id ="menuDeOpcionesInformes">

                        <a href="./crearPunto/crearPuntoDeInteres.htm"><img alt=""  id="imagenMenu4" src="../Vistas/HojasDeEstilo/images/chart.gif"/>&nbsp;Informes&nbsp;&nbsp;&nbsp<img alt=""  id="imagenMenu5" src="../Vistas/HojasDeEstilo/images/down.png"/></a>

                        <ul>

                        </ul>

                    </li>
                <!-- /sec:authorize-->

            </ul>
        </div>

        <div class="menuderecho">
            <div id="contenedorDeInformacionTurismoQR">
                <a href="./aboutUS.htm">¿Quiénes Somos?</a>
            </div>
            <div id="contenedorDeLogoutTurismoQR">
                <a>Logout</a>
            </div>
        </div>
    </body>
</html>
