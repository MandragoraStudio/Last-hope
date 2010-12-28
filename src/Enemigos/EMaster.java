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
        super(7, (float)(1+(0.8*nivel)), 30 + 20+nivel, 4+nivel,3,1,posicion, "imagenes/tankamarillo.png",50);
    }
}