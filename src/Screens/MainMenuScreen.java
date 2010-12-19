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
            fondo = new Fondo("imagenes/Inicio.jpg",Vector2D.zero);
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

        try {
                img = Lienzo.cargarImagen("imagenes/start.png");
                img2 = Lienzo.cargarImagen("imagenes/startHover.png");
                img3 = Lienzo.cargarImagen("imagenes/exit.png");
                img4 = Lienzo.cargarImagen("imagenes/exitHover.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        //añadimos los botones al menu
        Boton b=new BotonGeneral(img, img2, "start", 100, 100, 100, 500);
        new ObservadorMenu(b);
        Boton b3=new BotonGeneral(img3, img4, "exit", 800, 450, img3.getWidth(null), img3.getHeight(null));
        new ObservadorMenu(b3);
        Boton a1 = new BotonGeneral(img, img2, "Credits", 200, 200, 100, 500);
        new ObservadorMenu(a1);
        botones.add(a1);
        botones.add(b);
        botones.add(b3);
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
