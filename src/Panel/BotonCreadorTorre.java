/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.BotonGeneral;
import Mapa.Ventana_Mapa;
import Personajes.Tower;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class BotonCreadorTorre extends BotonGeneral {

    private static Tower t; //torre que va a crear cuando se pulse el boton

    public BotonCreadorTorre(Image up, Image down, String nombre, int x, int y, int width, int height, Tower to) throws Exception {
        //inicializamos atributos
        super(up, down, nombre, x, y, width, height);
        BotonCreadorTorre.t = to;
    }

    public void setTorre(Tower t) {
        BotonCreadorTorre.t = t;
    }

    public static void creaTorre() {
        Ventana_Mapa.construir = true;
        Ventana_Mapa.torre = BotonCreadorTorre.t;
    }
}
