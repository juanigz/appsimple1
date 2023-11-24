package interfaz;

import java.util.Date;
import java.util.List;

import javax.swing.*;

import controlador.VentanaRegistroControlador;
import logica.Persona;

public class VentanaRegistro extends JFrame 
{
    private JLabel labelNombre;
    private JLabel labelApellido;
    private JLabel labelDNI;
    private JLabel labelFechaNacimiento;

    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoDNI;
    private JSpinner campoFechaNacimiento;

    private JButton botonGenerarPersona;
    private JButton botonVerRegistro;

    private List<Persona> personas;

    public VentanaRegistro() 
    {
        inicializar();
    }

    public void inicializar() 
    {
        // Configura el JFrame
        this.setTitle("Registro de Persona");
        this.setBounds(800, 400, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define los componentes
        labelNombre = new JLabel("Nombre:");
        campoNombre = new JTextField();

        labelApellido = new JLabel("Apellido:");
        campoApellido = new JTextField();

        labelDNI = new JLabel("DNI:");
        campoDNI = new JTextField();

        labelFechaNacimiento = new JLabel("Fecha Nacimiento:");
        campoFechaNacimiento = new JSpinner(new SpinnerDateModel());
        campoFechaNacimiento.setEditor(new JSpinner.DateEditor(campoFechaNacimiento, "dd/MM/yyyy"));

        botonGenerarPersona = new JButton("Enviar");
        botonVerRegistro = new JButton("Ver Registro");

        // Agrega los componentes al JFrame
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(labelNombre);
        panel.add(campoNombre);
        panel.add(labelApellido);
        panel.add(campoApellido);
        panel.add(labelDNI);
        panel.add(campoDNI);
        panel.add(labelFechaNacimiento);
        panel.add(campoFechaNacimiento);
        panel.add(botonGenerarPersona);
        panel.add(botonVerRegistro);

        this.add(panel);

        // Agrega un ActionListener al botón de envío
        botonGenerarPersona.addActionListener(e -> {
            String nombre = campoNombre.getText();
            String apellido = campoApellido.getText();
            String dni = campoDNI.getText();
            // formato : dia-mes-año
            Date fecha = (Date) campoFechaNacimiento.getValue();

            // validaciones:
            if ( !isNumeric(dni) || dni.length() != 8 ) 
            {
                JOptionPane.showMessageDialog(this, "ingrese DNI válido.");
            }

            // usando el método JSpinner, con DateEditor, las fechas ingresadas siempre respetarán el formato válido, sin importar lo que el usuario 
            // ingrese. por ende, no fue necesario realizar manejo de excepciones para las fechas.

            if (!apellido.isBlank() || !nombre.isBlank()) 
            {
                Persona per = VentanaRegistroControlador.generarPersona(nombre, apellido, dni, fecha);
                personas = VentanaRegistroControlador.registrarPersona(per);
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Persona registrada!");			
            }
            else 
            {					
                JOptionPane.showMessageDialog(null, "El apellido o el nombre no pueden estar vacíos.");
            }

        });

        botonVerRegistro.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Abriendo registro!");
            for (Persona persona : personas)
            {
                System.out.println(persona.toString());
                // impresión directamente por consola usando toString desde logica.persona, no hacía falta otra pantalla.
            }
        });
    }

    // validación del documento dentro de la interfaz.
    private static boolean isNumeric(String s) {
        if (s == null || s.equals("")) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private void limpiarCampos() {
	    campoNombre.setText("");
		campoApellido.setText("");
		campoDNI.setText("");
	}

}
