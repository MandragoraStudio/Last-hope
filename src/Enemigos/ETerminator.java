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
public class ETerminator extends Enemy {

    public ETerminator(int nivel, Vector2D posicion){
        super(5, (float)(1+(0.4)), 40 + 20+nivel,5+nivel,2,0,posicion, "imagenes/ATT_st2.png",50);
    }
}