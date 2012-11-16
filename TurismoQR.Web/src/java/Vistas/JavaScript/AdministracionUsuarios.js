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
            width:210,
            editable: true
        },

        {
            name:'contraseña',
            index:'contraseña',
            width:210,
            editable: true
        },

        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#paginador',
        sortname: 'nombreUsuario',
        loadonce:true,
        viewrecords: true,
        sortorder: "desc",
        jsonReader: {
            repeatitems : false,
            id: "nombreUsuario"
        },
        caption: "Usuarios",
        height: '100%'
    });
    jQuery("#tablaUsuarios").jqGrid('navGrid','#paginador',{
        edit:true,
        add:true,
        del:true,
        reload: true
    });
}

function inicializarPaginaAdministracionUsuarios(urlbase)
{
    debugger
    inicilizarTablaUsuarios(urlbase);
}
