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
public abstract class Habilidad extends Actor{
    private Map<String, Integer> coste = new LinkedHashMap<String, Integer>();
    private String nombre;
    public Habilidad(Image im, Vector2D posicion) {
        super(im, posicion, null);
        this.nombre="Habilidad";
    }

    public Map<String, Integer> getCoste() {
        return coste;
    }

    public void setCoste(Map<String, Integer> coste) {
        this.coste = coste;
    }

    public abstract Habilidad clone();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
