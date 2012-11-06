/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function inicilizarTablaUsuarios(urlbase)
{
    jQuery("#tablaUsuarios").jqGrid({
        url: urlbase + "/administracion/usuario/obtenerInformacionTabla.htm",
        datatype: "json",
        mtype: "GET",
        colNames:['Nombre de Usuario','Contraseña'],
        colModel:[
        {
            name:'nombreUsuario',
            index:'nombreUsuario',
            width:210
        },

        {
            name:'contraseña',
            index:'contraseña',
            width:210
        },

        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#paginador',
        sortname: 'nombreUsuario',
        viewrecords: true,
        sortorder: "desc",
        jsonReader: {
            repeatitems : false,
            id: "nombreUsuario"
        },
        caption: "Usuarios",
        height: '100%',
        loadComplete: function() {
            debugger
            //funcionExito($('#tablaUsuarios').jqGrid('getRowData'), urlbase);
        },
        onSelectRow: function(id){
            //funcionClickFila(jQuery('#tablaUsuarios').jqGrid('getRowData',id));
        }
    });
    jQuery("#tablaUsuarios").jqGrid('navGrid','#paginador',{
        edit:false,
        add:false,
        del:false
    });
}

function inicializarPaginaAdministracionUsuarios(urlbase)
{
    debugger
    inicilizarTablaUsuarios(urlbase);
}
