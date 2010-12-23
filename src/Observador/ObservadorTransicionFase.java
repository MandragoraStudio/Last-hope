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
public class ObservadorTransicionFase implements IObservador {

    private Boton boton; //boton al que observa

    public ObservadorTransicionFase(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        //switch de string
        if (boton.getNombre().equals("skip")) {
            Juego.getJuego().restartGame();
            Juego.getJuego().changeScreen("Game");
        }
    }
}
