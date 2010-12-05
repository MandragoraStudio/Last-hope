/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Screens;

import Graficos.Boton;
import Graficos.BotonGeneral;
import Graficos.Fondo;
import Graficos.Lienzo;
import Personajes.Actor;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanar
 */
public class MainMenuScreen implements IScreen {
Actor fondo; // el fondo del menu
List<Boton> botones; // botones del menu

    public void cargarModelos() {
        try {
            fondo = new Fondo("imagenes/fondo.png",Vector2D.zero);
            botones = new ArrayList<Boton>();
            
            
            //Aqui se crean todos los botones
            cargarBotones();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(MainMenuScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cargarBotones() throws Exception{
        //cargamos las imagenes de los botones
        Image img = null;
        Image img2 = null;
        try {
                img = Lienzo.cargarImagen("imagenes/imagenpro.png");
                img2 = Lienzo.cargarImagen("imagenes/imagenpro2.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        //añadimos los botones al menu
        botones.add(new BotonGeneral(img, img2, "start", 100, 100, img.getWidth(null), img.getHeight(null)));
        botones.add(new BotonGeneral(img, img2, "exit", 800, 450, img.getWidth(null), img.getHeight(null)));
    }
    public void update() {
        //actualizamos todos los botones
        for(Boton b:botones){
            b.update();
        }
        
    }

    public void draw(Graphics2D g) {
        //dibujamos el fondo
        fondo.draw(g);
        //dibujamos todos los botones
        for(Boton b:botones){
            b.draw(g);
        }
    }

}
