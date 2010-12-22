/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorSonido;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 * Ejemplo de reproducción de ficheros de sonido.
 * @author chuidiang
 * http://www.chuidiang.com
 */
public class ReproduceAudio {

    public static Clip sonido;
    public static ReproduceAudio r;

    private ReproduceAudio() {
        try {
            // Se obtiene un Clip de sonido
            sonido = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ReproduceAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ReproduceAudio getReproductor() {
        if (r == null) {
            r = new ReproduceAudio();
        }
        return r;
    }

    public void changeAudio(String url) {
        if (sonido.isOpen()) {
            sonido.stop();
            sonido.close();
        }
        try {
            // Se carga con un fichero wav
            InputStream path = getClass().getResourceAsStream("/Sonidos/" + url);
            sonido.open(AudioSystem.getAudioInputStream(path));
        } catch (Exception e) {
            Logger.getLogger(ReproduceAudio.class.getName()).log(Level.SEVERE, null, e);
        }

        // Comienza la reproducción
        sonido.start();
        sonido.loop(sonido.LOOP_CONTINUOUSLY);
    }
}
