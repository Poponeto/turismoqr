<%-- 
    Document   : ConfirmacionRegistroUsuario
    Created on : 20-nov-2012, 0:45:00
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Cliente</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        
        <script type="text/javascript">

            $(document).ready(function(){
                inicializarComponentes();
            });
        </script>
    </head>
    <body>
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="Contenido" style="padding: 15px 30px;" class="ui-widget-content">
            <h1>El registro de cliente ha sido exitoso!</h1>
            Se ha registrado como cliente correctamente. Se envió un mail a la dirección de correo ${mail}, confirmando sus datos.<br>
            Recibirá un mail con la información de Usuario luego de que el administrador verifique sus datos.
        </div>
    </body>
</html>
