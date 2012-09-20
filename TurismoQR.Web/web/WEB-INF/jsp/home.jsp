<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
    <LINK rel="stylesheet" type="text/css" href="Vistas/PaginaDeInicio/HojasDeEstilo/Home.css">
    <div id="Contenedor">
        <div id="Cabecera">
            <h1>Turismo QR</h1>
        </div>
        <div id="Contenido">
            <h1>Banner</h1>
        </div>
        <div id="Menu">
            <div>
                <%@ include  file="Login.jsp" %>
            </div>
            <div>
                <form name="registrarCliente" action="<core:url value='registro/accederRegistrarCliente.htm'/>" method="GET">
                    <div>
                        <input type="submit" value="Registrarse como Cliente" />
                    </div>
                </form>
            </div>
        </div>
        <div id="Pie">
            <h1>Pie</h1>
        </div>
    </div>
</body>
</html>
