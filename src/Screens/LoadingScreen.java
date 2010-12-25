/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Screens;

import GestorSonido.ReproduceAudio;
import Graficos.Lienzo;
import Principal.Globals;
import Principal.Juego;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public class LoadingScreen implements IScreen{
    private static LoadingScreen loading;
    public static long lTime =0;
    public static int time = 60;
    private Image im;
    private Image oscuridad;

    private LoadingScreen(){
        im=Lienzo.cargarImagen("imagenes/Pantalla inicial.png");
        oscuridad=Lienzo.cargarImagen("imagenes/Opacidad.png");
        ReproduceAudio r = ReproduceAudio.getReproductor();
        r.changeAudio("BSO.wav");
    }

    public static LoadingScreen getLoadingScreen(){
        if(loading==null){
            loading=new LoadingScreen();
        }
        return loading;
    }

    public void cargarModelos() {
        //AQUI NO SE PUEDE METER NADA
    }

    public void update() {
        lTime += Globals.elapsedTime;
        time=(int)( 120-((lTime/1000.0f)*30));
        if(time<0){
            Juego.getJuego().changeScreen("Presentacion");
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(0,0,Juego.getJuego().WIDTH,Juego.getJuego().HEIGHT);
        g.drawImage(im,0,0,Juego.getJuego().WIDTH,Juego.getJuego().HEIGHT, null);
        if(time<30){
            for(int i = time; i<30;i++){
                g.drawImage(oscuridad,0,0,Juego.getJuego().WIDTH,Juego.getJuego().HEIGHT, null);
                g.drawImage(oscuridad,0,0,Juego.getJuego().WIDTH,Juego.getJuego().HEIGHT, null);
            }
        }

    }

}
