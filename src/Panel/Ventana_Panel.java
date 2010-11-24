/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;


import Graficos.IVentana;
import Graficos.Lienzo;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Thanar
 */
public class Ventana_Panel implements IVentana {
    private int WIDTH;
    private int HEIGHT;
    private int x;
    private int y;
    private static Map <String, Contenido> contenidos;
    private static Contenido fondoActual;
    private List<Pestaña> pestañas;

    public Ventana_Panel(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x=x;
        this.y=y;
        this.pestañas=new ArrayList();
        contenidos=new HashMap<String,Contenido>();
        this.cargar();
    }

    public void draw(Graphics2D g) {
        fondoActual.draw(g);

        for(Pestaña p: pestañas){
            p.draw(g);
        }
    }

    public void update() {
        fondoActual.update();
        
        for(Pestaña p: pestañas){
            p.update();
        }
    }

    public void cargar(){
        Image img = null;
        Image img2 = null;
        Image img3 = null;

        try {
                img = Lienzo.cargarImagen("imagenes/torres.png");
                img2 = Lienzo.cargarImagen("imagenes/editor.png");
                img3 = Lienzo.cargarImagen("imagenes/traps.png");

                pestañas.add(new Pestaña(img, "torres", x, y, (WIDTH/3), img.getHeight(null)));
                pestañas.add(new Pestaña(img2, "editor", x+(WIDTH/3), y, (WIDTH/3), img.getHeight(null)));
                pestañas.add(new Pestaña(img3, "trap", x+((WIDTH/3)*2), y, (WIDTH/3), img.getHeight(null)));
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        

        try {
            //cargamos los contenidos de las pestañas
            Contenido c=new ContenidoTorres("imagenes/fondoTorres.png", new Vector2D(this.x, this.y));
            Contenido c2=new ContenidoEditor("imagenes/fondoEditor.png", new Vector2D(this.x, this.y));
            Contenido c3=new ContenidoTraps("imagenes/fondoTraps.png", new Vector2D(this.x, this.y));
            //metemos los contenidos en la lista de fondos
            contenidos.put("fondoTorres", c);
            contenidos.put("fondoEditor", c2);
            contenidos.put("fondoTraps", c3);
            //establecemos el fondo actual
            fondoActual=contenidos.get("fondoTorres");
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        
    }

    public static void cambiaFondo(String nombre){
        Ventana_Panel.fondoActual=Ventana_Panel.contenidos.get(nombre);
    }

    public static Map<String, Contenido> getFondo() {
        return contenidos;
    }



}
