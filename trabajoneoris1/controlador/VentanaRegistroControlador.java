package controlador;

import java.util.Date;
import java.util.List;

import interfaz.VentanaRegistro;
import logica.Persona;
import logica.Registro;

public class VentanaRegistroControlador 
{
    static VentanaRegistro ventanaRegistro = new VentanaRegistro();

    public static void mostrar()
    {
        ventanaRegistro.setVisible(true);
    }

    public static void cerrar()
    {
        ventanaRegistro.setVisible(false);
    }

    public static Persona generarPersona(String nombre, String apellido, String dni, Date fecha)
    {
        return Registro.generarPersona(nombre, apellido, dni, fecha);
    }

    public static List<Persona> registrarPersona(Persona persona)
    {
        return Registro.registrarPersona(persona);
    }

}
