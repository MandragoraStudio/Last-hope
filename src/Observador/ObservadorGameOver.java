/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import GestorSonido.ReproduceAudio;
import Graficos.Boton;
import Principal.Juego;

/**
 *
 * @author Jose
 */
public class ObservadorGameOver implements IObservador {

    private Boton boton; //boton al que observa

    public ObservadorGameOver(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {

        if (boton.getNombre().equals("Menu")) {
            ReproduceAudio r = ReproduceAudio.getReproductor();
            r.changeAudio("BSO.wav");
            Juego.getJuego().changeScreen("Menu");
        }

    }
}
