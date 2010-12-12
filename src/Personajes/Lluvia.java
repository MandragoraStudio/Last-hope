/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

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
        ralentizacion = 0.5F;
        this.setNombre("Lluvia");
    }



    public float getRalentizacion() {
        return ralentizacion;
    }

    public void setRalentizacion(float ralentizacion) {
        this.ralentizacion = ralentizacion;
    }

    public static void accionHabilidad(List <Actor> actores) {
        List <Enemy> enemigos = new ArrayList();
        for(Actor a: actores){
            if (a instanceof Enemy) {
                enemigos.add((Enemy)a);
            }
        }
        for(Enemy e: enemigos){
            e.congelar(ralentizacion, 200);
        }
    }

}
