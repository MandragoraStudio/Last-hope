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
       super(4, (float) (2+0.2*nivel),200 + 200*nivel,14+nivel,3,2,posicion,"imagenes/ERapido.png",50);
    }
}

