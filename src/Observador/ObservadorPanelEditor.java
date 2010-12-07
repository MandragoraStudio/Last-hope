/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Graficos.Lienzo;
import Panel.ContenidoEditor;
import java.awt.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class ObservadorPanelEditor implements IObservador {

    private Boton boton; //boton al que observa

    public ObservadorPanelEditor(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        if (boton.getNombre().equals("creaBotonCreador")) {
            ContenidoEditor.creaBotonCreador();
        } else if (boton.getNombre().equals("Nombre")) {
            String nombre = JOptionPane.showInputDialog(null, "Introduzca el Nombre de la torre:", "Nombre", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Nombre", nombre);
        } else if (boton.getNombre().equals("Daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de daño:", "Daño", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Daño", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }

        } else if (boton.getNombre().equals("Rango")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Rango:", "Rango", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Rango", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Área de daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Área de daño:", "Área de daño", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Área de daño", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Congelación")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Congelación:", "Congelación", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Congelación", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Fuego")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Fuego:", "Fuego", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Fuego", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Veneno")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Veneno:", "Veneno", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Veneno", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Recarga")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Recarga:", "Recarga", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Recarga", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Penetración")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Penetración:", "Penetración", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Penetración", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("cambiaImagen")) {
            ContenidoEditor.cambiaImagen("imagenes/torrePanel.png");
        } else if (boton.getNombre().equals("cambiaImagen2")) {
            ContenidoEditor.cambiaImagen("imagenes/torrePanel2.png");
        } else if (boton.getNombre().equals("cambiaImagen3")) {
            ContenidoEditor.cambiaImagen("imagenes/torrePanel3.png");
        } else if (boton.getNombre().equals("cambiaImagenPorTeclado")) {
            String cad = JOptionPane.showInputDialog(null, "Introduzca La ruta de la imagen:", "Imagen: ", JOptionPane.INFORMATION_MESSAGE);

            Image i = Lienzo.cargarImagen(cad);
            if (i != null) {
                ContenidoEditor.cambiaImagen(cad);
            } else {
                JOptionPane.showMessageDialog(null, "Ruta incorrecta: " + cad);
            }

        }
    }
}
