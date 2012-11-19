/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function inicilizarTablaUsuarios(urlbase)
{
    jQuery("#tablaUsuarios").jqGrid({
        url: urlbase + "/administracion/usuario/obtenerInformacionTabla.htm",
        editurl: urlbase + "/administracion/usuario/editarUsuario.htm",
        datatype: "json",
        mtype: "GET",
        autowidth: true,
        loadonce:true,
        shrinkToFit: true,
        colNames:['Identificador','Nombre de Usuario','Contraseña'],
        colModel:[
        {
            name:'idUsuario',
            index:'idUsuario',
            width:210
        },
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
    
    });
}

function inicializarPaginaAdministracionUsuarios(urlbase)
{
    debugger
    inicilizarTablaUsuarios(urlbase);
}
