<%-- 
    Document   : TablaPuntos
    Created on : 28-oct-2012, 22:22:37
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla Puntos</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/JQGrid/grid.locale-en.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/JQGrid/jquery.jqGrid.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/ui.jqgrid.css">

        <script type="text/javascript">
            $(document).ready(function(){
                jQuery("#tablaPuntos").jqGrid({
                    url:'${pageContext.request.contextPath}/buscarPunto/obtenerInformacionTabla.htm',
                    datatype: "json",
                    mtype: "GET",
                    colNames:['Identificador','Nombre Identificador', 'Latitud', 'Longitud','Links','Imagenes'],
                    colModel:[
                        {name:'identificador',index:'identificador', width:210},
                        {name:'nombreIdentificador',index:'nombreIdentificador', width:210},
                        {name:'latitud',index:'latitud', width:100},
                        {name:'longitud',index:'longitud', width:100, align:"right"},
                        {name:'tieneLinks',index:'tieneLinks', width:100, align:"right"},
                        {name:'tieneImagenes',index:'tieneImagenes', width:100,align:"right"},
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    pager: '#paginador',
                    sortname: 'identificador',
                    viewrecords: true,
                    sortorder: "desc",
                    jsonReader: {
                        repeatitems : false,
                        id: "identificador"
                    },
                    caption: "Puntos de Interes",
                    height: '100%'
                });
                jQuery("#tablaPuntos").jqGrid('navGrid','#paginador',{edit:false,add:false,del:false});
            });
        </script>

    </head>
    <body>

        <table id="tablaPuntos"></table>
        <div id="paginador"></div>

    </body>
</html>
