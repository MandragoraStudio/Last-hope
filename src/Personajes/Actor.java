/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Graficos.Abotonador;
import Graficos.Lienzo;
import Mapa.Ventana_Mapa;
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
    float interval = 300;
    float elapsedTime;
    int currentFrame = 0;
    int numFrames;
    //ancho del fotograma en al textura
    int sWidth;
    int sHeight;
    //ancho del actor en pantalla
    public int width;
    int height;
    float rotation = 0;
    AffineTransform at;

    public Actor(Image im, Vector2D posicion, int width, Integer height) {
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
        sHeight = imagen.getHeight(null);
        this.sWidth = width;
        numFrames = imagen.getWidth(null) / width;
        this.width = (int) (Ventana_Mapa.casillaWidth * 0.9);
        if (height == null) {
            this.height = (int) (Ventana_Mapa.casillaHeight * 0.9);
        }else{
            this.height=height;
        }
        this.posicion = posicion;
        try {
            boton = new Abotonador("Actor", imagen.getHeight(null), imagen.getWidth(null), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Actor(Image im, Vector2D posicion, Integer height) {
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
        sHeight = imagen.getHeight(null);
        this.sWidth = imagen.getWidth(null);
        this.width = (int) (Ventana_Mapa.casillaWidth * 0.9);
        if (height == null) {
            this.height = (int) (Ventana_Mapa.casillaHeight * 0.9);
        }else{
            this.height = height;
        }
        numFrames = 1;
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
        sHeight = imagen.getHeight(null);
        sWidth = imagen.getWidth(null);
        boton.setHeight(height);
        boton.setWidth(width);
    }

    public void draw(Graphics2D g) {
        try {
            if (rotation != 0) {
                try {
                    AffineTransform temp = g.getTransform();
                    at = new AffineTransform();
                    at.rotate(-rotation, posicion.x + sWidth / 2, posicion.y + height / 2);

                    g.setTransform(at);
                    g.drawImage(imagen, (int) posicion.x, (int) posicion.y, (int) posicion.x + width, (int) posicion.y + height, currentFrame * sWidth, 0, currentFrame * sWidth + sWidth, sHeight, null);

                    //g.drawImage(imagen,(int)posicion.x,(int)posicion.y,null);
                    g.setTransform(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                g.drawImage(imagen, (int) posicion.x, (int) posicion.y, (int) posicion.x + width, (int) posicion.y + height, currentFrame * sWidth, 0, currentFrame * sWidth + sWidth, sHeight, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        elapsedTime += Globals.elapsedTime;
        if (elapsedTime > interval) {
            this.currentFrame++;
            elapsedTime = 0;
        }
        if (currentFrame >= numFrames) {
            currentFrame = 0;
        }

    }
}
