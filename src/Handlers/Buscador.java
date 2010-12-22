/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import java.io.File;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jose
 */
public class Buscador {

    public JFileChooser filechoser;
    public URL mediaURL = null;
    public static Buscador b;

    private Buscador() {
    }

    public static Buscador getBuscador() {
        if (b == null) {
            b = new Buscador();
        }
        return b;
    }

    public URL busca() {
        System.gc();
        filechoser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".jpg & .gif & .png", "jpg", "gif", "png");
        filechoser.setFileFilter(filtro);
        filechoser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = filechoser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

                File file = filechoser.getSelectedFile();
            try {
                mediaURL = file.toURI().toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
            }
            } else {
                mediaURL=null;
            }
        return mediaURL;
    }
}
