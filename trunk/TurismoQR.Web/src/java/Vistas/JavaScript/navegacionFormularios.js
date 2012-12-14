/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var tqrformnav = {
    forms : new Array(),
    requestContext : '',
    errorVerificacion : false,

    init : function(forms) {
        forms.each(function(){
            tqrformnav.forms.push($(this).attr('id'));
        });
    },

    initRequestContext : function(requestContext) {
        tqrformnav.requestContext = requestContext;
    },

    anterior : function(form) {
        tqrformnav.validarFormularios(function(){
            var formId = form.attr('id');
            var index = $.inArray(formId, tqrformnav.forms);
            var previousIndex = index - 1;
            if(previousIndex >= 0) {
                $('#next').text('Siguiente');
                $('#next').attr('href','javascript:tqrformnav.siguiente($(\'fieldset:visible\'));');
                $('#'+formId).fadeOut(1000, function(){
                    $('#'+tqrformnav.forms[previousIndex]).fadeIn('slow', function() {
                       if($('#'+tqrformnav.forms[previousIndex]).find('#galeriaImagenes').length != 0) {
                           tqrgaleria.initGaleria();
                       }
                   });
                });
                $('#next').removeClass('disabled');
                $('#previous').removeClass('disabled');
                if (previousIndex == 0) {
                    $('#previous').addClass('disabled');
                }
            }
        });
    },

    siguiente : function(form) {
        tqrformnav.validarFormularios(function(){
            var formsLength = tqrformnav.forms.length;
            var formId = form.attr('id');
            var index = $.inArray(formId, tqrformnav.forms);
            var nextIndex = index + 1;
            if(nextIndex <= formsLength - 1) {

                $('#'+formId).fadeOut(1000, function(){
                   $('#'+tqrformnav.forms[nextIndex]).fadeIn('slow', function() {
                       if($('#'+tqrformnav.forms[nextIndex]).find('#galeriaImagenes').length != 0) {
                           tqrgaleria.initGaleria();
                       }
                   });
                });
                $('#next').removeClass('disabled');
                $('#previous').removeClass('disabled');
                if (nextIndex == formsLength - 1) {
                    $('#next').text('Guardar punto');
                    $('#next').attr('href','javascript:$(\'#nuevoPuntoDeInteres\').submit();');
                }
            }
        });
    },


    validarFormularios : function (callback) {
        var inputsVacios = false;

        var fieldsetVisible = $('fieldset:visible');

        if(fieldsetVisible.attr('id') == 'camposInformacionPunto'){
            if($('#nombrePunto').val() == ''){
                $('#nombrePuntoError').text('No puedes dejar este campo vacio');
                $('#nombrePuntoError').show(1000);

                $('#esperaVerificacion').css('display', 'none');

                inputsVacios = true;
            }

            if($('#categoria').val() == 'default'){
                $('#categoriaPuntoError').text('Debes seleccionar una categoria');
                $('#categoriaPuntoError').show(1000);

                inputsVacios = true;
            }

            if(!inputsVacios){
//            alert('Por favor, llena todos los campos requeridos antes de continuar');
//        } else {
                callback();
            }
        }

        if(fieldsetVisible.attr('id') == 'camposLocalizacionPunto'){
            verificarPuntoPorLocalizacion(tqrformnav.requestContext, $('#latitudValue').text(), $('#longitudValue').text(), function(){
                if(!tqrformnav.errorVerificacion){
    //            alert('Por favor, llena todos los campos requeridos antes de continuar');
    //        } else {
                    callback();
                }
            });

            
        }

//        var inputsVisibles = $('fieldset:visible :input');
//        var inputsVacios = false;

//        inputsVisibles.each(function(){
//            if($(this).attr('required') != undefined
//                && ($(this).attr('value') == '' && $(this).text() == '')) {
//                inputsVacios = true;
//            }
//        });
    }
};


