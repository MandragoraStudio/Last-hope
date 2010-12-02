/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Observador;

import Graficos.Boton;
import Panel.BotonCreadorTorre;

/**
 *
 * @author Jose
 */
public class Observador_Creador implements IObservador{
    private Boton boton; //boton al que observa

    public Observador_Creador(Boton b) {
        boton = b;//inicializa el boton
        boton.Atach(this); //le añadimos al boton el observador
    }

    public void update(String comando) {
        //switch de string

        if (comando.equals(comando)) {
            BotonCreadorTorre.creaTorre();
        }
    }
}
