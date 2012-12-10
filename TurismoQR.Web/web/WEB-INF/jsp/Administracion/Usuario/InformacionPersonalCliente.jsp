<%-- 
    Document   : InformacionPersonal
    Created on : Dec 5, 2012, 3:25:16 PM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Personal</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosError.html" %>

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/DatosContacto.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/InformacionPersonal.js"></script>

        <script type="text/javascript">

            $(document).ready(function(){
                $("#Contenedor").hide();

                $.get('${pageContext.request.contextPath}/${formularioCliente}', function(data) {
                    $('#contenedorFormularioCliente').html(data);
                    inicializarComponentes();
                    inicializarComponentesInformacionPersonal("${tipoCliente}", "${pageContext.request.contextPath}");
                    setTimeout('inicializarDatosContacto();$("#Contenedor").show();', 1000);

                });
                
            });
        </script>
    </head>
    <body>
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="Contenedor">

            <div>
                <button id="botonEditar">Editar</button>
            </div>

            <div id="Contenido" style="padding: 30px;">
                <div id="contenedorFormularioCliente">
                </div>

                <%@ include file = "/WEB-INF/jsp/Registro/FormularioCliente.jsp" %>

                <%@ include file = "/WEB-INF/jsp/Registro/FormularioContacto.jsp" %>

                <div>
                    <button id="botonActualizar">Actualizar Informacion Personal</button>
                </div>


            </div>
        </div>
    </body>
</html>
