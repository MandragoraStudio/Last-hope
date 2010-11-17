/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graficos;

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
        new Observador(this);
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

    public Image getDown() {
        return down;
    }

    public void setDown(Image down) {
        this.down = down;
    }

    public boolean isEjecutar() {
        return ejecutar;
    }

    public void setEjecutar(boolean ejecutar) {
        this.ejecutar = ejecutar;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isPulsado() {
        return pulsado;
    }

    public void setPulsado(boolean pulsado) {
        this.pulsado = pulsado;
    }

    public Image getUp() {
        return up;
    }

    public void setUp(Image up) {
        this.up = up;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
