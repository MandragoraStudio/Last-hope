/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

/**
 *
 * @author jose
 */
public class Threader implements Runnable{

    private Juego juego;
    public Threader(Juego juego){
        this.juego=juego;
    }
    public void run() {
        juego.runGame();
    }

}
