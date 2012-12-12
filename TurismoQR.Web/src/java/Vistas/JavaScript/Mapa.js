/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 var tqrmapas = {

    mapa : null,
    marcadores : [],
    lat : null,
    lng : null,
    posicionMapa : null,
    browserSoportado : false,
    contenedorMapas : null,
    marcador : null,
    geocoder: null,
    marcadorActual : null,
    address : '',
    fullBounds : new google.maps.LatLngBounds(),

    /**
     * Crea el mapa y setea valores iniciales a los elementos.
     */
    iniciarMapas : function() {
        tqrmapas.geocoder = new google.maps.Geocoder();
        tqrmapas.contenedorMapas = "contenedorMapa";

        if($('#latitudPunto').attr('value') != '' && $('#longitudPunto').attr('value') != '') {
            tqrmapas.inicializarLocalizacion($('#latitudPunto').attr('value'), $('#longitudPunto').attr('value'), function(){
                tqrmapas.crearMapa();
                tqrmapas.crearNuevoMarcador("Posicion actual", function(){
                        var posicionInicialMarcador = tqrmapas.obtenerLocalizacionMarcador(tqrmapas.marcador);
                        $('#latitudValue').text(posicionInicialMarcador.lat());
                        $('#longitudValue').text(posicionInicialMarcador.lng());
                        $('#latitudPunto').attr('value', posicionInicialMarcador.lat());
                        $('#longitudPunto').attr('value', posicionInicialMarcador.lng());
                        tqrmapas.agregarEventoCambioPosicion();
                    });
            })
        } else {
            tqrmapas.obtenerUbicacionUsuario(function(){
            tqrmapas.crearMapa();
            tqrmapas.crearNuevoMarcador("Posicion actual", function(){
                        var posicionInicialMarcador = tqrmapas.obtenerLocalizacionMarcador(tqrmapas.marcador);
                        $('#latitudValue').text(posicionInicialMarcador.lat());
                        $('#longitudValue').text(posicionInicialMarcador.lng());
                        $('#latitudPunto').attr('value', posicionInicialMarcador.lat());
                        $('#longitudPunto').attr('value', posicionInicialMarcador.lng());
                        tqrmapas.agregarEventoCambioPosicion();
                    });
                });
            }
    },

    agregarEventoCambioPosicion : function() {
        google.maps.event.addListener(tqrmapas.marcador, 'position_changed', function(){
            var posicionActualMarcador = tqrmapas.obtenerLocalizacionMarcador(this);
            $('#latitudValue').text(posicionActualMarcador.lat());
            $('#longitudValue').text(posicionActualMarcador.lng());
            $('#latitudPunto').attr('value', posicionActualMarcador.lat());
            $('#longitudPunto').attr('value', posicionActualMarcador.lng());
        });
    },

    geocodeDireccion : function() {
        tqrmapas.address = '';

        tqrmapas.formatearDireccion($('#direccionPunto').attr('value'));
        tqrmapas.formatearDireccion($('#alturaPunto').attr('value'));
        tqrmapas.formatearDireccion($('#departamentoPunto').attr('value'));
        tqrmapas.formatearDireccion('Mendoza');
        
        tqrmapas.geocoder.geocode( {'address': tqrmapas.address}, function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            tqrmapas.mapa.setCenter(results[0].geometry.location);
            tqrmapas.marcador.setPosition(results[0].geometry.location);
          } else {
            alert("No se pudo realizar la geocodificacion por las siquientes razones: " + status);
          }
        });
      },

      /**
       * Formatea la direccion teniendo en cuenta si existe una coma o no anteriormente;
       */
      formatearDireccion : function(text) {
          if(text != '') {
              if(tqrmapas.address != '') {
                  tqrmapas.address += ','+text;
              } else {
                  tqrmapas.address += text;
              }
          }
      },
    
    /**
     * Obtiene la posicion actual del usuario
     * @param exito Funcion que sera ejecutada en caso de que la ubicacion del usuario se recupere con exito.
     */
    obtenerUbicacionUsuario : function(exito) {
      if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            tqrmapas.browserSoportado = true;
            tqrmapas.posicionMapa = tqrmapas.crearPosicionMapa(position, "html");
            exito();
        }, function() {
          tqrmapas.manejadorErrorGeo(tqrmapas.browserSoportado);
          exito();
        });
      } else if (google.gears) {
        var geo = google.gears.factory.create('beta.geolocation');
        geo.getCurrentPosition(function(position) {
            tqrmapas.browserSoportado = true;
            tqrmapas.posicionMapa = trqmapas.crearPosicionMapa(position, "gears");
            exito();
        }, function() {
          tqrmapas.manejadorErrorGeo(tqrmapas.browserSoportado);
          exito();
        });
      } else {
        browserSupportFlag = false;
        tqrmapas.manejadorErrorGeo(tqrmapas.browserSoportado);
        exito();
      }
    },

    /**
    * Manejador de error en caso de que la geolocalizacion no sea soportada por el browser
    */
    manejadorErrorGeo : function() {
        tqrmapas.lat = -32.88333;
        tqrmapas.lng = -68.81667;
    },

    /**
     * Crea un elemento posicion soportado por google maps en base a la ubicacion del usuario
     * @param position Elemento que define la posicion actual del usuario
     * @param fuente Especifica la fuente de la cual proviene la posicion actual del usuario
     */
    crearPosicionMapa : function(position, fuente) {
        var lat = null;
        var lon = null;
        if(fuente=="html"){
            lat = position.coords.latitude;
            lon = position.coords.longitude;
        }else if(fuente=="gears") {
            lat = position.latitude;
            lon = position.longitude;
        }
        tqrmapas.lat = lat;
        tqrmapas.lng = lon;
        ubicacion = new google.maps.LatLng(tqrmapas.lat, tqrmapas.lng);
        return ubicacion;
    },

    /**
     * Crea el mapa que sera utiliza en la aplicacion
     */
    crearMapa : function(funcion) {

        var coordenadas = new google.maps.LatLng(tqrmapas.lat, tqrmapas.lng);

        var opcionesMapa = {
            zoom: 15,
            center: coordenadas,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        tqrmapas.mapa = null;
        tqrmapas.mapa = new google.maps.Map(document.getElementById(tqrmapas.contenedorMapas), opcionesMapa);
        
        if(funcion) {
            funcion();
        }
    },

    /**
     * Devuelve la latitud y longitud del marcador seleccionado
     * @param marcador Elemento del cual se necesita saber la ubicacion
     */
    obtenerLocalizacionMarcador : function(marcador) {
        return marcador.getPosition();
    },

    /**
     * Permite crear un nuevo marcador
     * @param funcion Funcion a ejecutar luego de crear el marcador
     * @param latitud Latitud de la ubicacion del nuevo marcador
     * @param longitud Longitud de la ubicacion del nuevo marcador
     * @param titulo Titulo del nuevo marcador
     * @param draggable Define si el marcador es arrastrable
     */
    crearNuevoMarcador : function(titulo, funcion, latitud, longitud, draggable) {

        if(latitud == null && longitud == null) {
            latitud = tqrmapas.lat;
            longitud = tqrmapas.lng;
        }

        if(draggable == null) {
            draggable = true;
        }

        var latLong = new google.maps.LatLng(latitud, longitud);

        tqrmapas.fullBounds.extend(latLong);

        tqrmapas.marcador = new google.maps.Marker({
		    position: latLong,
		    draggable: draggable,
		    map: tqrmapas.mapa,
		    title: titulo
		});
                
        tqrmapas.marcadores.push(tqrmapas.marcador);

        tqrmapas.mapa.fitBounds(tqrmapas.fullBounds);

        tqrmapas.mapa.panTo(latLong);

        var infoWindow = new google.maps.InfoWindow({content : titulo});

        if(funcion) {
            funcion();
        }
    },

    /**
     * Abre una ventana de informacion sobre el marcador seleccionado
     * @param marcador Marcador seleccionado sobre el cual se abrira la ventana
     */
    abrirVentanaInformacion : function(marcador) {
        /**
         * Pendiente
         */
        return marcador;
    },



    navegarAPosicion : function(latitud, longitud) {
        var position = new google.maps.LatLng( latitud, longitud );
        tqrmapas.mapa.panTo(position);
    },

    inicializarLocalizacion : function(latitud, longitud, funcion) {
        tqrmapas.lat = latitud;
        tqrmapas.lng = longitud;

        if(funcion) {
            funcion();
        }
    },

    inicializarContenedor : function(idContenedor) {
        tqrmapas.contenedorMapas = idContenedor;
    },

    obtenerPuntosCercanos : function(pageContext, idPunto, latitud, longitud) {

        var distanciaRadio = 3000;

        $.mobile.showPageLoadingMsg();
        $.ajax({
            url : pageContext+"/buscarPunto/"+idPunto+"/"+distanciaRadio+"/puntosCercanos.htm",
            success : function(data){
                $.mobile.hidePageLoadingMsg();

                var puntoActual = new google.maps.LatLng(latitud, longitud);

                tqrmapas.inicializarContenedor('contenedorMapaCercanos');
                tqrmapas.mapa = tqrmapas.crearMapa(function(){
                    $.each($(data['rows']), function(){
                        var puntoDatos = new google.maps.LatLng($(this).attr('latitud'), $(this).attr('longitud'));
                        var distancia = google.maps.geometry.spherical.computeDistanceBetween(puntoActual, puntoDatos);

                        if(distancia < distanciaRadio){
                            tqrmapas.crearNuevoMarcador('', null, $(this).attr('latitud'), $(this).attr('longitud'), false);
                        }

                    });

                    $.mobile.changePage('#puntosCercanos');
                });
            },
            error : function() {
                $.mobile.hidePageLoadingMsg();
                alert('error');
            }
        });
    },

    obtenerPuntosRelacionados : function(pageContext, categoria) {

        $.mobile.showPageLoadingMsg();
        $.ajax({
            url : pageContext+"/buscarPunto/"+categoria+"/obtenerInformacionTablaCategoria.htm",
            success : function(data){
                $.mobile.hidePageLoadingMsg();
                
                tqrmapas.inicializarContenedor('contenedorMapaRelacionados');
                tqrmapas.crearMapa(function(){
                    var listaRelacionados = $('#listaRelacionados');

                    $.each($(data['rows']), function(){
                        tqrmapas.crearNuevoMarcador('', null, $(this).attr('latitud'), $(this).attr('longitud'), false);
                        listaRelacionados.append('<li><a href="javascript:tqrmapas.centrarMapa(\''+$(this).attr('latitud')+'\',\''+$(this).attr('longitud')+'\');">'+$(this).attr('nombreIdentificador')+'</a></li>');
                    });

                    $.mobile.changePage('#puntosRelacionados');
                });
            },
            error : function() {
                $.mobile.hidePageLoadingMsg();
                alert('error');
            }
        });
    },

    centrarMapa : function(latitud, longitud) {
        var latLong = new google.maps.LatLng(latitud, longitud);
        tqrmapas.mapa.panTo(latLong);
    }
};



