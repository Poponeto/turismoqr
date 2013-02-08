<%--
    Document   : RecuperarContraseñaPopUp
    Created on : 04-nov-2012, 11:49:50
    Author     : Chelo
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
                $('#popUpRecuperarContraseña').dialog({
                    autoOpen: false,
                    width: '50%',
                    buttons: {
                        "Ok": function() {
                            $('#contenedorErrorMail').hide(1000);
                            $('#contenedorCargandoMail').show(1000);
                            restaurarContraseña($('#direccionMail').val());
                        },
                        "Cancelar": function() {
                            $('#Contenedor').css('opacity','1');
                            $(this).dialog("close");
                        }
                    },
                    title: 'Recuperar contraseña'
                });
            });

        </script>
    </head>
    <body>
        <div id="popUpRecuperarContraseña">

            <form id="formularioResetContraseña" action="" method="POST" enctype="multipart/form-data">
                <label for="direccionMail">
                    Ingrese la direccion de correo que utilizo para registrarse.<br>Recibira un mensaje con sus nuevas credenciales a la brevedad.
                    <br>
                    <br>
                    <input id="direccionMail" name="direccionMail" type="text" placeholder="Ingrese su direccion de correo electronico" style="width: 100%;"/>
                    <br>
                    <div id="contenedorCargandoMail" style="display: none; text-align: center;"><img src="${pageContext.request.contextPath}/Vistas/Imagenes/loading.gif" style="height : 20px;"/></div>
                    <div id="contenedorErrorMail"  style="display:none; border: 1px solid black; padding: 2px; color: white; background: red; text-align: center;">La direccion de correo electronico especificada no existe en nuestra base de datos. Intentelo nuevamente.</div>
                </label>
            </form>

        </div>
    </body>
</html>
