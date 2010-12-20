/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorSonido;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Ejemplo de reproducción de ficheros de sonido.
 * @author chuidiang
 * http://www.chuidiang.com
 */
public class ReproduceAudio {

    public static Clip sonido;

    /**
     * Abre un fichero de sonido wav y lo reproduce
     * @param args
     */
    public static void reproduceAudio(String url) {
        try {

            // Se obtiene un Clip de sonido
            sonido = AudioSystem.getClip();

            // Se carga con un fichero wav
            sonido.open(AudioSystem.getAudioInputStream(new File(url)));

            // Comienza la reproducción
            sonido.start();
            sonido.loop(sonido.LOOP_CONTINUOUSLY);


        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    public static void changeAudio(String url) {
        sonido.stop();
        sonido.close();
        try {
            // Se carga con un fichero wav
            sonido.open(AudioSystem.getAudioInputStream(new File(url)));
        } catch (Exception e) {
            System.out.println("" + e);
        }

        // Comienza la reproducción
        sonido.start();
        sonido.loop(sonido.LOOP_CONTINUOUSLY);
    }
}
