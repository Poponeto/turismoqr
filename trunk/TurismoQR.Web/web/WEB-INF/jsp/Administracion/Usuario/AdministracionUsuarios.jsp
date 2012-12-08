<%-- 
    Document   : AdministracionUsuarios
    Created on : 06-nov-2012, 0:20:17
    Author     : Federico
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion Usuarios</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosError.html" %>

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
            <button id="botonAgregarUsuario" style="margin: 10px">Agregar Usuario</button>

            <div id="popUpAgregarUsuario">
                <fieldset id="informacionPrincipal">
                    <legend> Informacion Usuario</legend>
                    
                    <label name="labelnombreUsuario">
                        Nombre de Usuario:<br>
                        <input id="lineaDatosNombreUsuario" name="nombreUsuario" type="text" required="true"/>
                    </label>
                    <br>

                    <label name="labelcontraseña">
                        Contraseña:<br>
                        <input id="lineaDatosContraseña" type="text" name="contraseña" required="true"/>
                    </label>
                    <br>
                    <label name="labelrol">Rol:<br>
                        <select id="selectRol" name="rol" size="1" >
                            <core:forEach var="rol" items="${roles}">
                                <option value="<core:out value="${rol.nombreRol}" />">
                                    <core:out value="${rol.nombreRol}" />
                                </option>
                            </core:forEach>
                        </select>
                    </label>
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
