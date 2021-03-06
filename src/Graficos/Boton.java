/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Observador.IObservador;
import Handlers.MouseHandler;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public class Boton {

    IObservador observador; // observador que va a tener el boton
    Image up; // imagen del boton
    String nombre; // nombre o identificador del boton
    int x, y, height, width; // posicion (x,y) y dimensiones (height, width)
    boolean pulsado; // variable que controla si el boton esta pulsado o no
    boolean encima;

    public Boton(Image up, String nombre, int x, int y, int width, int height) {
        //inicializacion de los atributos
        this.up = up;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    //metodo para dibujar el boton en pantalla
    public void draw(Graphics2D g) {
        g.drawImage(up, x, y, width, height, null);
    }
    //update de boton para controlar la logica de boton

    public void update() {
        //miramos si se ha clicado el raton y si lo ha hecho dentro de los margenes de nuestro boton
        if (MouseHandler.isPulsado()) {
            if (MouseHandler.getX() > x && MouseHandler.getX() < x + width && MouseHandler.getY() > y && MouseHandler.getY() < y + height) {
                pulsado = true;
            }
        } else {
            //si se ha levantado el clic del raton encima de nuestro boton y habia sido pulsado de antes, entonces se ha presionado
            if (MouseHandler.getX() > x && MouseHandler.getX() < x + width && MouseHandler.getY() > y && MouseHandler.getY() < y + height) {
                if (pulsado) {
                    this.presionado();
                }
            }
            pulsado = false;
        }
    }

    public void presionado() {
        // avisamos a nuestro observador de que ha habido un cambio y deben actuar
        observador.update();
    }

    public String getNombre() {
        return nombre;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isPulsado() {
        return pulsado;
    }

    public void setPulsado(boolean pulsado) {
        this.pulsado = pulsado;
    }

    public Image getUp() {
        return up;
    }

    public void setUp(Image up) {
        this.up = up;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    public IObservador getObservador() {
        return observador;
    }

    public void setObservador(IObservador observador) {
        this.observador = observador;
    }

}
