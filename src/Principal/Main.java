/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

/**
 *
 * @author Thanar
 */
public class Main {

    public static void main(String[] args) {
        Juego juego = Juego.getJuego();
        Threader hilo = new Threader(juego);
        hilo.run();
        //juego.runGame();
    }

}
