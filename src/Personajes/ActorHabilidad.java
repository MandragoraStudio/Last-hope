/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import Graficos.Lienzo;
import Mapa.Ventana_Mapa;
import UtilMath.Vector2D;

/**
 *
 * @author Thanar
 */
public class ActorHabilidad extends Actor {
    Vector2D velocidad;
    public ActorHabilidad(){
        super( Lienzo.cargarImagen("imagenes/B50.png"), new Vector2D(Ventana_Mapa.WIDTH/2-50,Ventana_Mapa.HEIGHT), 100, 250);
        velocidad = new Vector2D(0,-7);
        this.rotation=(float)(Math.PI*0.5)+velocidad.getAngle();
    }


    @Override
    public void update(){
        if(!Ventana_Mapa.pausa){
        this.posicion= this.posicion.add(velocidad);
        if(posicion.y<-500){
            Ventana_Mapa.eliminar.add(this);
        }
        super.update();
        }
    }

}
