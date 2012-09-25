package TurismoQR.ObjetosNegocio.Punto;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;

public class Localizacion implements IObjetoNegocio
{

    private String latitud;
    private String longitud;
    private String idObjeto;

    public Localizacion() {
        
    }

    public Localizacion(String latitud, String longitud, String idObjeto) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.idObjeto = idObjeto;
    }

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public String getLatitud()
    {
        return latitud;
    }

    public void setLatitud(String latitud)
    {
        this.latitud = latitud;
    }

    public String getLongitud()
    {
        return longitud;
    }

    public void setLongitud(String longitud)
    {
        this.longitud = longitud;
    }
}
