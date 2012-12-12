/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var funcionExito;
var mapaParaAgregarPuntos;
var funcionClickFila;
var funcionClickMarcador;
var markers = new Array();

function inicilizarTablaPuntos(urlbase)
{
    $('#tablaPuntos').GridUnload();
    crearTabla(urlbase + "/buscarPunto/obtenerInformacionTabla.htm", urlbase);
}

function filtroCategoria (categoria, urlbase) {
    $('#tablaPuntos').GridUnload();
    crearTabla(urlbase + "/buscarPunto/"+categoria+"/obtenerInformacionTablaCategoria.htm", urlbase);
}

function filtroUsuario (usuario, urlbase) {
    $('#tablaPuntos').GridUnload();
    crearTabla(urlbase + "/buscarPunto/"+usuario+"/obtenerInformacionTablaUsuario.htm", urlbase);
}

function filtroCategoriaUsuario (categoria, usuario, urlbase) {
    $('#tablaPuntos').GridUnload();
    crearTabla(urlbase + "/buscarPunto/"+categoria+"/"+usuario+"/obtenerInformacionTablaCategoriaUsuario.htm", urlbase);
}

function crearTabla(url, urlbase) {
    $.each(markers, function(){
        this.setMap(null);
    })

    jQuery("#tablaPuntos").jqGrid({
        url: url,
        datatype: "json",
        mtype: "GET",
        autowidth: true,
        loadonce:true,
        shrinkToFit: true,
        colNames:['Identificador','Nombre Identificador', 'Latitud', 'Longitud','Imagenes'],
        colModel:[
        {
            name:'identificador',
            index:'identificador',
            width:210,
            align:"center"
        },

        {
            name:'nombreIdentificador',
            index:'nombreIdentificador',
            width:210,
            align:"center"
        },

        {
            name:'latitud',
            index:'latitud',
            width:100,
            align:"center"
        },

        {
            name:'longitud',
            index:'longitud',
            width:100,
            align:"center"
        },

        {
            name:'tieneImagenes',
            index:'tieneImagenes',
            width:100,
            align:"center"
        },
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

            funcionExito($('#tablaPuntos').jqGrid('getRowData'), urlbase);
        },
        onSelectRow: function(id){
            funcionClickFila(jQuery('#tablaPuntos').jqGrid('getRowData',id));
        }
    });
    jQuery("#tablaPuntos").jqGrid('navGrid','#paginador',{
        edit:false,
        add:false,
        del:false
    });
}

function inicializarPaginaBuscarPuntos(urlbase, mapa)
{
    funcionExito = cargarPuntosEnMapa;
    funcionClickFila = navegarAPunto;
    mapaParaAgregarPuntos = mapa;
    
    inicilizarTablaPuntos(urlbase);
}

function cargarPuntosEnMapa(filas, url)
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

        markers.push(marker);

        google.maps.event.addListener(marker, 'click', function(){
            
            var marker = this;
            tqrmapas.marcadorActual = this;

            $.get(url + '/buscarPunto/obtenerMenuPunto.htm' , {idPunto: this.identificador}, function(data) {
                
                var infoWindow = new google.maps.InfoWindow({content : data});
                infoWindow.open(tqrmapas.mapa, marker);


            });
        });
    }
}

function navegarAPunto(fila)
{
    mapaParaAgregarPuntos.navegarAPosicion(fila.latitud, fila.longitud);
}
