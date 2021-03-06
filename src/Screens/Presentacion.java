/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Graficos.Boton;
import Graficos.Lienzo;
import Observador.ObservadorCredits;
import Principal.Globals;
import Principal.Juego;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public class Presentacion implements IScreen {

    private static Presentacion presentacion;
    public static long lTime =0;
    public static int time = 120;
    private Image im;
    private Image oscuridad;
    private Image lasthope;
    private Boton skip;

    private Presentacion() {
        im = Lienzo.cargarImagen("imagenes/tower2.jpg");
        oscuridad = Lienzo.cargarImagen("imagenes/Opacidad.png");
        lasthope = Lienzo.cargarImagen("imagenes/Last Hope.png");
        Image img = null;
        try {
                img = Lienzo.cargarImagen("imagenes/skip.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        skip = new Boton(img, "Menu", 900, 550, img.getWidth(null), img.getHeight(null));
        new ObservadorCredits(skip);
    }

    public static Presentacion getPresentacion() {
        if (presentacion == null) {
            presentacion = new Presentacion();
        }
        return presentacion;
    }
    public void cargarModelos() {
        //aqui no se puede meter NADA
    }

    public void update() {
        lTime += Globals.elapsedTime;
        time=(int)( 120-((lTime/1000.0f)*30));
        if (time < 0) {
            Juego.getJuego().changeScreen("Menu");
        }
        skip.update();
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.drawImage(im, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
        if (time < 90) {
            for (int i = Math.max(60, time); i < 90; i++) {
                g.drawImage(lasthope, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
            }
        }
        if (time < 15) {
            for (int i = time; i < 15; i++) {
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
            }
        } else if (time > 90) {
            for (int i = 90; i < time; i++) {
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
            }
        }
        skip.draw(g);
    }
}
