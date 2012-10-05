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
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();
            });
        </script>
    </head>
    <body>
        <a href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />">Logout</a>
        <div id ="contenedorDeMenus">
            <div id ="menuDeOpcionesPunto">
                <button>
                    Punto
                </button>
                <ul>
                    <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                        <li>Crear Punto de Interés</li>
                    </sec:authorize>
                    <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                        <li>Crear Punto Comercial</li>
                    </sec:authorize>
                    <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                        <li>Buscar Punto</li>
                    </sec:authorize>
                    <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                        <li>Genrar Código QR de Punto</li>
                    </sec:authorize>
                </ul>
            </div>

            <div id ="menuDeOpcionesUsuario">
                <button>
                    Usuario
                </button>
                <ul>
                    <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                        <li>Información Personal</li>
                    </sec:authorize>
                    <sec:authorize url="/crearPunto/crearPuntoDeInteres.htm">
                        <li>Usuarios del Sistema</li>
                    </sec:authorize>
                    <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                        <li>Clientes del Sistema</li>
                    </sec:authorize>
                    <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                        <li>Crear Usuario</li>
                    </sec:authorize>
                </ul>
            </div>

            <div id ="menuDeOpcionesInformes">
                <sec:authorize ifAnyGranted="PERMISO_VERINFORMES">
                    <button>
                        Informes
                    </button>
                    <ul>

                    </ul>
                </sec:authorize>
            </div>

        </div>

        <div id="contenedorDeInformacionTurismoQR">
            <a>¿Quiénes Somos?</a>
        </div>

    </body>
</html>
