/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import Graficos.Abotonador;
import Graficos.Lienzo;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public abstract class Actor {
    protected Image imagen;
    public Vector2D posicion = new Vector2D(0,0);
    Abotonador boton;

    public Actor(Image im,Vector2D posicion){
        if (posicion==null){
            posicion=Vector2D.zero;
        }
        if(im!=null){
        imagen=im;
        }else{
            imagen=Lienzo.cargarImagen("imagenes/torrePanel.png");
        }
        this.posicion=posicion;
        try{
        boton=new Abotonador("Actor", imagen.getHeight(null), imagen.getWidth(null), this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Vector2D getPosicion() {
        return posicion;
    }


    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
        boton.setHeight(imagen.getHeight(null));
        boton.setWidth(imagen.getWidth(null));
    }



    public void draw(Graphics2D g) {
        try {
            g.drawImage(imagen, (int) posicion.x, (int) posicion.y, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void update();
}
