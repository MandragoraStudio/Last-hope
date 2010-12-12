/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import java.util.Map;

/**
 *
 * @author jose
 */
public interface IHabilidad {

    public Map<String, Integer> getCoste();

    public void setCoste(Map<String, Integer> coste);

    public Habilidad clone();

    public String getNombre();

    public void setNombre(String nombre);

}
