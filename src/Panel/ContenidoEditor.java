/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.Boton;
import Personajes.Tower;
import Principal.MouseHandler;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jose
 */
public class ContenidoEditor extends Contenido {

    private static Image img4;

    public ContenidoEditor(String url, Vector2D posicion) {
        super(url, posicion);
        try {
            img4 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/torrePanel.png"));
        } catch (IOException ex) {
            Logger.getLogger(ContenidoEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.getImagen(), (int)posicion.x, (int)posicion.y, null);

        for (Boton b : this.getBotonesPorDefecto()) {
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY() + 12);
        }
        for(Boton b: this.getBotones()){
            b.draw(g);
        }
    }

    @Override
    public int calculaX() {
        int pos = (int)posicion.x + 10;
        return pos;
    }

    @Override
    public int calculaY() {
        int pos = (int)posicion.y + (this.getBotonesPorDefecto().size() * 31) + 45;
        return pos;
    }

    public static void creaBotonCreador() {
        try {
            Tower t = new Tower(0, 5, 2, 500, 6, 1000, 0, 34, new Vector2D(MouseHandler.getX(), MouseHandler.getY()), img4);
            Ventana_Panel.getFondo().get("fondoTorres").addBotonPorDefecto(new BotonCreadorTorre(img4, img4, "creaTorre", Ventana_Panel.getFondo().get("fondoTorres").calculaX(), Ventana_Panel.getFondo().get("fondoTorres").calculaY(), img4.getWidth(null), img4.getHeight(null), t));
        } catch (Exception ex) {
            Logger.getLogger(ContenidoEditor.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
