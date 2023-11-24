package logica;

import java.util.Date;

public class Persona 
{
    private String _nombre, _apellido, _dni;
    private Date _fechaNacimiento;

    public Persona(String nombre, String apellido, String dni, Date fechaNacimiento)
    {
        if (dni.length() != 8)
        {
            throw new RuntimeException("argumentos inválidos.");
        }
        _nombre = nombre;
        _apellido = apellido;
        _dni = dni;
        _fechaNacimiento = fechaNacimiento;
    }

    public String getNombre()
    {
        return _nombre;
    }

    public String getApellido()
    {
        return _apellido;
    }

    public String getDni()
    {
        return _dni;
    }

    public Date getFechaNacimiento()
    {
        return _fechaNacimiento;
    }

    @Override
    public String toString() {
       return "nombre: " + _nombre + ", apellido: " + _apellido + ", dni: " + _dni + ", fecha nacimiento: " + _fechaNacimiento;
    }
}
