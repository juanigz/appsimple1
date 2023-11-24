package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Registro 
{
    public static ArrayList<Persona> _listaPersonas = new ArrayList<>();

    public static Persona generarPersona(String nombre, String apellido, String dni, Date fecha)
    {
        Persona persona = new Persona(nombre, apellido, dni, fecha);
        return persona;
    }

    public static List<Persona> registrarPersona(Persona persona)
    {
        if(!yaIngresada(persona, _listaPersonas))
        {
            _listaPersonas.add(persona);
            System.out.println("persona registrada!");
        }
        else System.out.println("persona ya existente en listado de personas registradas.");
        return _listaPersonas;
    }

    // public boolean eliminarPersona(Persona persona)
    // {
    //     if(_listaPersonas.contains(persona))
    //     {
    //         _listaPersonas.remove(persona);
    //         System.out.println("persona eliminada!");
    //         return true;
    //     }
    //     System.out.println("persona inexistente en listado de personas registradas.");
    //     return false;
    // }

    // public boolean existePersona(Persona persona)
    // {
    //     return _listaPersonas.contains(persona);
    // }

    // public void mostrarPersona(Persona persona)
    // {
    //     if( existePersona(persona) )
    //     {
    //         System.out.println( "Consulta por la persona: " + persona.getApellido() + 
    //         ", " + persona.getNombre() + "\nfecha de nacimiento: " + persona.getFechaNacimiento() + 
    //         "\ndni: " + persona.getDni() );
    //     }

    //     else System.out.println( "persona inexistente en los registros." );
    // }

    private static boolean yaIngresada(Persona persona, List<Persona> personas) {
        for (Persona p : personas) {
	    	if (p.getNombre() == persona.getNombre() && p.getApellido() == persona.getApellido() && p.getDni() == persona.getDni()){
	    		return true;
	    	}
	    }
	    return false;
    }
}
