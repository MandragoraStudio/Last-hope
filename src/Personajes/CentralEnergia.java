/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Principal.Juego;
import UtilMath.Vector2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jose
 */
public class CentralEnergia extends Habilidad {

    private static int energiaProducida;

    public CentralEnergia(Image im, Vector2D posicion) {
        super(im, posicion);
        this.energiaProducida = 50;
        this.getCoste().put("uranio", 75);
        this.getCoste().put("rodio", 20);
        this.getCoste().put("grafeno", 20);
        this.getCoste().put("radio", 0);
        this.getCoste().put("cromo", 10);
        this.getCoste().put("energia", 0);
        this.setNombre("CentralEnergia");
    }
    public Habilidad clone() {
        CentralEnergia dev;
        Vector2D posicion = new Vector2D(this.posicion.x, this.posicion.y);
        Image ima = this.getImagen();
        dev = new CentralEnergia(ima,posicion);
        dev.setNombre(this.getNombre());
        return dev;
    }
    public static void accionHabilidad() {
        Map<String, Integer> recursos = new HashMap();
        recursos.put("uranio", 0);
        recursos.put("rodio", 0);
        recursos.put("grafeno", 0);
        recursos.put("radio", 0);
        recursos.put("cromo", 0);
        recursos.put("energia", energiaProducida);
        Juego.getJuego().jugador.agregaRecursos(recursos);
    }
}
