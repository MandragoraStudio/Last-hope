/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graficos;

import Personajes.Actor;
import UtilMath.Vector2D;
import javax.imageio.ImageIO;

/**
 *
 * @author Thanar
 */
public class Fondo extends Actor {

    public Fondo(String url,Vector2D posicion){
        super(null,posicion);
        try{
            super.setImagen(ImageIO.read(this.getClass().getClassLoader().getResource(url)));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void update() {
    }

}
