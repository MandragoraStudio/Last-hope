/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Screens;

import Graficos.Boton;
import Graficos.BotonGeneral;
import Graficos.Lienzo;
import Observador.ObservadorTransicionFase;
import Principal.Juego;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class FinFase1 implements IScreen{

    private static FinFase1 fase1;
    public static long lTime =0;
    public static int time = 120;
    private Image im;
    private Boton skip;

    private FinFase1() {
        im = Lienzo.cargarImagen("imagenes/FinFase1.png");
        Image img = Lienzo.cargarImagen("imagenes/skip.png");
        Image img2 = Lienzo.cargarImagen("imagenes/skip-pulsado.png");

        try {
            skip = new BotonGeneral(img, img2, "skip", 900, 550, img.getWidth(null), img.getHeight(null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        skip = new Boton(img, "skip", 900, 550, img.getWidth(null), img.getHeight(null));
        new ObservadorTransicionFase(skip);
    }

    public static FinFase1 getFinFase1() {
        if (fase1 == null) {
            fase1 = new FinFase1();
        }
        return fase1;
    }
    public void cargarModelos() {
        //aqui no se puede meter NADA
    }

    public void update() {
        skip.update();
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.drawImage(im, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
        skip.draw(g);
    }
}
