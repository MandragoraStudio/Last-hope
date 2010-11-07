/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import Gaficos.Lienzo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Thanar
 */
public class Juego {
    Lienzo imagen;
    long startTime;
    long previousTime;
    boolean salir=false;
    Graphics2D pincel;
    static final int WIDTH = 1024;
    static final int HEIGHT = 600;
    public Juego(){
        imagen = new Lienzo(WIDTH, HEIGHT);
        pincel = (Graphics2D) imagen.strategy.getDrawGraphics();



    }
    public void runGame(){
        startTime=System.currentTimeMillis();
        previousTime = startTime;
        cargarModelos();
        while(!salir){
            update();
            draw();
            if(System.currentTimeMillis()-previousTime<33){
                try{
                Thread.sleep(33-(System.currentTimeMillis()-previousTime));
                }catch(Exception e){}
            }
            previousTime=System.currentTimeMillis();
        }
    }
    public void cargarModelos(){

    }
    public void update(){

    }
    public void draw(){
        pincel.setColor(Color.CYAN);
        pincel.fillRect(0,0,WIDTH,HEIGHT);

        pincel.dispose();
        imagen.strategy.show();
    }

}
