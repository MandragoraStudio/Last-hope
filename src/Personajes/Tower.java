/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

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

    public Tower(int id, float ataque, int area, float ralentizacion, float ultimoDisparo, float tRecarga, float dañoPasivo, float coste) {
        this.id = id;
        this.ataque = ataque;
        this.area = area;
        this.ralentizacion = ralentizacion;
        this.ultimoDisparo = ultimoDisparo;
        this.tRecarga = tRecarga;
        this.dañoPasivo = dañoPasivo;
        this.coste = coste;
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
}
