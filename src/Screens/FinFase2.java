/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Screens;

import Graficos.Boton;
import Graficos.Lienzo;
import Observador.ObservadorTransicionFase;
import Principal.Juego;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class FinFase2 implements IScreen{

    private static FinFase2 fase2;
    public static long lTime =0;
    public static int time = 120;
    private Image im;
    private Boton skip;

    private FinFase2() {
        im = Lienzo.cargarImagen("imagenes/FinFase2.jpg");
        Image img = null;
        try {
                img = Lienzo.cargarImagen("imagenes/skip.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        skip = new Boton(img, "skip", 900, 550, img.getWidth(null), img.getHeight(null));
        new ObservadorTransicionFase(skip);
    }

    public static FinFase2 getFinFase2() {
        if (fase2 == null) {
            fase2 = new FinFase2();
        }
        return fase2;
    }
    public void cargarModelos() {
        //aqui no se puede meter NADA
    }

    public void update() {
        skip.update();
    }

    public void draw(Graphics2D g) {
        
        g.drawImage(im, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
        
        skip.draw(g);
    }
}
