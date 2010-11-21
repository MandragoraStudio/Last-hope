/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;


import Graficos.IVentana;
import Personajes.Trap;
import Principal.MouseHandler;
import UtilMath.Vector2D;
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
                img = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/torres.png"));
                img2 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/editor.png"));
                img3 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/traps.png"));

                pestañas.add(new Pestaña(img, "torres", x, y, (WIDTH/3), img.getHeight(null)));
                pestañas.add(new Pestaña(img2, "editor", x+(WIDTH/3), y, (WIDTH/3), img.getHeight(null)));
                pestañas.add(new Pestaña(img3, "trap", x+((WIDTH/3)*2), y, (WIDTH/3), img.getHeight(null)));
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        

        try {
            //cargamos los contenidos de las pestañas
            Contenido c=new ContenidoTorres("imagenes/fondoTorres.png", this.x, this.y);
            Contenido c2=new ContenidoEditor("imagenes/fondoEditor.png", this.x, this.y);
            Contenido c3=new ContenidoTraps("imagenes/fondoTraps.png", this.x, this.y);
            //cargamos las imagenes de los botones
            Image img4 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/torrePanel.png"));
            Image img5 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/atributos.png"));
            Image img6 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro.png"));
            Image img7 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro2.png"));
            //cargamos los botones del contenido 1
            c.addBoton(img6, img7, "Menu", c.getImagen().getWidth(null)-img6.getWidth(null), c.getImagen().getHeight(null)-img6.getHeight(null));
            //cargamos los botones del contenido 2
            c2.addBotonPorDefecto(img5, "Atributo");
            c2.addBotonPorDefecto(img5, "Atributo");
            c2.addBotonPorDefecto(img5, "Atributo");
            c2.addBoton(img6, img7, "creaBotonCreador", c2.getImagen().getWidth(null)-img6.getWidth(null), c2.getImagen().getHeight(null)-img6.getHeight(null));
            //cargamos los botones del contenido 3
            c3.addBotonPorDefecto(new BotonCreadorTrap(img4, img4, "creaTrap", c3.calculaX(), c3.calculaY(), img4.getWidth(null), img4.getHeight(null), new Trap(0, 5, 2, 3, 0, 34, new Vector2D(MouseHandler.getX(), MouseHandler.getY()), img4)));
            //metemos los contenidos en la lista de fondos
            fondo.put("fondoTorres", c);
            fondo.put("fondoEditor", c2);
            fondo.put("fondoTraps", c3);
            //establecemos el fondo actual
            fondoActual=fondo.get("fondoTorres");
            } catch (Exception e) {
            }
        
    }

    public static void cambiaFondo(String nombre){
        Ventana_Panel.fondoActual=Ventana_Panel.fondo.get(nombre);
    }

    public static Map<String, Contenido> getFondo() {
        return fondo;
    }



}
