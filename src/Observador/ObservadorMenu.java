/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import GestorSonido.ReproduceAudio;
import Graficos.Boton;
import Mapa.Ventana_Mapa;
import Principal.Juego;

/**
 *
 * @author Thanar
 */
public class ObservadorMenu implements IObservador {

    private Boton boton; //boton al que observa

    public ObservadorMenu(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        //switch de string
        if (boton.getNombre().equals("start")) {
            Juego.getJuego().restartGame();
            Juego.getJuego().changeScreen("Game");
            ReproduceAudio r = ReproduceAudio.getReproductor();
            r.changeAudio("ingame.wav");

        } else if (boton.getNombre().equals("start2")) {
            int[][] mapa = {
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
            Ventana_Mapa.cargar(mapa);
            Juego.getJuego().changeScreen("Game");
        } else if (boton.getNombre().equals("exit")) {
            System.exit(0);
        } else if (boton.getNombre().equals("Credits")){
            Juego.getJuego().changeScreen("Credits");
        }
    }
}
