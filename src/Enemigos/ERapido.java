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
public class ERapido extends Enemy {

    public ERapido(int nivel, Vector2D posicion){
        super(3, (float)(4+(0.2)), 10 + 10*nivel, 1,0,0,posicion, "imagenes/ERapido.png",50);
    }
}
