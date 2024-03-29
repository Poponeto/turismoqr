<%-- 
    Document   : BuscarPunto
    Created on : Sep 19, 2012, 3:12:43 PM
    Author     : ftacchini
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion TurismoQR</title>
        
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosMapa.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/BuscarPuntos.js"></script>

        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();

                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.obtenerUbicacionUsuario(function(){
                    tqrmapas.crearMapa();
                    tqrmapas.crearNuevoMarcador("Posicion actual");
                });


                $('#categoria').on('change', function(){
                    aplicarFiltros();
                });

                $('#usuario').on('change', function(){
                    aplicarFiltros();
                });

                function aplicarFiltros() {
                    var categoria = $('#categoria').val();
                    var usuario = $('#usuario').val();

                    if(usuario != 'default' && categoria != 'default') {
                        filtroCategoriaUsuario(categoria, usuario, "${pageContext.request.contextPath}");
                    } else if (usuario != 'default' && categoria == 'default') {
                        filtroUsuario(usuario, "${pageContext.request.contextPath}");
                    } else if (usuario == 'default' && categoria != 'default') {
                        filtroCategoria(categoria, usuario, "${pageContext.request.contextPath}");
                    } else if(usuario == 'default' && categoria == 'default') {
                        inicilizarTablaPuntos('${pageContext.request.contextPath}');
                    }
                }
            });

            $(window).load(function() {
                inicializarPaginaBuscarPuntos("${pageContext.request.contextPath}", tqrmapas);
            });

        </script>
        <style TYPE="text/css">
            .ui-jqgrid {
                margin-left: auto;
                margin-right: auto;
            }
        </style>
    </head>
    <body style="margin: 0px;">
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <sec:authorize ifAnyGranted="PERMISO_CLIENTE">
            <div id="contenedorMenu" class="ui-widget-header">
                <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
            </div>
        </sec:authorize>

        <div id="contenedorFiltro" style="margin-left: auto; margin-right: auto; height: auto;padding: 10px; font-family: Calibri,Calibri,Calibri; font-size: 1.2em;" >
            <fieldset id="filtros">
                <legend> Filtrar por: </legend>
                Categoria: <%@ include  file="/WEB-INF/jsp/Utils/ComboCategoria.jsp" %>
                <sec:authorize ifNotGranted="PERMISO_TURISTA">
                    Usuario: <%@ include  file="/WEB-INF/jsp/Utils/ComboUsuarios.jsp" %>
                </sec:authorize>
            </fieldset>
        </div>

        <div id="contenedorMapa" style="width: 100%; margin-left: auto; margin-right: auto; height: 400px;" ></div>

        <div id="contenedorTabla" style="width: 100%; background: #DEEDF7;">
            <%@ include  file="/WEB-INF/jsp/Punto/TablaPuntos.jsp" %>
        </div>

    </body>
</html>
