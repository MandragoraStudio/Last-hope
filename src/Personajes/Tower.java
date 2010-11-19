/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import java.awt.Image;

/**
 *
 * @author Jose
 */
public class Tower extends Actor{

    private int id;
    private float ataque;
    private int area;
    private float ralentizacion;
    private float ultimoDisparo;
    private float tRecarga;
    private float dañoPasivo;
    private float coste;
    private Image im;

    public Tower(int id, float ataque, int area, float ralentizacion, float ultimoDisparo, float tRecarga, float dañoPasivo, float coste, Image im) {
        this.id = id;
        this.ataque = ataque;
        this.area = area;
        this.ralentizacion = ralentizacion;
        this.ultimoDisparo = ultimoDisparo;
        this.tRecarga = tRecarga;
        this.dañoPasivo = dañoPasivo;
        this.coste = coste;
        this.im = im;
    }

    @Override
    public void update() {
        
    }

    public void dispara(){

    }

    public boolean isEnemigoATiro(){
        return false;
    }
    public boolean isReadyToFire(){
        return false;
    }
    public void rotarTorre(int x, int y){

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

    public float gettRecarga() {
        return tRecarga;
    }

    public void settRecarga(float tRecarga) {
        this.tRecarga = tRecarga;
    }

    public float getUltimoDisparo() {
        return ultimoDisparo;
    }

    public void setUltimoDisparo(float ultimoDisparo) {
        this.ultimoDisparo = ultimoDisparo;
    }


}
