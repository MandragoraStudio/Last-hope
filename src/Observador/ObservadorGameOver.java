/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import GestorSonido.HiloMusical;
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
            HiloMusical h = HiloMusical.getHiloMusical("BSO.wav");
            h.start();
            Juego.getJuego().changeScreen("Menu");
        }

    }
}
