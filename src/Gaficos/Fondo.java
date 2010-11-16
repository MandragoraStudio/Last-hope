/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gaficos;

import Personajes.Actor;
import javax.imageio.ImageIO;

/**
 *
 * @author Thanar
 */
public class Fondo extends Actor {
    public Fondo(String url){
        try{
            super.setImagen(ImageIO.read(this.getClass().getClassLoader().getResource(url)));
        }catch(Exception e){
            
        }
    }
    @Override
    public void update() {
    }

}
