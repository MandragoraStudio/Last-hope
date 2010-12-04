/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import Observador.Observador_CreadorHabilidad;
import Personajes.Habilidad;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class BotonCreadorHabilidad extends Boton{

    private Habilidad h; // trampa que vamos a crear cuando pulsemos el boton

    public BotonCreadorHabilidad(Image up, Image down, String nombre, int x, int y, int width, int height, Habilidad h) throws Exception {
        super(up, nombre, x, y, width, height);
        this.h=h;
        this.Detach(this.getObservadores().get(0));
        new Observador_CreadorHabilidad(this);

    }

    public void setTorre(Habilidad h){
        this.h=h;
    }

    public void creaHabilidad(){
        
    }
}
