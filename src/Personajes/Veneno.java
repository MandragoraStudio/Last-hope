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
public class Veneno extends Habilidad{

    private static float veneno;

    public Veneno(Image im, Vector2D posicion) {
        super(im, posicion);
        veneno = 2F;
        this.getCoste().put("uranio", 100);
        this.getCoste().put("rodio", 30);
        this.getCoste().put("grafeno", 0);
        this.getCoste().put("radio", 50);
        this.getCoste().put("cromo", 25);
        this.getCoste().put("energia", 0);
        this.setNombre("Lluvia");
        Veneno.accionHabilidad();
    }
    public Habilidad clone(){
        Veneno dev;
        Vector2D posicion = new Vector2D(this.posicion.x, this.posicion.y);
        Image ima = this.getImagen();
        dev = new Veneno(ima,posicion);
        dev.setNombre(this.getNombre());
        return dev;
    }


    public static void accionHabilidad() {
        lanzarActor();
        List <Enemy> enemigos = new ArrayList();
        for(Actor a: Ventana_Mapa.actores){
            if (a instanceof Enemy) {
                enemigos.add((Enemy)a);
            }
        }
        for(Enemy e: enemigos){
            e.envenenar(veneno, 200);
        }
    }
    @Override
    public void update() {
        Ventana_Mapa.eliminar.add(this);
    }
}
