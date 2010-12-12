/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Screens;

import Graficos.Boton;
import Graficos.BotonGeneral;
import Graficos.Fondo;
import Graficos.Lienzo;
import Observador.ObservadorGameOver;
import Personajes.Actor;
import UtilMath.Vector2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arcangel
 */
public class GameOverScreen implements IScreen{
    Actor fondo; // el fondo del menu

    List<Boton> botones;
    public void cargarModelos() {
        botones= new ArrayList<Boton>();
        try {
            fondo = new Fondo("imagenes/gameOver.jpg",Vector2D.zero);
            cargarBotones();
        } catch (Exception ex) {
            Logger.getLogger(GameOverScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarBotones() throws Exception{
        //cargamos las imagenes de los botones
        Image img = null;
        Image img2 = null;
        try {
                img = Lienzo.cargarImagen("imagenes/playAgain.png");
                img2 = Lienzo.cargarImagen("imagenes/playAgainHover.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        //añadimos los botones al menu
        Boton b =new BotonGeneral(img, img2, "Menu", 800, 450, img.getWidth(null), img.getHeight(null));
        new ObservadorGameOver(b);
        botones.add(b);
    }

    public void update() {
        for(Boton b:botones){
            b.update();
        }
    }

    public void draw(Graphics2D g) {
        fondo.draw(g);
        for(Boton b:botones){
            b.draw(g);
        }
    }

}
