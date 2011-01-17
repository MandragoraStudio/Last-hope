/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import GestorSonido.ReproductorMp3;
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
            ReproductorMp3.cambiaMusica("Sonidos/BSO.mp3");
            ReproductorMp3 r = new ReproductorMp3("");
            r.start();

            Juego.getJuego().changeScreen("Menu");
        }

    }
}
