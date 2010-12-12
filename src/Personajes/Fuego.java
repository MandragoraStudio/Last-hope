/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import Mapa.Ventana_Mapa;
import UtilMath.Vector2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Fuego extends Habilidad{

    private static float fuego;

    public Fuego(Image im, Vector2D posicion) {
        super(im, posicion);
        fuego = 2F;
        this.getCoste().put("uranio", 100);
        this.getCoste().put("rodio", 30);
        this.getCoste().put("grafeno", 0);
        this.getCoste().put("radio", 50);
        this.getCoste().put("cromo", 25);
        this.getCoste().put("energia", 0);
        this.setNombre("Lluvia");
        Fuego.accionHabilidad();
    }
    public Habilidad clone(){
        Fuego dev;
        Vector2D posicion = new Vector2D(this.posicion.x, this.posicion.y);
        Image ima = this.getImagen();
        dev = new Fuego(ima,posicion);
        dev.setNombre(this.getNombre());
        return dev;
    }

    public static float getFuego() {
        return fuego;
    }

    public static void setFuego(float fuego) {
        Fuego.fuego = fuego;
    }

    public static void accionHabilidad() {
        List <Enemy> enemigos = new ArrayList();
        for(Actor a: Ventana_Mapa.actores){
            if (a instanceof Enemy) {
                enemigos.add((Enemy)a);
            }
        }
        for(Enemy e: enemigos){
            e.quemar(fuego, 200);
            System.out.println("QUEMA!!!!");
        }
    }
    @Override
    public void update() {
        Ventana_Mapa.eliminar.add(this);
    }
}
