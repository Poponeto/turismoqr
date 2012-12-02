/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var tqrgaleria = {

    comentariosGaleria : new Array(),

    initVistaDetalles : function(contenedor) {
        $( document ).on('mouseover', '#'+contenedor+' img[id*="img"]', 
        function(event){

            // Obtenemos la imagen sobre la que se esta trabajando.
            var imagen = $(event.target).attr('src').substring($(event.target).attr('src').lastIndexOf('\\') + 1);

            $('#textoComentario').text('');

            $.each(tqrgaleria.comentariosGaleria, function(){
                if(this.imagenGaleria == imagen || this.imagenGaleria.indexOf(imagen) != -1) {
                    $('#textoComentario').text(this.comentarioImagen);
                }
            });

            // Acomodamos la barra de herramientas
            $('#barraHerramientas').css('top',$('#contenedorPreviewImagenes img[id*="img"]').position().top + 'px');
            $('#barraHerramientas').css('left',$('#contenedorPreviewImagenes img[id*="img"]').position().left + 'px');
            $('#barraHerramientas').css('width',$('#contenedorPreviewImagenes img[id*="img"]').outerWidth() + 'px');

            // Acomodamos la barra de comentarios
            $('#barraComentario').css('top',$('#contenedorPreviewImagenes img[id*="img"]').position().top + $('#contenedorPreviewImagenes img[id*="img"]').outerHeight() - $('#barraComentario').outerHeight() + 'px');
            $('#barraComentario').css('left',$('#contenedorPreviewImagenes img[id*="img"]').position().left + 'px');
            $('#barraComentario').css('width',$('#contenedorPreviewImagenes img[id*="img"]').outerWidth() + 'px');

            // Agregamos los manejadores para agregar un comentario y borrar una imagen
            $('#agregarComentario').attr('href','javascript:tqrgaleria.agregarComentario(\''+ imagen +'\')');
            $('#borrarImagen').attr('href','javascript:tqrgaleria.eliminarImagen(\''+ imagen +'\')');
            $('#formularioComentario').attr('action',imagen);
            $('#barraHerramientas').fadeIn(1000);
            if($('#textoComentario').text() != '') {
               $('#barraComentario').fadeIn(1000);
            }
            return false;
        }).mouseout(
        function(){
            $('#barraHerramientas').fadeOut(1000);
            $('#barraComentario').fadeOut(1000);
            return false;
        });
    },

    eliminarImagen : function(imagen) {
        $.ajax({
            url: $('#requestContext').text().trim()+'/administracion/crearPunto/'+imagen+'/borrarArchivo.htm',
            success : function(data) {
                tqrgaleria.quitarImagenDeGaleria(imagen);
            }
        });
    },

    agregarComentario : function() {

        if($('#textoComentario').text() != '') {
            $('#comentario').text($('#textoComentario').text());
        }

        $('#dialogComentario').dialog('open');
        deshabilitarFormulario();
        $('#ui-dialog-title-dialogComentario').text("Agregar comentario");
    },

    subirComentario : function(imagen) {
        var comentario = $('#comentario').val();

        while(comentario.indexOf(' ') != -1) {
            comentario = comentario.replace(' ', '_');
        }

        $.ajax({
            url : $('#requestContext').text().trim()+'/administracion/crearPunto/'+comentario+'/'+imagen+'/agregarComentario.htm',
            success : function(data) {
                tqrgaleria.mostrarComentario(data.mensaje, imagen);
            }
        });
    },

    mostrarComentario : function(comentario, imagen) {
        tqrgaleria.comentariosGaleria.push({
            imagenGaleria : imagen,
            comentarioImagen : comentario
        });
    },

    quitarImagenDeGaleria : function(imagen) {
        //Guardamos la galeria actual;
        var galeria = $('#galeriaImagenes');

        // Removemos la imagen borrada
        galeria.find('img').each(function(){
            if($(this).attr('src').indexOf(imagen) != -1) {
                $(this).parents('li').remove();
            }
        });

        // Obtenemos el codigo de la galeria restante
        var padreGaleria = galeria.parent();
        var codigoGaleria = padreGaleria.html();

        //Borramos la galeria
        galeria.fadeOut(1000, function(){
            galeria.remove();
        });

        // Buscamos las imagenes en el codigo de la galeria removida
        var imagenes = $(codigoGaleria).find('img');

        //Creamos una nueva galeria que contendra las imagenes
        var nuevaGaleria = $('<ul id="galeriaImagenes" style="display: none;">');

        //Agregamos las imagenes que existian
        imagenes.each(function(){
            var src = $(this).attr('src');
            nuevaGaleria.append('<li><img src="' + src + '"/></li>');
        });

        //Agregamos la nueva galeria a la pagina
        padreGaleria.append(nuevaGaleria);

        //Inicializamos la galeria
        nuevaGaleria.jcoverflip();

        //Mostramos la galeria
        nuevaGaleria.fadeIn(1000, function() {
            tqrgaleria.initGaleria();
        });
    },
    
    agregarImagenesASlide : function() {
        //Guardamos la galeria actual;
        var galeria = $('#galeriaImagenes');
        var padreGaleria = galeria.parent();
        var codigoGaleria = padreGaleria.html();

        //Borramos la galeria
        galeria.fadeOut(1000, function(){
            galeria.remove();
        });

        var imagenesActuales = $(codigoGaleria).find('img');

        //Creamos una nueva galeria que contendra las nuevas imagenes
        var nuevaGaleria = $('<ul id="galeriaImagenes" style="display: none;">');

        //Agregamos las imagenes que existian
        imagenesActuales.each(function(){
            var src = $(this).attr('src');
            nuevaGaleria.append('<li><img src="' + src + '"/></li>');
        });

        //Agregamos las nuevas imagenes
        var imagenesSubidas = $('table[role="presentation"] img');
        imagenesSubidas.each(function(){
            var src = $(this).attr('src');
            nuevaGaleria.append('<li><img src="' + src + '"/></li>');
        });

        //Agregamos la nueva galeria a la pagina
        padreGaleria.append(nuevaGaleria);

        //Inicializamos la galeria
        nuevaGaleria.jcoverflip();

        //Mostramos la galeria
        nuevaGaleria.fadeIn(1000, function() {
            tqrgaleria.initGaleria();
        });

    },

    initGaleria : function() {

        var itemsGaleriaInicial = $('ul.ui-jcoverflip img');

        $('#contenedorPreviewImagenes').find('img[id*="img"]').remove();

        $('#galeriaImagenes').on('click', function() {
            var itemsGaleria = $('ul.ui-jcoverflip img');

            $(itemsGaleria[0]).click(function(event){
                event.preventDefault();
                event.stopPropagation();
                return false;
            });

            var elementoEnContenedor = $('#contenedorPreviewImagenes').find('img[id*="img"]');
            var idElementoEnContenedor = elementoEnContenedor.attr('id');
            if(idElementoEnContenedor != undefined &&
                $.ui.jcoverflip.defaults.current != idElementoEnContenedor.substring(3, idElementoEnContenedor.length)) {
                elementoEnContenedor.fadeOut(1000, function() {
                    $(this).remove();
                    $('#contenedorPreviewImagenes').find('img[id*="img"]').remove();
                    $('#contenedorPreviewImagenes')
                    .append('<img id ="img'
                        + $.ui.jcoverflip.defaults.current
                        + '" style="display: none;" src="'
                        + $(itemsGaleria[$.ui.jcoverflip.defaults.current]).attr('src')
                        + '">');
                    $('#img' + $.ui.jcoverflip.defaults.current).fadeIn(1000);
                })
            } else {
                $('#contenedorMensaje').remove();
                $('#contenedorPreviewImagenes').find('img[id*="img"]').remove();
                $('#contenedorPreviewImagenes')
                    .append('<img id ="img'
                        + $.ui.jcoverflip.defaults.current
                        + '" style="display: none;" src="'
                        + $(itemsGaleria[$.ui.jcoverflip.defaults.current]).attr('src')
                        + '">');
                    $('#img' + $.ui.jcoverflip.defaults.current).fadeIn(1000);
            }
        });

        $(itemsGaleriaInicial[2]).click();
        $(itemsGaleriaInicial[1]).click();

        tqrgaleria.initVistaDetalles('contenedorPreviewImagenes');
    },

    initComentarios : function() {
        imagenesGaleria = $('#galeriaImagenes').find('img');
        $.each(imagenesGaleria, function(){
            tqrgaleria.comentariosGaleria.push({
                imagenGaleria : $(this).attr('src').substring(),
                comentarioImagen : $(this).attr('alt')
            });
        })
    }
}
