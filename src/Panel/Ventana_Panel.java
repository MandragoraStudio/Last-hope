/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;


import Graficos.IVentana;
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
    private int x;
    private int y;
    private static Map <String, Contenido>fondo;
    private static Contenido fondoActual;
    private List<Pestaña> pestañas;

    public Ventana_Panel(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x=x;
        this.y=y;
        this.pestañas=new ArrayList();
        fondo=new HashMap<String,Contenido>();
        fondoActual= new Contenido("imagenes/fondoTorres.png");
    }

    public void draw(Graphics2D g) {
        for(Pestaña p: pestañas){
            p.draw(g);
        }
        fondoActual.setX(x);
        fondoActual.setY(y+35);
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

                pestañas.add(new Pestaña(img, img, "torres", x, y, (WIDTH/3), img.getHeight(null)));
                pestañas.add(new Pestaña(img2, img2, "editor", x+(WIDTH/3), y, (WIDTH/3), img.getHeight(null)));
                pestañas.add(new Pestaña(img3, img3, "trap", x+((WIDTH/3)*2), y, (WIDTH/3), img.getHeight(null)));
            } catch (Exception e) {
            }
        

        try {
            fondo.put("fondoTorres", new Contenido("imagenes/fondoTorres.png"));
            fondo.put("fondoEditor", new Contenido("imagenes/fondoEditor.png"));
            fondo.put("fondoTraps", new Contenido("imagenes/fondoTraps.png"));
            } catch (Exception e) {
            }
        
    }

    public static void cambiaFondo(String nombre){
        Ventana_Panel.fondoActual=Ventana_Panel.fondo.get(nombre);
    }

}