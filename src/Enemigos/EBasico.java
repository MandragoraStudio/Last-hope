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
        super(1, (float)(1+(0.2*nivel)), 20 + 50*nivel, 2+nivel,0,0, posicion, "imagenes/EBasico.png",50);
    }

}
