/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;


import Graficos.Boton;
import Graficos.Lienzo;
import Handlers.MouseHandler;
import Personajes.Trap;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class ContenidoTraps extends Contenido {
    Image img4;

    public ContenidoTraps(String url, Vector2D posicion) {
        super(url, posicion);
        try {
            img4 = Lienzo.cargarImagen("imagenes/torrePanel.png");
            //cargamos los botones del contenido 3
            addBotonPorDefecto(new BotonCreadorTrap(img4, img4, "creaTrap", calculaX(), calculaY(), img4.getWidth(null), img4.getHeight(null), new Trap(0, 5, 2, 3, 0, 34, new Vector2D(MouseHandler.getX(), MouseHandler.getY()), img4)));
        } catch (Exception ex) {
            Logger.getLogger(ContenidoTraps.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void addBotonPorDefecto(Boton b) throws Exception{
        if(this.getBotonesPorDefecto().size()<12){

            this.getBotonesPorDefecto().add(b);
        }
    }
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.getImagen(), (int)posicion.x, (int)posicion.y, null);

        for (Boton b : this.getBotonesPorDefecto()) {
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY() + b.getHeight() + 12);
        }
    }

    @Override
    public int calculaX() {
        int pos = 0;
        int modulo = this.getBotonesPorDefecto().size() % 3;
        if (this.getBotonesPorDefecto().size() == 0) {
            pos = (int)posicion.x + 31;
        } else {
            pos =(int)posicion.x + (modulo * 81) + 31;
        }
        return pos;
    }

    @Override
    public int calculaY() {
        int pos = 0;
        int cociente = this.getBotonesPorDefecto().size() / 3;
        if (this.getBotonesPorDefecto().size() == 0) {
            pos = (int)posicion.y + 66;
        } else {
            pos = (int)posicion.y + (cociente * 81) + 66;
        }
        return pos;
    }
}
