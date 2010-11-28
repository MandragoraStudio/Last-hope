/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import Personajes.Trap;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class BotonCreadorTrap extends Boton{

    private static Trap t; // trampa que vamos a crear cuando pulsemos el boton
    //constructor de prueba hasta que se implementen las habilidades especiales
    public BotonCreadorTrap(Image up, Image down, String nombre, int x, int y, int width, int height) throws Exception {
        super(up, nombre, x, y, width, height);
    }

    public BotonCreadorTrap(Image up, Image down, String nombre, int x, int y, int width, int height, Trap t) throws Exception {
        super(up, nombre, x, y, width, height);
        BotonCreadorTrap.t=t;
    }

    public void setTorre(Trap t){
        BotonCreadorTrap.t=t;
    }

    public static void creaTrap(){
        System.out.println("ID: " +BotonCreadorTrap.t.getId());
        System.out.println("Ataque: " +BotonCreadorTrap.t.getAtaque());
        System.out.println("Area: " +BotonCreadorTrap.t.getArea());
        System.out.println("ralentizacion: " +BotonCreadorTrap.t.getRalentizacion());
        System.out.println("dañoPasivo: " +BotonCreadorTrap.t.getDañoPasivo());
        System.out.println("coste: " +BotonCreadorTrap.t.getCoste());
        System.out.println("im: " +BotonCreadorTrap.t.getIm());
    }
}
