/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Navegador;

import Principal.MouseHandler;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Pestaña {
    List<IObservadorNav> observadores;
    Image im;
    String nombre;
    int x,y,height,width;
    boolean pulsado;
    public boolean ejecutar;

    public Pestaña(Image im, String nombre, int x, int y, int width, int height) {
        this.im = im;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        observadores = new ArrayList<IObservadorNav>();
        new ObservadorNav(this);
    }
    public void Atach(IObservadorNav ob){
        observadores.add(ob);
    }
    public void Detach(IObservadorNav ob){
        observadores.remove(ob);
    }

    public void draw(Graphics2D g){
        g.drawImage(im, x, y,width,height,null);
    }

    public void update(){
        if(MouseHandler.isPulsado()){
            if(MouseHandler.getX()>x&&MouseHandler.getX()<x+width&&MouseHandler.getY()>y&&MouseHandler.getY()<y+height){
               pulsado=true;
            }
        }else{
            if(MouseHandler.getX()>x&&MouseHandler.getX()<x+width&&MouseHandler.getY()>y&&MouseHandler.getY()<y+height){
                if(pulsado){
                    this.presionado();
                }
            }
            pulsado=false;
        }
    }

    public void presionado(){
        for(IObservadorNav ob : observadores){
            ob.update(nombre);
        }
    }

    public String getNombre() {
        return nombre;
    }


}
