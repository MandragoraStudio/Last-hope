/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.Boton;
import Graficos.Lienzo;
import Personajes.Tower;
import Principal.Juego;
import Principal.Jugador;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jose
 */
public class ContenidoEditor extends Contenido {

    Image img1;
    Image img2;
    static Image img3;
    private Image fondoAtributos;
    private static String imagenTorre;
    private static Map<String, String> atributos;

    public ContenidoEditor(String url, Vector2D posicion) {
        super(url, posicion);
        try {

            this.cargar();
        } catch (Exception ex) {
            Logger.getLogger(ContenidoEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargar() throws Exception {
        fondoAtributos = Lienzo.cargarImagen("imagenes/atributos.png");
        atributos = new LinkedHashMap();

        img1 = Lienzo.cargarImagen("imagenes/torrePanel.png");
        img2 = Lienzo.cargarImagen("imagenes/torrePanel2.png");
        img3 = Lienzo.cargarImagen("imagenes/torrePanel3.png");
        Image img4 = Lienzo.cargarImagen("imagenes/imagenpro.png");
        Image img5 = Lienzo.cargarImagen("imagenes/imagenpro2.png");
        Image img6 = Lienzo.cargarImagen("imagenes/insertador.png");
        imagenTorre = "imagenes/torrePanel.png";

        addBotonPorDefecto(fondoAtributos, "Nombre");
        addBotonPorDefecto(fondoAtributos, "Daño");
        addBotonPorDefecto(fondoAtributos, "Rango");
        addBotonPorDefecto(fondoAtributos, "Área de daño");
        addBotonPorDefecto(fondoAtributos, "Congelación");
        addBotonPorDefecto(fondoAtributos, "Fuego");
        addBotonPorDefecto(fondoAtributos, "Veneno");
        addBotonPorDefecto(fondoAtributos, "Recarga");
        addBotonPorDefecto(fondoAtributos, "Penetración");

        addBoton(img1, img1, "cambiaImagen", 20, 320);
        addBoton(img2, img2, "cambiaImagen2", 120, 320);
        addBoton(img3, img3, "cambiaImagen3", 220, 320);
        addBoton(img6, img6, "cambiaImagenPorTeclado", 20, 390);


        addBoton(img4, img5, "creaBotonCreador", getImagen().getWidth(null) - img4.getWidth(null), getImagen().getHeight(null) - img4.getHeight(null));

        atributos.put("Nombre", "-Nombre aqui-");
        atributos.put("Daño", "0");
        atributos.put("Rango", "0");
        atributos.put("Área de daño", "0");
        atributos.put("Congelación", "0");
        atributos.put("Fuego", "0");
        atributos.put("Veneno", "0");
        atributos.put("Recarga", "0");
        atributos.put("Penetración", "0");
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.getImagen(), (int) posicion.x, (int) posicion.y, null);

        for (Boton b : this.getBotonesPorDefecto()) {
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY() + 12);
        }
        for (Boton b : getBotones()) {
            b.draw(g);
        }
        int x = 900, y = 60;
        for (String element : atributos.values()) {
            g.drawString(element, x, y);
            y += 30;
        }
    }

    @Override
    public int calculaX() {
        int pos = (int) posicion.x + 10;
        return pos;

    }

    @Override
    public int calculaY() {
        int pos = (int) posicion.y + (this.getBotonesPorDefecto().size() * 31) + 45;
        return pos;
    }

    public static void creaBotonCreador() {
        try {
            Image im = Lienzo.cargarImagen(imagenTorre);
            Ventana_Panel.getFondo().get("fondoTorres").addBotonPorDefecto(new BotonCreadorTorre(im, im, ContenidoEditor.getAtributos().get("Nombre"), Ventana_Panel.getFondo().get("fondoTorres").calculaX(), Ventana_Panel.getFondo().get("fondoTorres").calculaY(), im.getWidth(null), im.getHeight(null),
                    new Tower(Float.parseFloat(ContenidoEditor.getAtributos().get("Daño")),
                    Integer.parseInt(ContenidoEditor.getAtributos().get("Rango")), Float.parseFloat(ContenidoEditor.getAtributos().get("Área de daño")),
                    Float.parseFloat(ContenidoEditor.getAtributos().get("Congelación")), Long.parseLong(ContenidoEditor.getAtributos().get("Recarga")),
                    Float.parseFloat(ContenidoEditor.getAtributos().get("Veneno")), calculaCosteProduccion(), im)));
        } catch (Exception ex) {
            Logger.getLogger(ContenidoEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Map<String, Integer> calculaCosteProduccion() {
        Map<String, Integer> costeProduccion = new HashMap<String, Integer>();


        int c;
        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Fuego")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 2;
        costeProduccion.put("uranio", c);
        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Área de daño")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 2;
        costeProduccion.put("rodio", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Recarga")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 2;
        costeProduccion.put("grafeno", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Congelación")) * 2;
        costeProduccion.put("radio", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Veneno")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Penetración")) * 2;
        costeProduccion.put("cromo", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 2 + Integer.parseInt(ContenidoEditor.atributos.get("Fuego")) * 2;
        costeProduccion.put("energia", c);


        return costeProduccion;


    }

    public static void inicializaAtributo(String atributo, String nivel) {
        ContenidoEditor.atributos.put(atributo, nivel);


    }

    public static Map<String, String> getAtributos() {
        return atributos;


    }

    public static void cambiaImagen(String cad) {
        imagenTorre = cad;

    }
}
