/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;
/**
 *
 * @author Jose
 */
public class Enemy extends Actor{
    private int id;
    private float velocidad;
    private float vida;
    private int peso;
    private int Posx;
    private int PosY;


    public Enemy(int id, float velocidad, float vida, int peso) {
        this.id = id;
        this.velocidad = velocidad;
        this.vida = vida;
        this.peso = peso;
    }

    @Override
    public void update() {
    }


}
