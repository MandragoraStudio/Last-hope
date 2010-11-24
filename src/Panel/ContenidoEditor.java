/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.Boton;
import Personajes.Tower;
import Principal.Juego;
import Principal.Jugador;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jose
 */
public class ContenidoEditor extends Contenido {

    private Image fondo;
    private static Image img4;
    private static Map<String, String> atributos;
    private static Map<String, Integer> costeInvestigacion = new HashMap<String, Integer>();

    public ContenidoEditor(String url, Vector2D posicion) {
        super(url, posicion);
        try {
            fondo = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/atributos.png"));
            img4 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/torrePanel.png"));
            atributos = new HashMap();
            costeInvestigacion = new HashMap<String, Integer>();
            this.cargar();
        } catch (Exception ex) {
            Logger.getLogger(ContenidoEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargar() throws Exception {
        Image img6 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro.png"));
        Image img7 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro2.png"));

        addBotonPorDefecto(fondo, "Nombre");
        addBotonPorDefecto(fondo, "Daño");
        addBotonPorDefecto(fondo, "Rango");
        addBotonPorDefecto(fondo, "Área de daño");
        addBotonPorDefecto(fondo, "Congelación");
        addBotonPorDefecto(fondo, "Fuego");
        addBotonPorDefecto(fondo, "Veneno");
        addBotonPorDefecto(fondo, "Recarga");
        addBotonPorDefecto(fondo, "Penetración");
        addBoton(img6, img7, "creaBotonCreador", getImagen().getWidth(null) - img6.getWidth(null), getImagen().getHeight(null) - img6.getHeight(null));

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
        for (Boton b : this.getBotones()) {
            b.draw(g);
        }
        g.drawString(atributos.get("Nombre").toString(), 900, 60);
        g.drawString(atributos.get("Daño").toString(), 900, 96);
        g.drawString(atributos.get("Rango").toString(), 900, 126);
        g.drawString(atributos.get("Área de daño").toString(), 900, 156);
        g.drawString(atributos.get("Congelación").toString(), 900, 186);
        g.drawString(atributos.get("Fuego").toString(), 900, 216);
        g.drawString(atributos.get("Veneno").toString(), 900, 246);
        g.drawString(atributos.get("Recarga").toString(), 900, 276);
        g.drawString(atributos.get("Penetración").toString(), 900, 306);
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
        calculaCosteInvestigacion();
        try {
            if (Jugador.suficientesRecursos(costeInvestigacion)) {
                Juego.jugador.restaRecursos(costeInvestigacion);
                Ventana_Panel.getFondo().get("fondoTorres").addBotonPorDefecto(new BotonCreadorTorre(img4, img4, ContenidoEditor.getAtributos().get("Nombre"), Ventana_Panel.getFondo().get("fondoTorres").calculaX(), Ventana_Panel.getFondo().get("fondoTorres").calculaY(), img4.getWidth(null), img4.getHeight(null),
                        new Tower(Float.parseFloat(ContenidoEditor.getAtributos().get("Daño")),
                        Float.parseFloat(ContenidoEditor.getAtributos().get("Penetración")),
                        Integer.parseInt(ContenidoEditor.getAtributos().get("Rango")), Float.parseFloat(ContenidoEditor.getAtributos().get("Área de daño")),
                        Float.parseFloat(ContenidoEditor.getAtributos().get("Congelación")), Long.parseLong(ContenidoEditor.getAtributos().get("Recarga")),
                        
                        Float.parseFloat(ContenidoEditor.getAtributos().get("Veneno")), calculaCosteProduccion(),null, img4)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ContenidoEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void calculaCosteInvestigacion(){
    //TODO: aqui hay errores, hay valores que se parsean como enteros cuando en realidad serian float, y aun asi, hay que depurarlo, porque no deben saltar excepciones si el jugador mete , por ejemplo "hola" donde va el daño
        int c;
        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Fuego")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 10;
        costeInvestigacion.put("uranio", c);
        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Área de daño")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 10;
        costeInvestigacion.put("rodio", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Recarga")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 10;
        costeInvestigacion.put("grafeno", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Congelación")) * 10;
        costeInvestigacion.put("radio", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Rango")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Veneno")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Penetración")) * 10;
        costeInvestigacion.put("cromo", c);

        c = Integer.parseInt(ContenidoEditor.atributos.get("Daño")) * 10 + Integer.parseInt(ContenidoEditor.atributos.get("Fuego")) * 10;
        costeInvestigacion.put("energia", c);

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
}
