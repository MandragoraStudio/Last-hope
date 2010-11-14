/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import Principal.Juego;

/**
 *
 * @author Thanar
 */
public class ObservadorMenu implements IObservador {
    private Boton boton;
    public ObservadorMenu(Boton b){
        boton = b;
        boton.Atach(this);
    }

    public void update(String comando) {
        if(comando.equals("start")){
            Juego.changeScreen("Game");
        }else if (comando.equals("TRY")) {
            System.out.println("PROOOOOEEEEZZ");
        }
    }
}
