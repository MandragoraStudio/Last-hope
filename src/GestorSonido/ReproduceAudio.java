/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorSonido;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Ejemplo de reproducción de ficheros de sonido.
 * @author chuidiang
 * http://www.chuidiang.com
 */
public class ReproduceAudio {

    public static Clip sonido;
    public static ReproduceAudio r;

    private ReproduceAudio(){

    }

    public static ReproduceAudio getReproductor(){
        if(r==null){
            r= new ReproduceAudio();
        }
        return r;
    }
    /**
     * Abre un fichero de sonido wav y lo reproduce
     * @param args
     */
    public void reproduceAudio(String url) {
        try {
            // Se obtiene un Clip de sonido
            sonido = AudioSystem.getClip();

            InputStream path = getClass().getResourceAsStream("/Sonidos/" +url);
            sonido.open(AudioSystem.getAudioInputStream(path));

        }catch (Exception ex) {
            Logger.getLogger(ReproduceAudio.class.getName()).log(Level.SEVERE, null, ex);
        }

            // Comienza la reproducción
            sonido.start();
            sonido.loop(sonido.LOOP_CONTINUOUSLY);

    }

    public void changeAudio(String url) {
        sonido.stop();
        sonido.close();
        try {
            // Se carga con un fichero wav
            InputStream path = getClass().getResourceAsStream("/Sonidos/" +url);
            sonido.open(AudioSystem.getAudioInputStream(path));
        } catch (Exception e) {
            Logger.getLogger(ReproduceAudio.class.getName()).log(Level.SEVERE, null, e);
        }

        // Comienza la reproducción
        sonido.start();
        sonido.loop(sonido.LOOP_CONTINUOUSLY);
    }
}
