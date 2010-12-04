/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import UtilMath.Vector2D;
import java.awt.Image;
import java.util.Map;

/**
 *
 * @author Jose
 */
public class CentralEnergia extends Habilidad{
    
    private float energiaProducida;

    public CentralEnergia(Image im, Vector2D posicion) {
        super(im, posicion);
        this.energiaProducida=20;
        this.getCoste().put("uranio", 100);
        this.getCoste().put("rodio", 20);
        this.getCoste().put("grafeno", 20);
        this.getCoste().put("radio", 0);
        this.getCoste().put("cromo", 10);
        this.getCoste().put("energia", 0);
    }

    public float getEnergiaProducida() {
        return energiaProducida;
    }

    public void setEnergiaProducida(float energiaProducida) {
        this.energiaProducida = energiaProducida;
    }

}
