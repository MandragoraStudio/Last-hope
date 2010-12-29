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
       super(8, (float) (1+0.4),90 +nivel,15+nivel,6,4,posicion,"imagenes/EBlindado.png",50);
    }
}

