/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Graficos.Lienzo;
import Handlers.Buscador;
import Mapa.Ventana_Mapa;
import Panel.ContenidoEditor;
import UtilMath.Vector2D;
import java.awt.Image;
import java.net.URL;
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
            ContenidoEditor.getContenidoEditor().creaBotonCreador();
        } else if (boton.getNombre().equals("Nombre")) {
            String nombre = JOptionPane.showInputDialog(null, "Introduzca el Nombre de la torre:", "Nombre", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.getContenidoEditor().inicializaAtributo("Nombre", nombre);
        } else if (boton.getNombre().equals("Daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de daño:", "Daño", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Daño", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }

        } else if (boton.getNombre().equals("Rango")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Rango:", "Rango", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Rango", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Área de daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Área de daño:", "Área de daño", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Área de daño", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Congelación")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Congelación:", "Congelación", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Congelación", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Fuego")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Fuego:", "Fuego", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Fuego", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Veneno")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Veneno:", "Veneno", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Veneno", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Recarga")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Recarga:", "Recarga", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Recarga", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("Penetración")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Penetración:", "Penetración", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Penetración", nivel);
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (boton.getNombre().equals("cambiaImagen")) {
            ContenidoEditor.getContenidoEditor().cambiaImagen("imagenes/Misiles.png");
        } else if (boton.getNombre().equals("cambiaImagen2")) {
            ContenidoEditor.getContenidoEditor().cambiaImagen("imagenes/torrePanel2.png");
        } else if (boton.getNombre().equals("cambiaImagen3")) {
            ContenidoEditor.getContenidoEditor().cambiaImagen("imagenes/Gatling.png");
        } else if (boton.getNombre().equals("cambiaImagenPorTeclado")) {
            URL url = Buscador.busca();
            Image i = null;
            i = Lienzo.cargarImagen(url);
            i = i.getScaledInstance(Ventana_Mapa.getCasillaWidth(), Ventana_Mapa.getCasillaHeight(), Image.SCALE_DEFAULT);
            Lienzo.imagenes.remove(url.getFile());
            if (i != null) {
                ContenidoEditor.getContenidoEditor().cambiaImagen(i);
            } else {
                JOptionPane.showMessageDialog(null, "Ruta incorrecta: " + url.getFile());
            }

        }
    }
}
