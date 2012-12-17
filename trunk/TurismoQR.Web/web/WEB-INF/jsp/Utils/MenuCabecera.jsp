<%-- 
    Document   : MenuCabecera
    Created on : Oct 5, 2012, 2:49:06 PM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Cabecera</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosPotatoMenu.html" %>

        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentesMenuCabecera();
            });
        </script>
    </head>
    <body>
        <div style="display: inline-block;">
            
                <ul id ="contenedorDeMenusInicio" style="display: inline-block;">
                    <li id ="menuDeOpcionesPunto">
                        <a href="#" class="menuPrincipal">
                            <img id="imagenMenu0" alt="" src="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/images/profile.gif"/>&nbsp;Punto&nbsp;&nbsp;&nbsp<img id="imagenMenu1" alt="" src="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/images/down.png"/>
                        </a>
                        <ul>
                            <sec:authorize url="/administracion/crearPunto/crearPuntoDeInteres.htm">
                                <li style="width:220px">
                                    <a href="${pageContext.request.contextPath}/administracion/crearPunto/crearPuntoDeInteres.htm">Crear Punto de Interés</a>
                                </li>
                            </sec:authorize>
                            <sec:authorize url="/buscarPunto/paginaBuscarPunto.htm">
                                <li style="width:220px">
                                    <a href="${pageContext.request.contextPath}/buscarPunto/paginaBuscarPunto.htm">Buscar Punto</a>
                                </li>
                            </sec:authorize>
                        </ul>
                    </li>

                    <li id ="menuDeOpcionesUsuario">
                        <a href="#" class="menuPrincipal">
                            <img id="imagenMenu2" alt="" src="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/images/action.gif"/>&nbsp;Usuario&nbsp;&nbsp;&nbsp<img alt=""  id="imagenMenu3" src="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/images/down.png"/>
                        </a>

                        <ul>
                            <sec:authorize url="/administracion/usuario/informacionPersonal.htm">
                                <li style="width:170px">
                                    <a href="${pageContext.request.contextPath}/administracion/usuario/informacionPersonal.htm">Información Personal</a>
                                </li>
                            </sec:authorize>
                            <sec:authorize url="/administracion/usuario/paginaAdministracionUsuarios.htm">
                                <li style="width:170px">
                                    <a href="${pageContext.request.contextPath}/administracion/usuario/paginaAdministracionUsuarios.htm">Usuarios del Sistema</a>
                                </li>
                            </sec:authorize>
                            <sec:authorize url="/administracion/cliente/paginaAdministracionClientes.htm">
                                <li style="width:170px">
                                    <a href="${pageContext.request.contextPath}/administracion/cliente/paginaAdministracionClientes.htm">Clientes del Sistema</a>
                                </li>
                            </sec:authorize>
                        </ul>
                    </li>

                    <!--sec:authorize ifAnyGranted="PERMISO_VERINFORMES"-->
                    <li id ="menuDeOpcionesInformes">

                        <a href="${pageContext.request.contextPath}/administracion/verReporte/reporte.htm" class="menuPrincipal"><img alt=""  id="imagenMenu4" src="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/images/chart.gif"/>&nbsp;Informes&nbsp;&nbsp;&nbsp<img alt=""  id="imagenMenu5" src="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/images/down.png"/></a>

                        <ul>

                        </ul>

                    </li>
                    <!-- /sec:authorize-->

                </ul>
         

        </div>

        <div class="menuderecho">
            <div id="contenedorDeInformacionTurismoQR">
                <a href="${pageContext.request.contextPath}/administracion/aboutUS.htm">¿Quiénes Somos?</a>
            </div>
                <sec:authorize ifAllGranted="PERMISO_CLIENTE">
                <div id="contenedorDeLogoutTurismoQR">

                    <a href="${pageContext.request.contextPath}/j_myApplication_logout" >Logout</a>
                </div>
            </sec:authorize>
        </div>
    </body>
</html>
