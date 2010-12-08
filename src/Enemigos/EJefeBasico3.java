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
       super(6, (float) (4+0.4*nivel),250 + 250*nivel,21+nivel,4,3,posicion,"imagenes/mounstrillo.png",50);
    }
}

