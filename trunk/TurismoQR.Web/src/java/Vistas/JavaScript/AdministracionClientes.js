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
        colNames:['Nombre de Cliente','Tipo de Cliente', 'Direccion de Correo', 'Movil', 'Telefono Fijo', 'Puntos permitidos', 'Puntos Creados'],
        colModel:[
        {
            name:'nombreCliente',
            index:'nombreCliente',
            width: 150
        },

        {
            name:'tipoCliente',
            index:'tipoCliente',
            width: 150
        },

        {
            name:'mail',
            index:'mail',
            width: 150
        },

        {
            name:'celular',
            index:'celular',
            width: 150
        },

        {
            name:'telefonoFijo',
            index:'telefonoFijo',
            width: 150
        },

        {
            name:'puntosPermitidos',
            index:'puntosPermitidos',
            width: 150
        },

        {
            name:'puntosQuePosee',
            index:'puntosQuePosee',
            width: 150
        },

        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#paginador',
        sortname: 'nombreCliente',
        viewrecords: true,
        sortorder: "desc",
        jsonReader: {
            repeatitems : false,
            id: "nombreCliente"
        },
        caption: "Clientes",
        height: '100%',
        loadComplete: function() {
                        //funcionExito($('#tablaUsuarios').jqGrid('getRowData'), urlbase);
        },
        onSelectRow: function(id){
            //funcionClickFila(jQuery('#tablaUsuarios').jqGrid('getRowData',id));
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
}
