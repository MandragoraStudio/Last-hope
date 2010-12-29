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
        super(7, (float)(1+(0.7)), 30 +nivel, 4+nivel,3,2,posicion, "imagenes/tankamarillo.png",50);
    }
}