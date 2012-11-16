/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function inicilizarTablaClientes(urlbase)
{
    jQuery("#tablaClientes").jqGrid({
        url: urlbase + "/administracion/cliente/obtenerInformacionTabla.htm",
        datatype: "json",
        mtype: "GET",
        autowidth: true,
        shrinkToFit: true,
        colNames:['Identificador','Nombre de Cliente','Tipo de Cliente', 'Direccion de Correo', 'Movil', 'Telefono Fijo', 'Puntos permitidos', 'Puntos Creados','Estado'],
        colModel:[
        {
            name:'idCliente',
            index:'idCliente',
            width: 200,
            align: 'center'
        },
        {
            name:'nombreCliente',
            index:'nombreCliente',
            width: 130,
            align: 'center'
        },

        {
            name:'tipoCliente',
            index:'tipoCliente',
            width: 110,
            align: 'center'
        },

        {
            name:'mail',
            index:'mail',
            width: 130,
            align: 'center'
        },

        {
            name:'celular',
            index:'celular',
            width: 100,
            align: 'center'
        },

        {
            name:'telefonoFijo',
            index:'telefonoFijo',
            width: 100,
            align: 'center'
        },

        {
            name:'puntosPermitidos',
            index:'puntosPermitidos',
            width: 100,
            align: 'center'
        },

        {
            name:'puntosQuePosee',
            index:'puntosQuePosee',
            width: 100,
            align: 'center'
        },
        {
            name:'estadoCliente',
            index:'estadoCliente',
            width: 110,
            align: 'center'
        },

        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#paginador',
        sortname: 'idCliente',
        viewrecords: true,
        sortorder: "desc",
        jsonReader: {
            repeatitems : false,
            id: "idCliente"
        },
        caption: "Clientes",
        height: '100%',
        onSelectRow: function(id){
            cargarInformacionCliente(jQuery('#tablaClientes').jqGrid('getRowData',id));
        }
    });
    jQuery("#tablaClientes").jqGrid('navGrid','#paginador',{
        edit:false,
        add:false,
        del:false
    });
}

function inicializarPaginaAdministracionClientes(urlbase)
{
    inicilizarTablaClientes(urlbase);
    $("#informacionCliente").hide();
    $("#botonAutorizarCliente").hide();

}

function cargarInformacionCliente(fila)
{
    $("#identificador").text(fila.idCliente);
    $("#nombreCliente").text(fila.nombreCliente);
    $("#tipoCliente").text(fila.tipoCliente);

    $("#identifmailicador").text(fila.mail);
    $("#celular").text(fila.celular);
    $("#telefonoFijo").text(fila.telefonoFijo);

    $("#puntosPermitidos").text(fila.puntosPermitidos);
    $("#puntosCreados").text(fila.puntosQuePosee);
    $("#estado").text(fila.estadoCliente);

    if($("#estado").text() === "Autorizacion Perndiente")
    {
        $("#botonAutorizarCliente").show(1000);
    }
    else{
        $("#botonAutorizarCliente").hide();
    }

    $("#informacionCliente").show(1000);
}
