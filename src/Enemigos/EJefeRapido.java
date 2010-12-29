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
public class EJefeRapido extends Enemy {

    public EJefeRapido (int nivel, Vector2D posicion){
       super(4, (float) (4+0.1),10 + 8+nivel,8+nivel,0,0,posicion,"imagenes/Spliter.arana2.png",50);
    }
}

