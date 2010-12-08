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
public class EJefeMaster extends Enemy {

    public EJefeMaster (int nivel, Vector2D posicion){
       super(8, (float) (8+0.8*nivel),300 + 300*nivel,28+nivel,5,4,posicion,"imagenes/mounstrillo.png",50);
    }
}

