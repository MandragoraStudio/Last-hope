/*
 * al fin tengo una clase Vector2D... aunque me la tenga que implementar yo solo
 */

package UtilMath;

/**
 *
 * @author Thanar
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

    // devuelve un vector de igual direccion pero modulo 1
    public Vector2D unitario(){
        Vector2D dev;
        double mod = this.modulo();
        dev= new Vector2D((float)(x/mod),(float)(y/mod));
        return dev;
    }

    public Vector2D add(Vector2D v){
        return new Vector2D(x+v.x,y+v.y);
    }
    public Vector2D subs(Vector2D v){
        return new Vector2D(x-v.x,y-v.y);
    }
    //multiplicar por escalar
    public Vector2D mult(float n){
        return new Vector2D(x*n,y*n);
    }
    public Vector2D mult(int n){
        return new Vector2D(x*n,y*n);
    }

}
