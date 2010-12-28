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
public class Acido extends Habilidad{

    private static float veneno;

    public Acido(Image im, Vector2D posicion) {
        super(im, posicion);
        veneno = 2F;
        this.getCoste().put("uranio", 300);
        this.getCoste().put("rodio", 300);
        this.getCoste().put("grafeno", 300);
        this.getCoste().put("radio", 300);
        this.getCoste().put("cromo", 300);
        this.getCoste().put("energia", 0);
        this.setNombre("Ácido");
        Acido.accionHabilidad();
    }
    public Habilidad clone(){
        Acido dev;
        Vector2D posicion = new Vector2D(this.posicion.x, this.posicion.y);
        Image ima = this.getImagen();
        dev = new Acido(ima,posicion);
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
