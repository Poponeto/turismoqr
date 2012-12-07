<%-- 
    Document   : AdministracionUsuarios
    Created on : 06-nov-2012, 0:20:17
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion Usuarios</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/AdministracionUsuarios.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/AdministracionClientes.css">


        <script type="text/javascript" >
            $(document).ready(function(){
                
                inicializarComponentes();
                inicializarPaginaAdministracionUsuarios("${pageContext.request.contextPath}");
            });

        </script>

        <style TYPE="text/css">
            .ui-jqgrid {
                margin-left: auto;
                margin-right: auto;
            }
        </style>
    </head>
    <body>
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>

        <div id="Contenido">
            <button id="botonAgregarUsuario">Agregar Usuario</button>

            <div id="popUpAgregarUsuario">
                <fieldset id="informacionPrincipal">
                    <legend> Informacion Usuario</legend>
                    <p>
                        Nombre de Usuario:&nbsp;
                        <label id="identificador"></label>
                    </p>

                    <p>
                        Contraseña:&nbsp;
                        <label id="nombreCliente"/>
                    </p>

                    <p>
                        Rol:&nbsp;
                        <label id="nombreCliente"/>
                    </p>

                </fieldset>
            </div>

            <div style="width: 90%; margin-top: 10px" align="left">
                <%@ include  file="/WEB-INF/jsp/Administracion/Usuario/TablaUsuarios.jsp" %>
            </div>

            <div id="informacionUsuario" style="padding: 10px;">

                <fieldset id="informacionPrincipal">
                    <legend> Informacion Usuario</legend>
                    <p>
                        Nombre de Usuario:&nbsp;
                        <label id="nombreUsuario"></label>
                    </p>

                    <p>
                        Contraseña:&nbsp;
                        <label id="contraseña"/>
                    </p>

                </fieldset>

                <div id="accionesUsuario">
                    <button id="botonReiniciarContraseniaUsuario">Reiniciar Contraseña</button>
                    <button id="botonEliminarUsuario">Bloquear Usuario</button>
                    <button id="botonDesbloquearUsuario">Desbloquear Usuario</button>
                </div>
            </div>
        </div>
    </body>
</html>
