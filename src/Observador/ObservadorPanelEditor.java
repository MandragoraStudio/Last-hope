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
import java.awt.Image;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class ObservadorPanelEditor implements IObservador {

    private Boton boton; //boton al que observa
    private int cont = 0;

    public ObservadorPanelEditor(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        if (boton.getNombre().equals("creaBotonCreador")) {
            ContenidoEditor.getContenidoEditor().creaBotonCreador();
        } else if (boton.getNombre().equals("Nombre")) {
            String nombre = JOptionPane.showInputDialog(null, "Introduzca el Nombre de la torre:", "Nombre", JOptionPane.INFORMATION_MESSAGE);
            if (nombre != null) {
                ContenidoEditor.getContenidoEditor().inicializaAtributo("Nombre", nombre);
            } else {
                JOptionPane.showMessageDialog(null, "Debe Introducir un nombre");
            }
        } else if (boton.getNombre().equals("Daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de daño:", "Daño", JOptionPane.INFORMATION_MESSAGE);
            try {

                if (Float.parseFloat(nivel) >= 0 && Float.parseFloat(nivel) <= 99) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Daño", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 99\nRecomendado: 10-20");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 99 \nRecomendado: 10-20");
            }

        } else if (boton.getNombre().equals("Rango")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Rango:", "Rango", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (Float.parseFloat(nivel) >= 0 && Float.parseFloat(nivel) <= 999) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Rango", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
            }
        } else if (boton.getNombre().equals("Área de daño")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Área de daño:", "Área de daño", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (Float.parseFloat(nivel) >= 0 && Float.parseFloat(nivel) <= 999) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Área de daño", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
            }
        } else if (boton.getNombre().equals("Congelación")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Congelación:", "Congelación", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (Float.parseFloat(nivel) >= 0 && Float.parseFloat(nivel) <= 999) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Congelación", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
            }
        } else if (boton.getNombre().equals("Fuego")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Fuego:", "Fuego", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (Float.parseFloat(nivel) >= 0 && Float.parseFloat(nivel) <= 999) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Fuego", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
            }
        } else if (boton.getNombre().equals("Ácido")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Ácido:", "Ácido", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (Float.parseFloat(nivel) >= 0 && Float.parseFloat(nivel) <= 999) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Ácido", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 999\nRecomendado: 100-200");
            }
        } else if (boton.getNombre().equals("Recarga")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Recarga:", "Recarga", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (Float.parseFloat(nivel) > 0 && Float.parseFloat(nivel) <= 99) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Recarga", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 1 y 99\nRecomendado: 10-20");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 1 y 99\nRecomendado: 10-20");
            }
        } else if (boton.getNombre().equals("Penetración")) {
            String nivel = JOptionPane.showInputDialog(null, "Introduzca el nivel de Penetración:", "Penetración", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (Float.parseFloat(nivel) >= 0 && Float.parseFloat(nivel) <= 99) {
                    ContenidoEditor.getContenidoEditor().inicializaAtributo("Penetración", nivel);
                }else{
                    JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 99\nRecomendado: 0-10");
                }
            } catch (Exception nfe) {
                JOptionPane.showMessageDialog(null, "Debe Introducir un numero entre 0 y 99");
            }
        } else if (boton.getNombre().equals("cambiaImagen")) {
            ContenidoEditor.getContenidoEditor().cambiaImagen("imagenes/Misiles.png");
        } else if (boton.getNombre().equals("cambiaImagen2")) {
            ContenidoEditor.getContenidoEditor().cambiaImagen("imagenes/torrePanel2.png");
        } else if (boton.getNombre().equals("cambiaImagen3")) {
            ContenidoEditor.getContenidoEditor().cambiaImagen("imagenes/Gatling.png");
        } else if (boton.getNombre().equals("cambiaImagenPorTeclado")) {
            cont++;
            if (cont <= 1) {
                URL url = null;
                url = Buscador.getBuscador().busca();
                if (url != null) {
                    Image i = null;
                    i = Lienzo.cargarImagen(url);
                    i = i.getScaledInstance(Ventana_Mapa.getCasillaWidth(), Ventana_Mapa.getCasillaHeight(), Image.SCALE_DEFAULT);
                    Lienzo.imagenes.remove(url.getPath());
                    if (i != null) {
                        ContenidoEditor.getContenidoEditor().cambiaImagen(i);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ruta incorrecta");
                    }
                }
            }
        }
        if (cont > 1) {
            URL url = null;
            url = Buscador.getBuscador().busca();
            if (url != null) {
                Image i = null;
                i = Lienzo.cargarImagen(url);
                i = i.getScaledInstance(Ventana_Mapa.getCasillaWidth(), Ventana_Mapa.getCasillaHeight(), Image.SCALE_DEFAULT);
                Lienzo.imagenes.remove(url.getPath());
                if (i != null) {
                    ContenidoEditor.getContenidoEditor().cambiaImagen(i);
                } else {
                    JOptionPane.showMessageDialog(null, "Ruta incorrecta");
                }
            }
        }
    }
}


