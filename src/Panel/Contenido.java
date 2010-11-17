/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import Graficos.Fondo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Contenido extends Fondo{
    List <Boton> botones;
    public Contenido(String url) {
        super(url);
        this.botones=new ArrayList();
    }

}
