/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Graficos.Lienzo;
import Panel.BotonCreadorTorre;
import Panel.BotonCreadorTrap;
import Panel.ContenidoEditor;
import Panel.Ventana_Panel;
import Principal.Juego;
import java.awt.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanar
 */
public class Observador implements IObservador {

    private Boton boton;

    public Observador(Boton b) {
        boton = b;
        boton.Atach(this);
    }

    public void update(String comando) {
        if (comando.equals("start")) {
            Juego.changeScreen("Game");
        } else if (comando.equals("exit")) {
            System.exit(0);
        } else if (comando.equals("Menu")) {
            Juego.changeScreen("Menu");
        } else if (comando.equals("torres")) {
            Ventana_Panel.cambiaFondo("fondoTorres");
        } else if (comando.equals("editor")) {
            Ventana_Panel.cambiaFondo("fondoEditor");
        } else if (comando.equals("trap")) {
            Ventana_Panel.cambiaFondo("fondoTraps");
        } else if (comando.equals(ContenidoEditor.getAtributos().get("Nombre"))) {
            BotonCreadorTorre.creaTorre();
        } else if (comando.equals("creaTrap")) {
            BotonCreadorTrap.creaTrap();
        } else if (comando.equals("creaBotonCreador")) {
            ContenidoEditor.creaBotonCreador();
        } else if (comando.equals("Nombre")) {
            String nombre = JOptionPane.showInputDialog(null, "Introduzca el Nombre de la torre:", "Nombre", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Nombre", nombre);
        } else if (comando.equals("Daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de daño:", "Daño", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Daño", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }

        } else if (comando.equals("Rango")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Rango:", "Rango", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Rango", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (comando.equals("Área de daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Área de daño:", "Área de daño", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Área de daño", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (comando.equals("Congelación")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Congelación:", "Congelación", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Congelación", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (comando.equals("Fuego")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Fuego:", "Fuego", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Fuego", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (comando.equals("Veneno")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Veneno:", "Veneno", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Veneno", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (comando.equals("Recarga")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Recarga:", "Recarga", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Recarga", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (comando.equals("Penetración")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Penetración:", "Penetración", JOptionPane.INFORMATION_MESSAGE);
            try {
                Float.parseFloat(nivel);
                ContenidoEditor.inicializaAtributo("Penetración", nivel);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero");
            }
        } else if (comando.equals("cambiaImagen")) {
            ContenidoEditor.cambiaImagen("imagenes/torrePanel.png");
        } else if (comando.equals("cambiaImagen2")) {
            ContenidoEditor.cambiaImagen("imagenes/torrePanel2.png");
        } else if (comando.equals("cambiaImagen3")) {
            ContenidoEditor.cambiaImagen("imagenes/torrePanel3.png");
        } else if (comando.equals("cambiaImagenPorTeclado")) {
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
