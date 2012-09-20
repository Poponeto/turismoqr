/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function crearMapa(latitud, longitud, contenedor) {

    var coordenadas= new google.maps.LatLng(latitud,longitud);

    var myOptions = {
        zoom: 4,
        center: coordenadas,
        mapTypeId: google.maps.MapTypeId.G_HYBRID_MAP
    };
  
    mapa = new google.maps.Map(document.getElementById(contenedor), myOptions);

    return mapa;
}