/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var funcionExito;
var mapaParaAgregarPuntos;
var funcionClickFila;
var funcionClickMarcador;

function inicilizarTablaPuntos(url)
{
    jQuery("#tablaPuntos").jqGrid({
                    url: url,
                    datatype: "json",
                    mtype: "GET",
                    colNames:['Identificador','Nombre Identificador', 'Latitud', 'Longitud','Links','Imagenes'],
                    colModel:[
                        {name:'identificador',index:'identificador', width:210},
                        {name:'nombreIdentificador',index:'nombreIdentificador', width:210},
                        {name:'latitud',index:'latitud', width:100},
                        {name:'longitud',index:'longitud', width:100, align:"right"},
                        {name:'tieneLinks',index:'tieneLinks', width:100, align:"right"},
                        {name:'tieneImagenes',index:'tieneImagenes', width:100,align:"right"},
                    ],
                    rowNum:10,
                    rowList:[10,20,30],
                    pager: '#paginador',
                    sortname: 'identificador',
                    viewrecords: true,
                    sortorder: "desc",
                    jsonReader: {
                        repeatitems : false,
                        id: "identificador"
                    },
                    caption: "Puntos de Interes",
                    height: '100%',
                    loadComplete: function() {

                        funcionExito($('#tablaPuntos').jqGrid('getRowData'));
                    },
                    onSelectRow: function(id){
                        funcionClickFila(jQuery('#tablaPuntos').jqGrid('getRowData',id));
                    }
                });
                jQuery("#tablaPuntos").jqGrid('navGrid','#paginador',{edit:false,add:false,del:false});
}

function inicializarPaginaBuscarPuntos(url, mapa)
{
    funcionExito = cargarPuntosEnMapa;
    funcionClickFila = navegarAPunto;
    funcionClickMarcador = mostrarMenuPunto;
    mapaParaAgregarPuntos = mapa;
    
    inicilizarTablaPuntos(url);
}

function cargarPuntosEnMapa(filas)
{
    for(var fila in filas)
    {
        //mapaParaAgregarPuntos.crearNuevoMarcador(filas[fila].nombreIdentificador, funcionClickMarcador ,filas[fila].latitud, filas[fila].longitud);
        
        var latLong = new google.maps.LatLng(filas[fila].latitud, filas[fila].longitud);
        
        var marker = new google.maps.Marker({
            position: latLong,
            map: tqrmapas.mapa,
            title: filas[fila].nombreIdentificador,
            identificador: filas[fila].identificador
         });

         google.maps.event.addListener(marker, 'click', function(){   
             alert(this.identificador);
         });
    }
}

function navegarAPunto(fila)
{
     mapaParaAgregarPuntos.navegarAPosicion(fila.latitud, fila.longitud);
}

function mostrarMenuPunto(posicion)
{
    alert(posicion);
}
