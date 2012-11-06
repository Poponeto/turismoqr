/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Usuarios.Persona;
import java.util.Date;

/**
 *
 * @author Federico
 */
public class DTOPersona extends DTOCliente implements IDTO<Persona>
{

    private String apellido;
    private String nombre;
    private String dni;
    private String sexo;
    private Date fechaDeNacimiento;

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public Date getFechaDeNacimiento()
    {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento)
    {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    @Override
    public String getNombreCliente()
    {
        return getApellido() + " " + getNombre();
    }

    @Override
    public String getTipoCliente()
    {
        return "Persona";
    }
}
