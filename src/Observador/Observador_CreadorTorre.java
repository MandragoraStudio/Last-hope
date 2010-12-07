/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Observador;

import Graficos.Boton;
import Panel.BotonCreadorTorre;

/**
 *
 * @author Jose
 */
public class Observador_CreadorTorre implements IObservador{
    private BotonCreadorTorre boton; //boton al que observa

    public Observador_CreadorTorre(BotonCreadorTorre b) {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
    }

    public void update() {
        //switch de string

        if (boton.getNombre().equals(boton.getNombre())) {
            boton.creaTorre();
        }
    }
}
