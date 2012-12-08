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
        colNames:['Identificador','Nombre de Usuario','Contraseña','Habilitado','Expirado','Bloqueado'],
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
        {
            name:'habilitado',
            index:'habilitado',
            width:210,
            editable: false
        },
        {
            name:'expirado',
            index:'expirado',
            width:210,
            editable: false
        },
        {
            name:'bloqueado',
            index:'bloqueado',
            width:210,
            editable: false
        },
        ],
        rowNum:10,
        onSelectRow: function(id){
            cargarInformacionUsuario(jQuery('#tablaUsuarios').jqGrid('getRowData',id));
        },
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
        edit:false,
        add:false,
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
    $("#informacionUsuario").hide();
    $("#botonReiniciarContraseniaUsuario").hide();
    $("#botonEliminarUsuario").hide();
    $("#botonDesbloquearUsuario").hide();

    $(":input").change(function(){
        removerErrorDeEntrada(this);
    });

    $("#botonReiniciarContraseniaUsuario").click(function(){

        var urlConsulta = urlbase + "/administracion/usuario/reiniciarContrasenia.htm";

        $.ajax({

            url: urlConsulta,
            data: {
                nombreUsuario: $("#nombreUsuario").text()
            },
            type: "POST",
            success: function(){
                location.reload(true);
            },
            error: function(){
                alert("A ocurrido un error al reiniciar contrasenia de usuario.");
            }

        });

    });

    $("#botonEliminarUsuario").click(function(){

        var urlConsulta = urlbase + "/administracion/usuario/eliminarUsuario.htm";

        $.ajax({

            url: urlConsulta,
            data: {
                nombreUsuario: $("#nombreUsuario").text()
            },
            type: "POST",
            success: function(){
                location.reload(true);
            },
            error: function(){
                alert("A ocurrido un error al eliminar usuario.");
            }

        });

    });

    $("#botonDesbloquearUsuario").click(function(){

        var urlConsulta = urlbase + "/administracion/usuario/desbloquearUsuario.htm";

        $.ajax({

            url: urlConsulta,
            data: {
                nombreUsuario: $("#nombreUsuario").text()
            },
            type: "POST",
            success: function(){
                location.reload(true);
            },
            error: function(){
                alert("A ocurrido un error al desbloquear usuario.");
            }

        });

    });

    $("#botonAgregarUsuario").click(function(){
        $('#popUpAgregarUsuario').dialog('open');
    });

    $("#popUpAgregarUsuario").dialog({
        autoOpen: false,
        width: '50%',
        buttons: {
            "Cancelar": function() {
                $('#Contenedor').css('opacity','1');
                $(this).dialog("close");
            },
            "Guardar": function() {

                var jsonUsuario = JSON.stringify(obtenerDatosUsuario());
                var urlConsulta = urlbase + "/administracion/usuario/crearUsuario.htm";
                debugger
                $.ajax({

                    url: urlConsulta,
                    data: jsonUsuario,
                    dataType: "json",
                    contentType: "application/json",
                    type: "POST",
                    success: function(){
                        location.reload(true);
                    },
                    error: function(jqXHR){
                        var errores = jqXHR["responseText"];
                        procesarErrores(jQuery.parseJSON(errores));
                    }

                });
            }
        },
        title: 'Crear Usuario.'
    });

    inicilizarTablaUsuarios(urlbase);
}

function cargarInformacionUsuario(fila)
{
    $("#nombreUsuario").text(fila.nombreUsuario);
    $("#contraseña").text(fila.contraseña);

    if(fila.bloqueado === "true")
    {
        $("#botonEliminarUsuario").hide();
        $("#botonDesbloquearUsuario").show(1000);
    }
    else{
        $("#botonDesbloquearUsuario").hide();
        $("#botonEliminarUsuario").show(1000);
    }

    $("#botonReiniciarContraseniaUsuario").show(1000);
    $("#informacionUsuario").show(1000);
}

function obtenerDatosUsuario()
{
    var datosUsuario = {};
    var datosRol = {};


    datosUsuario[$("#lineaDatosNombreUsuario").attr('name')] = $("#lineaDatosNombreUsuario").val();
    datosUsuario[$("#lineaDatosContraseña").attr('name')] = $("#lineaDatosContraseña").val();

    datosUsuario["dtoRol"] = datosRol;
    datosRol['nombreRol'] = $("#selectRol").val();

    return datosUsuario;

}