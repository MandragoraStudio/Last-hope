/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enemigos;

import Personajes.Enemy;
import UtilMath.Vector2D;

/**
 *
 * @author alumno
 */
public class EMaster extends Enemy {

    public EMaster(int nivel, Vector2D posicion){
        super(7, (float)(8+(0.8*nivel)), 200 + 200*nivel, 8+nivel,0,0,posicion, "imagenes/mounstrillo.png",50);
    }

}