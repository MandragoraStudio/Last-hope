/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Panel.Ventana_Panel;
import Principal.Juego;

/**
 *
 * @author Jose
 */
public class ObservadorIngame implements IObservador {

    private Boton boton; //boton al que observa

    public ObservadorIngame(Boton b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {

        if (boton.getNombre().equals("torres")) {
            Ventana_Panel.cambiaFondo("fondoTorres");
        } else if (boton.getNombre().equals("editor")) {
            Ventana_Panel.cambiaFondo("fondoEditor");
        } else if (boton.getNombre().equals("trap")) {
            Ventana_Panel.cambiaFondo("fondoTraps");
        }

    }
}
