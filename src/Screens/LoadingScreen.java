/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import GestorSonido.ReproductorMp3;
import Graficos.Lienzo;
import Principal.Globals;
import Principal.Juego;

/**
 *
 * @author Thanar
 */
public class LoadingScreen implements IScreen {

    private static LoadingScreen loading;
    public static long lTime = 0;
    public static int time = 60;
    private Image im;
    private Image oscuridad;

    private LoadingScreen() {
        im = Lienzo.cargarImagen("imagenes/Pantalla inicial.png");
        oscuridad = Lienzo.cargarImagen("imagenes/Opacidad.png");

        //String s = new java.io.File("LHTest.jar").getAbsolutePath();
        //String aux = s.substring(0, s.length() - 11);

        //s = aux + "\\Sonidos\\BSO.mp3";


//			File fichero = new File("fichero.txt");
//				try{
//				  BufferedWriter bw = 
//				    new BufferedWriter(new FileWriter("fichero.txt"));
//    		 	  bw.write("Ruta: "+s);
//				  bw.close();
//				} catch (IOException ioe){
//					ioe.printStackTrace();
//				}

        ReproductorMp3 r = new ReproductorMp3("BSO.mp3");
        r.start();

//        ReproduceAudio r = ReproduceAudio.getReproductor();
//        r.changeAudio("/Sonidos/BSO.wav");
    }

    public static LoadingScreen getLoadingScreen() {
        if (loading == null) {
            loading = new LoadingScreen();
        }
        return loading;
    }

    public void cargarModelos() {
        //AQUI NO SE PUEDE METER NADA
    }

    public void update() {
        lTime += Globals.elapsedTime;
        time = (int) (90 - ((lTime / 1000.0f) * 30));
        if (time < 0) {
            Juego.getJuego().changeScreen("Presentacion");
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT);
        g.drawImage(im, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
        if (time < 30) {
            for (int i = time; i < 30; i++) {
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
                g.drawImage(oscuridad, 0, 0, Juego.getJuego().WIDTH, Juego.getJuego().HEIGHT, null);
            }
        }

    }
}
