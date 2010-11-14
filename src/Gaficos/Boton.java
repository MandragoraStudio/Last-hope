/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gaficos;

import Principal.MouseHandler;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanar
 */
public class Boton {
    List<IObservador> observadores;
    Image up,down;
    String nombre;
    int x,y,height,width;
    boolean pulsado;
    public boolean ejecutar;

    public Boton(Image up, Image down, String nombre, int x, int y, int width, int height) throws Exception {
        if(up.getWidth(null)!=down.getWidth(null)||up.getHeight(null)!=down.getHeight(null))
            throw new Exception("Ambas imagenes deben tener el mismo tamaño");
        this.up = up;
        this.down = down;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        observadores = new ArrayList<IObservador>();
        new ObservadorMenu(this);
    }
    public void Atach(IObservador ob){
        observadores.add(ob);
    }
    public void Detach(IObservador ob){
        observadores.remove(ob);
    }

    public void draw(Graphics2D g){
        Image im = pulsado?down:up;
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
        for(IObservador ob : observadores){
            ob.update(nombre);
        }
    }

    public String getNombre() {
        return nombre;
    }


}
