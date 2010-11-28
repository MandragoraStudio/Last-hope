/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import UtilMath.Vector2D;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class Trap extends Actor {

    private int id;
    private float ataque;
    private int area;
    private float ralentizacion;
    private float dañoPasivo;
    private float coste;
    private Image im;

    public Trap(int id, float ataque, int area, float ralentizacion, float dañoPasivo, float coste, Vector2D posicion, Image im) {
        super(null, posicion);
        this.id = id;
        this.ataque = ataque;
        this.area = area;
        this.ralentizacion = ralentizacion;
        this.dañoPasivo = dañoPasivo;
        this.coste = coste;

        this.im = im;


    }

    @Override
    public void update() {
    }

    public void dispara() {
    }

    public boolean isEnemigoATiro() {
        return false;
    }

    public boolean isReadyToFire() {
        return false;
    }

    public void rotarTorre(int x, int y) {
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public float getAtaque() {
        return ataque;
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    public float getDañoPasivo() {
        return dañoPasivo;
    }

    public void setDañoPasivo(float dañoPasivo) {
        this.dañoPasivo = dañoPasivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }

    public float getRalentizacion() {
        return ralentizacion;
    }

    public void setRalentizacion(float ralentizacion) {
        this.ralentizacion = ralentizacion;
    }
}
