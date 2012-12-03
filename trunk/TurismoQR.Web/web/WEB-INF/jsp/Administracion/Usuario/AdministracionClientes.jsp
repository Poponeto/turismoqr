<%-- 
    Document   : AdministracionClientes
    Created on : 06-nov-2012, 1:37:43
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/AdministracionClientes.js"></script>



        <script type="text/javascript" >
            $(document).ready(function(){

                inicializarComponentes();
                inicializarPaginaAdministracionClientes("${pageContext.request.contextPath}");
            });

        </script>

        <style TYPE="text/css">
            .ui-jqgrid {
                margin-left: auto;
                margin-right: auto;
            }
            fieldset[id*="informacion"] {
                border-radius: 10px;
                margin-bottom: 10px;
                font-family: Calibri,Calibri,Calibri;
                font-size: 1.1em;
            }
            fieldset[id*="informacion"] legend {
                font-weight: bold;
                font-style: italic;
            }
            fieldset[id*="informacion"] p {
                font-weight: bold;
            }
            fieldset[id*="informacion"] p label {
                font-weight: normal;
            }
            #botonAutorizarCliente {
                display: block;
                width: 25%;
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
            <div id="contenedorTablaClientes" style="margin-top: 10px;">
                <%@ include  file="/WEB-INF/jsp/Administracion/Usuario/TablaClientes.jsp" %>
            </div>
            <div id="informacionCliente" style="padding: 10px;">

                <fieldset id="informacionPrincipal">
                    <legend> Informacion cliente </legend>
                    <p>
                        Identificador:&nbsp;
                        <label id="identificador"></label>
                    </p>

                    <p>
                        Nombre de Cliente:&nbsp;
                        <label id="nombreCliente"/>
                    </p>

                    <p>
                        Tipo de Cliente:&nbsp;
                        <label id="tipoCliente"/>
                    </p>
                </fieldset>

                <fieldset id="informacionContacto" >
                    <legend> Informacion contacto </legend>
                    <p>
                        Direccion de Correo:&nbsp;
                        <label id="mail"></label>
                    </p>

                    <p>
                        Telefono Movil:&nbsp;
                        <label id="celular"/>
                    </p>

                    <p>
                        Telefono Fijo:&nbsp;
                        <label id="telefonoFijo"/>
                    </p>
                </fieldset>

                <fieldset id="informacionAdministrativa">
                    <legend> Informacion administrativa </legend>
                    <p>
                        Puntos permitidos:&nbsp;
                        <label id="puntosPermitidos"></label>
                    </p>

                    <p>
                        Puntos Creados:&nbsp;
                        <label id="puntosCreados"/>
                    </p>

                    <p>
                        Estado:&nbsp;
                        <label id="estado"/>
                    </p>

                    
                </fieldset>

                <button id="botonAutorizarCliente">Autorizar Cliente</button>
            </div>
        </div>
</html>