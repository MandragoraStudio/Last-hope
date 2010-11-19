/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import Personajes.Tower;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class BotonCreadorTorre extends Boton{

    private static Tower t;

    public BotonCreadorTorre(Image up, Image down, String nombre, int x, int y, int width, int height) throws Exception {
        super(up, down, nombre, x, y, width, height);
    }

    public BotonCreadorTorre(Image up, Image down, String nombre, int x, int y, int width, int height, Tower t) throws Exception {
        super(up, down, nombre, x, y, width, height);
        BotonCreadorTorre.t=t;
    }

    public void setTorre(Tower t){
        BotonCreadorTorre.t=t;
    }

    public static void creaTorre(){
        System.out.println("ID: " +BotonCreadorTorre.t.getId());
        System.out.println("Ataque: " +BotonCreadorTorre.t.getAtaque());
        System.out.println("Area: " +BotonCreadorTorre.t.getArea());
        System.out.println("ralentizacion: " +BotonCreadorTorre.t.getRalentizacion());
        System.out.println("ultimoDisparo: " +BotonCreadorTorre.t.getUltimoDisparo());
        System.out.println("tRecarga: " +BotonCreadorTorre.t.gettRecarga());
        System.out.println("dañoPasivo: " +BotonCreadorTorre.t.getDañoPasivo());
        System.out.println("coste: " +BotonCreadorTorre.t.getCoste());
        System.out.println("im: " +BotonCreadorTorre.t.getIm());
        
        
    }
}
