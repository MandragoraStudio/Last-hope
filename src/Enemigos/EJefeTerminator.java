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
public class EJefeTerminator extends Enemy {

    public EJefeTerminator (int nivel, Vector2D posicion){
       super(10, (float) (0.5),500 + 45+nivel,50+nivel,5,0,posicion,"imagenes/tank-1-01.png",50);
    }
}

