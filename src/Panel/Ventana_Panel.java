/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.IVentana;
import Graficos.Lienzo;
import Observador.Observador;
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

    private int WIDTH; // ancho de la ventana
    private int HEIGHT; // alto de la ventana
    private int x; //posicion  x de la ventana
    private int y; // posicion Y de la ventana
    private static Map<String, Contenido> contenidos; // contenidos de la ventana (subpartes)
    private static Contenido fondoActual; // contenido actual
    private List<Pestaña> pestañas; // lista de pestañas (botones)

    public Ventana_Panel(int WIDTH, int HEIGHT, int x, int y) {
        //inicializamos los atributos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x = x;
        this.y = y;
        this.pestañas = new ArrayList();
        contenidos = new HashMap<String, Contenido>();
        // cargamos la ventana
        this.cargar();
    }

    public void draw(Graphics2D g) {
        fondoActual.draw(g);

        for (Pestaña p : pestañas) {
            p.draw(g);
        }
    }

    public void update() {
        fondoActual.update();

        for (Pestaña p : pestañas) {
            p.update();
        }
    }

    public void cargar() {
        try {
            //cargamos las imagenes de las pestañas
            Image img = Lienzo.cargarImagen("imagenes/torres.png");
            Image img2 = Lienzo.cargarImagen("imagenes/editor.png");
            Image img3 = Lienzo.cargarImagen("imagenes/traps.png");
            //creamos y añadimos las pestañas a la lista
            Pestaña p = new Pestaña(img, "torres", x, y, (WIDTH / 3), img.getHeight(null));
            new Observador(p);
            Pestaña p2 = new Pestaña(img2, "editor", x + (WIDTH / 3), y, (WIDTH / 3), img.getHeight(null));
            new Observador(p2);
            Pestaña p3 = new Pestaña(img3, "trap", x + ((WIDTH / 3) * 2), y, (WIDTH / 3), img.getHeight(null));
            new Observador(p3);
            pestañas.add(p);
            pestañas.add(p2);
            pestañas.add(p3);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }


        try {
            //cargamos los contenidos de las pestañas
            Contenido c = new ContenidoTorres("imagenes/fondoTorres.png", new Vector2D(this.x, this.y));
            Contenido c2 = new ContenidoEditor("imagenes/fondoEditor.png", new Vector2D(this.x, this.y));
            Contenido c3 = new ContenidoHabilidades("imagenes/fondoTraps.png", new Vector2D(this.x, this.y));
            //metemos los contenidos en la lista de fondos
            contenidos.put("fondoTorres", c);
            contenidos.put("fondoEditor", c2);
            contenidos.put("fondoTraps", c3);
            //establecemos el fondo actual
            fondoActual = contenidos.get("fondoTorres");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static void cambiaFondo(String nombre) {
        Ventana_Panel.fondoActual = Ventana_Panel.contenidos.get(nombre);
    }

    public static Map<String, Contenido> getFondo() {
        return contenidos;
    }
}
