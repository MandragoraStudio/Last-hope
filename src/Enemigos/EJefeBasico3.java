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
public class EJefeBasico3 extends Enemy {

    public EJefeBasico3 (int nivel, Vector2D posicion){
       super(6, (float) (3+(0.4)),50 + 50*nivel,10+nivel,4,2,posicion,"imagenes/tank-2-01.png",50);
    }
}

