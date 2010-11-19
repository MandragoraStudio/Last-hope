/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UtilMath;

/**
 *
 * @author Equipo
 */
public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public double modulo(){
        float dev=0;
        dev = x*x+y*y;
        return Math.sqrt(dev);
    }
    public Vector2D normalize(){
        Vector2D dev;
        double mod = this.modulo();
        dev= new Vector2D((float)(x/mod),(float)(y/mod));
        return dev;
    }

}
