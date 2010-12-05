/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import UtilMath.Vector2D;
import java.awt.Image;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Jose
 */
public class Habilidad extends Actor{
    private Map<String, Integer> coste = new LinkedHashMap<String, Integer>();
    public Habilidad(Image im, Vector2D posicion) {
        super(im, posicion);
    }

    public Map<String, Integer> getCoste() {
        return coste;
    }

    public void setCoste(Map<String, Integer> coste) {
        this.coste = coste;
    }

}
