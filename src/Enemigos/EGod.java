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
public class EGod extends Enemy {

    public EGod(int nivel, Vector2D posicion){
        super(9, (float)(10+(1*nivel)), 400 + 400*nivel, 50+nivel,7,6,posicion, "imagenes/Tank rojo.png",50);
    }

}