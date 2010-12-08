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
       super(10, (float) (8+0.8*nivel),350 + 350*nivel,35+nivel,6,5,posicion,"imagenes/mounstrillo.png",50);
    }
}

