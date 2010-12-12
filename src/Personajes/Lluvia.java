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
 * @author Jose
 */
public class Lluvia extends Habilidad{

    private static float ralentizacion;

    public Lluvia(Image im, Vector2D posicion) {
        super(im, posicion);
        ralentizacion = 0.2F;
        this.setNombre("Lluvia");
        Lluvia.accionHabilidad();
    }
    public Habilidad clone(){
        Lluvia dev;
        Vector2D posicion = new Vector2D(this.posicion.x, this.posicion.y);
        Image ima = this.getImagen();
        dev = new Lluvia(ima,posicion);
        dev.setNombre(this.getNombre());
        return dev;
    }
    public float getRalentizacion() {
        return ralentizacion;
    }

    public void setRalentizacion(float ralentizacion) {
        this.ralentizacion = ralentizacion;
    }

    public static void accionHabilidad() {
        List <Enemy> enemigos = new ArrayList();
        for(Actor a: Ventana_Mapa.actores){
            if (a instanceof Enemy) {
                enemigos.add((Enemy)a);
            }
        }
        for(Enemy e: enemigos){
            e.congelar(ralentizacion, 200);
        }
    }

}
