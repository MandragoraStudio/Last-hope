/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.Boton;
import java.awt.Graphics2D;

/**
 *
 * @author Jose
 */
public class ContenidoEditor extends Contenido {

    public ContenidoEditor(String url, int x, int y) {
        super(url, x, y);
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.getImagen(), this.getX(), this.getY(), null);

        for (Boton b : this.getBotonesPorDefecto()) {
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY() + 12);
        }
    }

    @Override
    public int calculaX() {
        int pos = this.getX() + 10;
        return pos;
    }

    @Override
    public int calculaY() {
        int pos = this.getY() + (this.getBotonesPorDefecto().size() * 31) + 45;
        return pos;
    }
}
