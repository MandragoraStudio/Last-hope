/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import GestorSonido.ReproductorMp3;
import Graficos.Boton;
import Mapa.Ventana_Mapa;
import Principal.Juego;

/**
 *
 * @author Jose
 */
public class ObservadorPanelTorre implements IObservador {

    private Boton boton; //boton al que observa

    public ObservadorPanelTorre(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        if (boton.getNombre().equals("Menu")) {
            ReproductorMp3.cambiaMusica("Sonidos/BSO.mp3");
            ReproductorMp3 r = new ReproductorMp3("");
            r.start();
            Juego.getJuego().changeScreen("Menu");
        }else if (boton.getNombre().equals("Pausa")) {
            Ventana_Mapa.setPausa(true);
        } else if (boton.getNombre().equals("Play")) {
            Ventana_Mapa.setPausa(false);
        }
    }
}
