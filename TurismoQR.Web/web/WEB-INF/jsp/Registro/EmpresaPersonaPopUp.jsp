<%-- 
    Document   : EmpresaPersonaPopUp
    Created on : 04-nov-2012, 11:49:50
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seleccione Tipo de Cliente</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <script type="text/javascript">
            $(document).ready(function(){
                inicializarComponentes();

                $('#popUpEmpresaPersona').dialog({
                    autoOpen: false,
                    width: '30%',
                    buttons: {
                        "Cancelar": function() {
                            $('#Contenedor').css('opacity','1');
                            $(this).dialog("close");
                        }
                    },
                    title: 'Seleccione el Tipo de Cliente.'
                });
            });

        </script>
    </head>
    <body>
        <div id="popUpEmpresaPersona">

            <button id="botonEmpresa" onclick="window.location = '${pageContext.request.contextPath}/${registroEmpresa}'" >
                Empresa
            </button>
            <button id="botonPersona" onclick="window.location = '${pageContext.request.contextPath}/${registroPersona}'" >
                Persona
            </button>

        </div>
    </body>
</html>
