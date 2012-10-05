<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a TurismoQR</title>
        <link rel="stylesheet" type="text/css" href="./Vistas/HojasDeEstilo/Home.css">
        <script type="text/javascript" src="./Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="./Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="./Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" href="./Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <script type="text/javascript">
            $(document).ready(function(){
                inicializarComponentes();
            });
        </script>
    </head>

    <body>
    
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
                        <input id="botonRegistrarCliente" type="submit" value="Registrarse como Cliente" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
