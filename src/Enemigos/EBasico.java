/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enemigos;

import Personajes.Enemy;
import UtilMath.Vector2D;

/**
 *
 * @author Thanar
 */
public class EBasico extends Enemy {
    
    public EBasico(int nivel, Vector2D posicion){
        super(1, (float)(2+(0.2*nivel)), 50 + 50*nivel, 3+nivel,0,0, posicion, "imagenes/mounstrillo.png",50);
    }

}