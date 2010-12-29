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
            Juego.getJuego().changeScreen("InicioFase1");
            ReproduceAudio r = ReproduceAudio.getReproductor();
            r.changeAudio("finFase.wav");
            
        } else if (boton.getNombre().equals("exit")) {
            System.exit(0);
        } else if (boton.getNombre().equals("Credits")){
            Juego.getJuego().changeScreen("Credits");

        }else if (boton.getNombre().equals("Tutorial")){
            Juego.getJuego().changeScreen("Tutorial");
        }
    }
}
