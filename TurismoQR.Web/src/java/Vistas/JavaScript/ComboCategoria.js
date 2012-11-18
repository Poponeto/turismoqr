/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function inicializarCambioCategoriaPunto()
{
//    var urlActual = location.href;
//    var stringConIdioma = String(urlActual.match( /informacionPunto\/[A-z]+/));
//
//    var idiomaActual = stringConIdioma.replace(/informacionPunto\//, "");
//
//    seleccionarElemento(idiomaActual);
//
//    $('#selectIdiomas').change(function() {
//
//        var idiomaSeleccionado = this.options[this.selectedIndex].text;
//
//        var urlActual = location.href;
//        var urlGenerado = urlActual.replace( /informacionPunto\/[A-z]+/ ,"informacionPunto/" + idiomaSeleccionado);
//
//        window.location.replace(urlGenerado);
//    });
//
//    function seleccionarElemento(valor)
//    {
//        $("#selectIdiomas option[value="+valor+"]").attr("selected",true);
//
//    }

    $.ajax({
      url: location.href
    }).done(function ( data ) {
      if( console && console.log ) {
        console.log("Sample of data:", data.slice(0, 100));
      }
    });
}