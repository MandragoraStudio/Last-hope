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
public class EJefeBasico extends Enemy {
    /** Constructor de la clase EJefeBasico
     *
     */
    public EJefeBasico (int nivel, Vector2D posicion){
       super(2, (float) (3+(0.2*nivel)),50 + 25+nivel,7+nivel,4,1,posicion,"imagenes/Driller_St2.png",50);
    }
}

