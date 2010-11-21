/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graficos;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author usuario
 */
public class BotonGeneral extends Boton{
    Image down;

    public BotonGeneral(Image up, Image down, String nombre, int x, int y, int width, int height) throws Exception {
        super( up, nombre, x, y, width, height);
        this.down = down;
        if(up.getWidth(null)!=down.getWidth(null)||up.getHeight(null)!=down.getHeight(null))
            throw new Exception("Ambas imagenes deben tener el mismo tamaño");

    }

    @Override
    public void draw(Graphics2D g) {
        Image im = pulsado ? down : up;
        g.drawImage(im, this.getX(), this.getY(), null);
    }
}
