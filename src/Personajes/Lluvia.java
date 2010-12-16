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
public class Lluvia extends Accion{

    private static float ralentizacion;

    public Lluvia(Image im, Vector2D posicion) {
        super(im, posicion);
        ralentizacion = 0.2F;
        this.setNombre("Lluvia");
        Lluvia.accionHabilidad();
    }



    public float getRalentizacion() {
        return ralentizacion;
    }

    public void setRalentizacion(float ralentizacion) {
        this.ralentizacion = ralentizacion;
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
            e.congelar(ralentizacion, 200);
        }
    }

}
