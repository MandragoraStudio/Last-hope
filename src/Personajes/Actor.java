/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public abstract class Actor {
    protected Image imagen;
    public Vector2D posicion = new Vector2D(0,0);

    public Actor(Image im,Vector2D posicion){
        imagen=im;
        this.posicion=posicion;
    }

    public Vector2D getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2D posicion) {
        this.posicion = posicion;
    }


    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }



    public void draw(Graphics2D g) {
        try {
            g.drawImage(imagen, (int) posicion.x, (int) posicion.y, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void update();
}
