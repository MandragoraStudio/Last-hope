/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Observador;

import Panel.BotonCreadorHabilidad;

/**
 *
 * @author Jose
 */
public class Observador_CreadorHabilidad implements IObservador{
    private BotonCreadorHabilidad boton; //boton al que observa

    public Observador_CreadorHabilidad(BotonCreadorHabilidad b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        //switch de string

        if (boton.getNombre().equals(boton.getNombre())) {
            boton.creaHabilidad();
        }
    }
}
