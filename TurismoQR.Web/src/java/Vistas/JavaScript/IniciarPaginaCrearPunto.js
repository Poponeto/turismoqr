/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function iniciarCrearPunto() {
    $('#dialog').dialog({
        autoOpen: false,
        width: '60%',
        buttons: {
                "Ok": function() {
                        tqrgaleria.agregarImagenesASlide();
                        cancelarTodo();
                        $(this).dialog("close");
                },
                "Cancel": function() {
                        cancelarTodo();
                        $(this).dialog("close");
                }
        }
    });

    $('#dialogError').dialog({
        autoOpen: false,
        width: '60%',
        buttons: {
                "Ok": function() {
                        $(this).dialog("close");
                }
        }
    });

    $('#dialog_link').click(function(){
        deshabilitarFormulario();
        $('#dialog').dialog('open');
        $('.ui-dialog-titlebar-close').click(function(){
            cancelarTodo();
        });
        $('#ui-dialog-title-dialog').text("Agregar imagenes");
        return false;
    });

    $('input[value="Crear punto"]').button();
    $('.ui-widget-header').focus();
    $('#selectIdiomas').on("change", function(){
        $('input[name="idioma"]').attr("value", $(this).attr("value"));
    });
    $('#selectIdiomas').change();
}

function cancelarTodo() {
    $('table[role="presentation"] tr').remove();
    habilitarFormulario();
}

function subirArchivos() {
    $('table[role="presentation"] td.start button').click();
}

function deshabilitarFormulario() {
    $('#contenedorPrincipal').css('opacity','0.5');
    $('#contenedorPrincipal').css('pointer-events', 'none');
    $('div.navBar').css('opacity','0.5');
    $('div.navBar').css('pointer-events', 'none');
}

function habilitarFormulario() {
    $('#contenedorPrincipal').css('opacity','1');
    $('#contenedorPrincipal').css('pointer-events', 'initial');
    $('div.navBar').css('opacity','1');
    $('div.navBar').css('pointer-events', 'initial');
}

function ocultarCampoComentario() {
    var clickElement  = $(event.target).parents('tr');
    clickElement.next().remove();
}

function agregarInputComentario() {
    var clickElement  = $(event.target).parents('tr');


    if (clickElement.next().find('textarea').size() == 0) {
        var idtextareaRow = Math.floor(10000000 * (Math.random() % 1));
        var textareaRow = $(
        '<tr id="' + idtextareaRow + '" class="template-upload fade in">'
            +'<td colspan="5">'
                +'<textarea name="comentarioImagen" style="width: 99%;"></textarea>'
                    +'</td><td><input type="button" class="btn btn-danger" value="Remover">'
                    +'</button></td></tr>')

        clickElement.after(textareaRow);

        clickElement.prev().find('td.cancel button').click(function(){
            $('#'+idtextareaRow).remove();
        });

        $('#'+idtextareaRow+' input[value="Remover"]').click(function(){
            $('#'+idtextareaRow).remove();
        });
    }
}

function verificarPuntoPorNombre(requestContext, nombrePunto) {
    $('#esperaVerificacion').show(1000);

    $.ajax({
        url : requestContext+'/administracion/crearPunto/'+nombrePunto+'/verificarPuntoPorNombre.htm',
        success : function(data) {
            $('#esperaVerificacion').hide(1000);
            if(data.estadoOperacion == "ERROR") {
                $('#nombrePuntoError').text(data.mensaje);
                $('#nombrePuntoError').show(1000);
            }
        }
    });
}

function verificarPuntoPorLocalizacion(requestContext, latitud, longitud, callback) {
    $('#esperaVerificacionLocalizacion').show(1000);

    var jsonfile={latitud:latitud, longitud:longitud};

    $.ajax({
        type : 'POST',
        url : requestContext+'/administracion/crearPunto/verificarPuntoPorLocalizacion.htm',
        data : jsonfile,
        success : function(data) {
            $('#esperaVerificacionLocalizacion').hide(1000);
            if(data.estadoOperacion == "ERROR") {
                $('#localizacionPuntoError').text(data.mensaje);
                $('#localizacionPuntoError').show(1000);

                tqrformnav.errorVerificacion = true;
            } else {
                tqrformnav.errorVerificacion = false;
                callback();
            }
        },
        dataType : "json"
    });
}

