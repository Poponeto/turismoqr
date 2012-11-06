<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a TurismoQR</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Home.css">
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosSlider.html" %>

        <script type="text/javascript">
            $(document).ready(function(){
                inicializarComponentes();

                $('#botonRegistrarCliente').click(function(){
                    $('#Contenedor').css('opacity','0.5');
                    $('#popUpEmpresaPersona').dialog('open');
                    return false;
                });
                
                $.get('${pageContext.request.contextPath}/cliente/opcionesRegistroCliente.htm', function(data) {
                    $('#ContenedorDelPopUp').html(data);
                });
            });
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
        </script>
    </head>

    <body style="margin: 0px;">
        <div id="Contenedor">
            <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

            <div>
                <table id="contenidoPrincipal" style="width: 100%;">
                    <tr>
                        <td>
                            <div id="Contenido">
                                <div class="slider-wrapper theme-default" style="background-color: black;">
                                    <div id="slider" class="nivoSlider" style="height: 500px;">
                                        <img src="${pageContext.request.contextPath}/Vistas/Imagenes/Slider1.jpg" data-thumb="${pageContext.request.contextPath}/Vistas/Imagenes/Slider1.jpg" alt="" />
                                        <img src="${pageContext.request.contextPath}/Vistas/Imagenes/Slider2.jpg" data-thumb="${pageContext.request.contextPath}/Vistas/Imagenes/Slider2.jpg" alt="" />
                                        <img src="${pageContext.request.contextPath}/Vistas/Imagenes/Slider3.jpg" data-thumb="${pageContext.request.contextPath}/Vistas/Imagenes/Slider3.jpg" alt="" />

                                    </div>
                                </div>
                            </div>
                        </td>
                        <td style="width: 35%;">
                            <div id="Menu">
                                <div>
                                    <%@ include  file="Login.jsp" %>
                                </div>
                                <div style="padding: 10px; padding-bottom: 0px;">
                                    <form name="loginComoTurista" action="<core:url value='login/ingresarComoTurista.htm'/>" method="GET">
                                        <div>
                                            <input id="botonIngresarComoTurista" type="submit" value="Ingresar como turista!"/>
                                        </div>
                                    </form>

                                    <div>
                                        <button id="botonRegistrarCliente"> Registrarse como Cliente </button>
                                    </div>

                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <div id="ContenedorDelPopUp">
        </div>

    </body>
</html>
