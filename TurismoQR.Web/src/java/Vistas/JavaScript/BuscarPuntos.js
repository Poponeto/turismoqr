/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function inicilizarTablaPuntos()
{
    jQuery("#tablaPuntos").jqGrid({
                    url:'${pageContext.request.contextPath}/buscarPunto/obtenerInformacionTabla.htm',
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
                    height: '100%'
                });
                jQuery("#tablaPuntos").jqGrid('navGrid','#paginador',{edit:false,add:false,del:false});
}