/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var tqrformnav = {
    forms : new Array(),

    init : function(forms) {
        forms.each(function(){
            tqrformnav.forms.push($(this).attr('id'));
        });
    },

    anterior : function(form) {
        var formId = form.attr('id');
        var index = $.inArray(formId, tqrformnav.forms);
        var previousIndex = index - 1;
        if(previousIndex >= 0) {
            $('#'+formId).fadeOut(1000, function(){
                $('#'+tqrformnav.forms[previousIndex]).fadeIn('slow', function() {
                   if($('#'+tqrformnav.forms[nextIndex]).find('#galeriaImagenes').length != 0) {
                       initGaleria();
                   }
               });
            });
            $('#next').removeClass('disabled');
            $('#previous').removeClass('disabled');
            if (previousIndex == 0) {
                $('#previous').addClass('disabled');
            }
        }
    },

    siguiente : function(form) {
        var formsLength = tqrformnav.forms.length;
        var formId = form.attr('id');
        var index = $.inArray(formId, tqrformnav.forms);
        var nextIndex = index + 1;
        if(nextIndex <= formsLength - 1) {
            $('#'+formId).fadeOut(1000, function(){
               $('#'+tqrformnav.forms[nextIndex]).fadeIn('slow', function() {
                   if($('#'+tqrformnav.forms[nextIndex]).find('#galeriaImagenes').length != 0) {
                       initGaleria();
                   }
               });
            });
            $('#next').removeClass('disabled');
            $('#previous').removeClass('disabled');
            if (nextIndex == formsLength - 1) {
                $('#next').addClass('disabled');
            }
        }
    }
};


