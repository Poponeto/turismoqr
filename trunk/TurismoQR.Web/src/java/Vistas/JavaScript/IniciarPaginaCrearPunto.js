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
                        $('#contenedorPrincipal').css('opacity','1');
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
        $('#contenedorPrincipal').css('opacity','0.5');
        $('#dialog').dialog('open');
        $('.ui-dialog-titlebar-close').click(function(){
            cancelarTodo();
        });
        $('#ui-dialog-title-dialog').text("Agregar imagenes");
        return false;
    });

    $('input[value="Crear punto"]').button();
    $('.ui-widget-header').focus();
    $('#idiomaSeleccionado').on("change", function(){
        $('input[name="idioma"]').attr("value", $(this).attr("value"));
    });
    $('#idiomaSeleccionado').change();
}

function cancelarTodo() {
    $('table[role="presentation"] tr').remove();
    $('#contenedorPrincipal').css('opacity','1');
}

function subirArchivos() {
    $('table[role="presentation"] td.start button').click();
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


