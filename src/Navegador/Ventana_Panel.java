/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Navegador;


import Gaficos.Fondo;
import Gaficos.IVentana;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;


/**
 *
 * @author Thanar
 */
public class Ventana_Panel implements IVentana {
    private int WIDTH;
    private int HEIGHT;
    private static Map <String, Fondo>fondo;
    private static Fondo fondoActual;
    private List<Pestaña> pestañas;

    public Ventana_Panel(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.pestañas=new ArrayList();
        fondo=new HashMap<String,Fondo>();
        fondoActual= new Fondo("imagenes/fondoTorres.png");
    }

    public void draw(Graphics2D g) {
        for(Pestaña p: pestañas){
            p.draw(g);
        }
        fondoActual.setX(750);
        fondoActual.setY(35);
        fondoActual.draw(g);
    }

    public void update() {
        for(Pestaña p: pestañas){
            p.update();
        }
    }

    public void cargar(){
        Image img = null;
        Image img2 = null;
        Image img3 = null;

        try {
                img = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/torres.png"));
                img2 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/editor.png"));
                img3 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/traps.png"));
            } catch (Exception e) {
            }
        pestañas.add(new Pestaña(img, "torres", 750, 0, img.getWidth(null), img.getHeight(null)));
        pestañas.add(new Pestaña(img2, "editor", 841, 0, img.getWidth(null), img.getHeight(null)));
        pestañas.add(new Pestaña(img3, "trap", 932, 0, img.getWidth(null), img.getHeight(null)));

        try {
            fondo.put("fondoTorres", new Fondo("imagenes/fondoTorres.png"));
            fondo.put("fondoEditor", new Fondo("imagenes/fondoEditor.png"));
            fondo.put("fondoTraps", new Fondo("imagenes/fondoTraps.png"));
            } catch (Exception e) {
            }
        
    }

    public static void cambiaFondo(String nombre){
        Ventana_Panel.fondoActual=Ventana_Panel.fondo.get(nombre);
    }

}
