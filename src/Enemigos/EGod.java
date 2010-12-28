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
        super(9, (float)(0+(0.5*nivel)), 500 + 50+nivel, 50+nivel,10,0,posicion, "imagenes/Tank rojo.png",50);
    }

}