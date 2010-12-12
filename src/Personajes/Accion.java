/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import UtilMath.Vector2D;
import java.awt.Image;
import java.util.Map;

/**
 *
 * @author jose
 */
public class Accion extends Habilidad{

    public Accion(Image im, Vector2D posicion) {
        super(im, posicion);
    }

    public Habilidad clone() {
        Accion dev;
        Vector2D posicion = new Vector2D(this.posicion.x, this.posicion.y);
        Image ima = this.getImagen();
        dev = new Accion(ima,posicion);
        dev.setNombre(this.getNombre());
        return dev;
    }
}
