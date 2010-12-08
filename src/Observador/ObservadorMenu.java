/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Graficos.Lienzo;
import Mapa.Ventana_Mapa;
import Panel.ContenidoEditor;
import Panel.Ventana_Panel;
import Principal.Juego;
import java.awt.Image;
import javax.swing.JOptionPane;

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
            Juego.changeScreen("Game");
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
            Juego.changeScreen("Game");
        } else if (boton.getNombre().equals("exit")) {
            System.exit(0);
        } 
    }
}
