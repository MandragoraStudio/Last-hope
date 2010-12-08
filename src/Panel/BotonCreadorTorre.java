/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.BotonGeneral;
import Mapa.Ventana_Mapa;
import Observador.Observador_CreadorTorre;
import Personajes.Tower;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class BotonCreadorTorre extends BotonGeneral {

    private Tower t; //torre que va a crear cuando se pulse el boton

    public BotonCreadorTorre(Image up, Image down, String nombre, int x, int y, int width, int height, Tower to) throws Exception {
        //inicializamos atributos
        super(up, down, nombre, x, y, width, height);
        this.t = to;
        new Observador_CreadorTorre(this);
    }

    public void creaTorre() {
        Ventana_Mapa.creaTorre(t);
    }
}
