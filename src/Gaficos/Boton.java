/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gaficos;

import Principal.MouseHandler;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public class Boton {
    Image up,down;
    String nombre;
    int x,y,height,width;
    boolean pulsado;

    public Boton(Image up, Image down, String nombre, int x, int y, int height, int width) {
        this.up = up;
        this.down = down;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void draw(Graphics2D g){
        g.drawImage(pulsado?down:up, x, y,null);
    }
    public void update(){
        if(MouseHandler.isPulsado()){
            if(!pulsado && MouseHandler.getX()>x&&MouseHandler.getX()<x+width&&MouseHandler.getY()>y&&MouseHandler.getY()<y+height){
               pulsado=true;
               this.presionado();

            }
        }else{
            pulsado=false;
        }
    }

    public void presionado(){
        System.out.println("funciono");
    }


}
