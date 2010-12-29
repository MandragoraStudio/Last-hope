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
        super(1, (float)(2+(0.5)), 20+15*nivel, 2+nivel,0,0, posicion, "imagenes/EBasico.png",50);
    }

}
