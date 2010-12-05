/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Graficos.Abotonador;
import Graficos.Lienzo;
import Principal.Globals;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Thanar
 */
public abstract class Actor {

    private Image imagen;
    public Vector2D posicion = new Vector2D(0, 0);
    Abotonador boton;
    float interval=300;
    float elapsedTime;
    int currentFrame=0;
    int numFrames;
    int width;
    int height;
    float rotation = 0;
    AffineTransform at;

    public Actor(Image im, Vector2D posicion, int width) {
        at = new AffineTransform();

        elapsedTime = 0;
        if (posicion == null) {
            posicion = Vector2D.zero;
        }
        if (im != null) {
            imagen = im;
        } else {
            imagen = Lienzo.cargarImagen("imagenes/torrePanel.png");
        }
        height = imagen.getHeight(null);
        this.width = width;
        numFrames = imagen.getWidth(null) / width;
        this.posicion = posicion;
        try {
            boton = new Abotonador("Actor", imagen.getHeight(null), imagen.getWidth(null), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Actor(Image im, Vector2D posicion) {
        at = new AffineTransform();

        elapsedTime = 0;
        if (posicion == null) {
            posicion = Vector2D.zero;
        }
        if (im != null) {
            imagen = im;
        } else {
            imagen = Lienzo.cargarImagen("imagenes/torrePanel.png");
        }
        height = imagen.getHeight(null);
        this.width = imagen.getWidth(null);
        numFrames = imagen.getWidth(null) / width;
        this.posicion = posicion;
        try {
            boton = new Abotonador("Actor", imagen.getHeight(null), imagen.getWidth(null), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        height = imagen.getHeight(null);
        width=imagen.getWidth(null);
        boton.setHeight(height);
        boton.setWidth(width);
    }

    public void draw(Graphics2D g) {
        try {
            if (rotation != 0) {
                try {
                    AffineTransform temp = g.getTransform();
                    at = new AffineTransform();
                    at.rotate(-rotation, posicion.x + width / 2, posicion.y + height / 2);

                    g.setTransform(at);
                    g.drawImage(imagen, (int) posicion.x, (int) posicion.y, (int) posicion.x + width, (int) posicion.y + height, currentFrame * width, 0, currentFrame * width + width, height, null);

                    //g.drawImage(imagen,(int)posicion.x,(int)posicion.y,null);
                    g.setTransform(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                g.drawImage(imagen, (int) posicion.x, (int) posicion.y, (int) posicion.x + width, (int) posicion.y + height, currentFrame * width, 0, currentFrame * width + width, height, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        elapsedTime += Globals.elapsedTime;
        if (elapsedTime > interval) {
            this.currentFrame++;
            elapsedTime=0;
        }
        if (currentFrame >= numFrames) {
            currentFrame = 0;
        }

    }
}
