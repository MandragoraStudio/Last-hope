/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Panel.Ventana_Panel;
import Principal.Juego;

/**
 *
 * @author Thanar
 */
public class Observador implements IObservador {
    private Boton boton;
    public Observador(Boton b){
        boton = b;
        boton.Atach(this);
    }

    public void update(String comando) {
        if(comando.equals("start")){
            Juego.changeScreen("Game");
        }else if (comando.equals("TRY")) {
            System.out.println("PROOOOOEEEEZZ");
        }
        if(comando.equals("torres")){
            Ventana_Panel.cambiaFondo("fondoTorres");
        }
        if(comando.equals("editor")){
            Ventana_Panel.cambiaFondo("fondoEditor");
        }
        if(comando.equals("trap")){
            Ventana_Panel.cambiaFondo("fondoTraps");
        }
    }
}
