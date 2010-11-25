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
    public static final Vector2D zero = new Vector2D(0, 0);
    public static final Vector2D uno = new Vector2D(1, 1);
    public static final Vector2D fuera= new Vector2D(-1000,-1000);

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        boolean dev = false;
        if (o instanceof Vector2D) {
            Vector2D v = (Vector2D) o;
            dev = v.x == x && v.y == y;
        }
        return dev;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Float.floatToIntBits(this.x);
        hash = 47 * hash + Float.floatToIntBits(this.y);
        return hash;
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

    public double modulo() {
        float dev = 0;
        dev = x * x + y * y;
        return Math.sqrt(dev);
    }

    // devuelve un vector de igual direccion pero modulo 1
    public Vector2D unitario() {
        Vector2D dev;
        double mod = this.modulo();
        dev = new Vector2D((float) (x / mod), (float) (y / mod));
        return dev;
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(x + v.x, y + v.y);
    }

    public Vector2D subs(Vector2D v) {
        return new Vector2D(x - v.x, y - v.y);
    }
    //multiplicar por escalar

    public Vector2D mult(float n) {
        return new Vector2D(x * n, y * n);
    }

    public Vector2D mult(int n) {
        return new Vector2D(x * n, y * n);
    }

    public float getAngle() {
        float dev = 0;
        dev = (float) Math.atan2(x, y);
        /*if (x < 0) {
            dev = -dev;
        }*/
        return dev;
    }

    public float getAngle(Vector2D v){
        return Math.abs(getAngle()-v.getAngle());
    }
}
