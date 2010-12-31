/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Screens;

import Graficos.Boton;
import Graficos.BotonGeneral;
import Graficos.Fondo;
import Graficos.Lienzo;
import Observador.ObservadorMenu;
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
 * @author Thanar
 */
public class MainMenuScreen implements IScreen {
private static MainMenuScreen menu=null; // instancia privada del menu (singleton)
private Actor fondo; // el fondo del menu
private List<Boton> botones; // botones del menu

    private MainMenuScreen() {
    }

    public static MainMenuScreen getMenu(){
        if(menu==null){
            menu=new MainMenuScreen();
        }
        return menu;
    }

    public void cargarModelos() {
        try {
            fondo = new Fondo("imagenes/imenu.jpg",Vector2D.zero);
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
        Image img3 = null;
        Image img4 = null;
        Image img5 = null;
        Image img6 = null;
        Image img7 = null;
        Image img8 = null;
        try {
                img = Lienzo.cargarImagen("imagenes/iplay.png");
                img2 = Lienzo.cargarImagen("imagenes/iplay-pulsado.png");
                img3 = Lienzo.cargarImagen("imagenes/iexit.png");
                img4 = Lienzo.cargarImagen("imagenes/iexit-pulsado.png");
                img5 = Lienzo.cargarImagen("imagenes/icredits.png");
                img6 = Lienzo.cargarImagen("imagenes/icredits-pulsado.png");
                img7 = Lienzo.cargarImagen("imagenes/tutorial.png");
                img8 = Lienzo.cargarImagen("imagenes/tutorial-pulsado.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        //añadimos los botones al menu
        Boton b=new BotonGeneral(img, img2, "start", 70, 32, img.getWidth(null), img.getHeight(null));
        new ObservadorMenu(b);
        Boton b3=new BotonGeneral(img3, img4, "exit", 65, 404, img3.getWidth(null), img3.getHeight(null));
        new ObservadorMenu(b3);
        Boton a1 = new BotonGeneral(img5, img6, "Credits", 67, 218, img5.getWidth(null), img5.getHeight(null));
        new ObservadorMenu(a1);
        Boton a2 = new BotonGeneral(img7, img8, "Tutorial", 890, 515, img7.getWidth(null), img7.getHeight(null));
        new ObservadorMenu(a2);
        botones.add(a1);
        botones.add(b);
        botones.add(b3);
        botones.add(a2);
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
