/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public abstract class Actor {
    private Image imagen;
    private int x;
    private int y;
    private int z;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void draw(Graphics2D g){
        g.drawImage(imagen, x, y, null);
    }

    public abstract void update();
}
