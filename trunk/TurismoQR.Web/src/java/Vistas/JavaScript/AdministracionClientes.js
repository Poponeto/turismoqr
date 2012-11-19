/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function inicilizarTablaClientes(urlbase)
{
    jQuery("#tablaClientes").jqGrid({
        url: urlbase + "/administracion/cliente/obtenerInformacionTabla.htm",
        editurl: urlbase + "/administracion/cliente/modificarCliente.htm",
        datatype: "json",
        mtype: "GET",
        autowidth: true,
        loadonce:true,
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
            align: 'center',
            editable: true
        },

        {
            name:'celular',
            index:'celular',
            width: 100,
            align: 'center',
            editable: true
        },

        {
            name:'telefonoFijo',
            index:'telefonoFijo',
            width: 100,
            align: 'center',
            editable: true
        },

        {
            name:'puntosPermitidos',
            index:'puntosPermitidos',
            width: 100,
            align: 'center',
            editable: true
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
        ajaxRowOptions : {
            type :"POST",
            contentType :"application/json",
            dataType :"json"
        },
        serializeRowData: function(postdata){
            return JSON.stringify(postdata);
        },
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
        edit:true,
        add:false,
        del:false,
        reload: true
    },
    {//EDIT parameters
        ajaxEditOptions:{
            type :"POST",
            contentType :"application/json",
            dataType :"json"
        },
        serializeEditData: function (postdata) {
            return JSON.stringify(postdata);
        },
        closeAfterAdd: true
    },
    {
        //add parameters
        ajaxEditOptions:{
            type :"POST",
            contentType :"application/json",
            dataType :"json"
        },
        serializeEditData: function (postdata) {
            return JSON.stringify(postdata);
        },
        closeAfterAdd: true
    },
    {
        //delete parameters
        ajaxDelOptions:{
            type :"POST",
            contentType :"application/json",
            dataType :"json"
        },
        serializeDelData: function (postdata) {
            return JSON.stringify(postdata);
        }
    }
    );
}

function inicializarPaginaAdministracionClientes(urlbase)
{
    inicilizarTablaClientes(urlbase);
    $("#informacionCliente").hide();
    $("#botonAutorizarCliente").hide();

    $("#botonAutorizarCliente").click(function(){
        var urlConsulta = urlbase + "/administracion/cliente/autorizarCliente.htm";

        $.ajax({

            url: urlConsulta,
            data: {idCliente: $("#identificador").text()},
            type: "POST",
            //contentType: "application/json",
            success: function(){
                debugger
                location.reload(true);
            }

        });
    });

}

function cargarInformacionCliente(fila)
{
    $("#identificador").text(fila.idCliente);
    $("#nombreCliente").text(fila.nombreCliente);
    $("#tipoCliente").text(fila.tipoCliente);

    $("#mail").text(fila.mail);
    $("#celular").text(fila.celular);
    $("#telefonoFijo").text(fila.telefonoFijo);

    $("#puntosPermitidos").text(fila.puntosPermitidos);
    $("#puntosCreados").text(fila.puntosQuePosee);
    $("#estado").text(fila.estadoCliente);

    if($("#estado").text() === "Autorizacion Pendiente")
    {
        $("#botonAutorizarCliente").show(1000);
    }
    else{
        $("#botonAutorizarCliente").hide();
    }

    $("#informacionCliente").show(1000);
}
