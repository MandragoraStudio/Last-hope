/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Graficos.Lienzo;
import Mapa.Ventana_Mapa;
import Panel.BotonCreadorTorre;
import Panel.ContenidoTorres;
import Personajes.Tower;
import Principal.Juego;
import UtilMath.Vector2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Juego.getJuego().changeScreen("Menu");
        }else if (boton.getNombre().equals("Pausa")) {
            Ventana_Mapa.setPausa(true);
        } else if (boton.getNombre().equals("Play")) {
            Ventana_Mapa.setPausa(false);
        }
    }
}
