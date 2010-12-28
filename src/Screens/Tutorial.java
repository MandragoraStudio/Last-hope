/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Graficos.Boton;
import Graficos.BotonGeneral;
import Graficos.Lienzo;
import Observador.ObservadorTutorial;
import Principal.Juego;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class Tutorial implements IScreen {

    private static Tutorial tutorial1;
    public static long lTime = 0;
    public static int time = 120;
    public static Map<Integer, Image> imagenes = new LinkedHashMap<Integer, Image>();
    private static int imagenActual;
    private Boton skip;

    private Tutorial() {
        imagenes.put(1, Lienzo.cargarImagen("imagenes/Tuto1.jpg"));
        imagenes.put(2, Lienzo.cargarImagen("imagenes/Tuto2.jpg"));
        imagenes.put(3, Lienzo.cargarImagen("imagenes/Tuto3.jpg"));
        imagenes.put(4, Lienzo.cargarImagen("imagenes/Tuto4.jpg"));
        imagenes.put(5, Lienzo.cargarImagen("imagenes/Tuto5.jpg"));
        imagenes.put(6, Lienzo.cargarImagen("imagenes/Tuto6.jpg"));
        imagenActual = 1;
        Image img = Lienzo.cargarImagen("imagenes/skip.png");
        Image img2 = Lienzo.cargarImagen("imagenes/skip-pulsado.png");
        try {
            skip = new BotonGeneral(img, img2, "skip", 900, 350, img.getWidth(null), img.getHeight(null));
        } catch (Exception ex) {
            Logger.getLogger(Tutorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        new ObservadorTutorial(skip);
    }

    public static Tutorial getTutorial() {
        if (tutorial1 == null) {
            tutorial1 = new Tutorial();
        }
        return tutorial1;
    }

    public void cargarModelos() {
        //aqui no se puede meter NADA
    }

    public void update() {
        skip.update();
    }

    public void draw(Graphics2D g) {

        g.drawImage(imagenes.get(imagenActual), 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);

        skip.draw(g);
    }

    public static void changeImagen() {
        int aux = 0;
        if (imagenActual < 6) {
            imagenActual++;
        }else{
            imagenActual=1;
            Juego.getJuego().changeScreen("Menu");
        }
    }
}
