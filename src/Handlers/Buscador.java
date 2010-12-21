/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Graficos.Lienzo;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

/**
 *
 * @author Jose
 */
public class Buscador {
    public JFileChooser filechoser;
    public URL mediaURL = null;
    public static Buscador b;
    private Buscador(){

    }

    public static Buscador getBuscador(){
        if(b==null){
            b=new Buscador();
        }
        return b;
    }
    public URL busca() {
        filechoser = new JFileChooser();
        int resul = filechoser.showOpenDialog(Lienzo.frame);
        if (resul == JFileChooser.APPROVE_OPTION) {
            try {
                mediaURL = filechoser.getSelectedFile().toURI().toURL();
            } catch (Exception ex) {
                Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

            

        }
        return mediaURL;
    }

}
