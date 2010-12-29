/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Observador;

import Graficos.Boton;
import Principal.Juego;
import Screens.Tutorial;

/**
 *
 * @author Jose
 */
public class ObservadorTutorial implements IObservador {

    private Boton boton; //boton al que observa

    public ObservadorTutorial(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        //switch de string
        if (boton.getNombre().equals("skip")) {
            Tutorial.changeImagen();
        }
    }
}
