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
          tqrmapas.manejadorErrorGeo(browserSoportado);
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
     * @param contenedor Contenedor en el cual se alojara el mapa
     */
    crearMapa : function() {

        var coordenadas = new google.maps.LatLng(tqrmapas.lat, tqrmapas.lng);

        var opcionesMapa = {
            zoom: 15,
            center: coordenadas,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        tqrmapas.mapa = new google.maps.Map(document.getElementById(tqrmapas.contenedorMapas), opcionesMapa);
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
     */
    crearNuevoMarcador : function(titulo, funcion, latitud, longitud) {

        if(latitud == null && longitud == null) {
            latitud = tqrmapas.lat;
            longitud = tqrmapas.lng;
        }
        var latLong = new google.maps.LatLng(latitud, longitud);

        tqrmapas.marcador = new google.maps.Marker({
		    position: latLong,
		    draggable: true,
		    map: tqrmapas.mapa,
		    title: titulo
		});

        var infoWindow = new google.maps.InfoWindow({content : titulo});

        google.maps.event.addListener(tqrmapas.marcador, 'click', function(){
            infoWindow.open(tqrmapas.contenedorMapas, this);
	});

        if(funcion){
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
    }
};


