/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Panel.BotonCreadorTorre;
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
        }else if (comando.equals("exit")) {
            System.exit(0);
        }
        else if(comando.equals("Menu")){
            Juego.changeScreen("Menu");
        }
        else if(comando.equals("torres")){
            Ventana_Panel.cambiaFondo("fondoTorres");
        }
        else if(comando.equals("editor")){
            Ventana_Panel.cambiaFondo("fondoEditor");
        }
        else if(comando.equals("trap")){
            Ventana_Panel.cambiaFondo("fondoTraps");
        }
        else if(comando.equals("creaTorre")){
            BotonCreadorTorre.creaTorre();
        }
        else if(comando.equals("creaTrap")){
            Ventana_Panel.cambiaFondo("fondoTraps");
        }
    }
}
