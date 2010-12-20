/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

/**
 *
 * @author Jose
 */
public class Buscador {
    public static JFileChooser filechoser;
    public static URL mediaURL = null;

    public static URL busca() {
        filechoser = new JFileChooser();
        int resul = filechoser.showOpenDialog(null);
        if (resul == JFileChooser.APPROVE_OPTION) {
            try {
                mediaURL = filechoser.getSelectedFile().toURI().toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

            

        }
       // String ruta=mediaURL.getFile();
        return mediaURL;
    }

}
