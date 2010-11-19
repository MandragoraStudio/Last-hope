/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import UtilMath.Vector2D;

/**
 *
 * @author Jose
 */
public class Enemy extends Actor{
    private int id;
    private float velocidad;
    private Vector2D direccion;
    private float vida;
    private int peso;
    private Vector2D posicion;

    public Enemy(int id, float velocidad, float vida, int peso, Vector2D posicion) {
        this.id = id;
        this.velocidad = velocidad;
        direccion = new Vector2D(0,0);
        this.vida = vida;
        this.peso = peso;
        this.posicion = posicion;
    }


    

    @Override
    public void update() {
        posicion= posicion.add(direccion.mult(velocidad));
    }


}
