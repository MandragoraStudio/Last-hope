/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import Graficos.Fondo;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Contenido extends Fondo{
    private List <Boton> botones;
    public Contenido(String url, int x, int y) {
        super(url);
        this.botones=new ArrayList();
        this.x=x;
        this.y=y;
    }
    @Override
    public void draw(Graphics2D g){
        g.drawImage(imagen, x, y, null);
        
        for(Boton b: this.botones){
            b.draw(g);
        }
    }
    public void addBoton(Boton b){
        this.botones.add(b);
    }
    public void addBoton(Image up, String nombre, int width, int height) throws Exception{
        if(this.botones.size()<12){
            this.botones.add(new Boton(up, up, nombre, this.calculaX(), this.calculaY(), width, height));
        }
    }
    public int calculaX(){
        int pos=0;
        int modulo=this.botones.size()%3;
        if(this.botones.size()==0){
            pos=this.getX()+31;
        }
        else{
            pos=super.getX()+(modulo*81)+31;
        }
        return pos;
    }
    public int calculaY(){
        int pos=0;
        int cociente=this.botones.size()/3;
        if(this.botones.size()==0){
            pos=this.getY()+31;
        }
        else{
                pos=this.getY()+(cociente*81)+31;
        }
        return pos;
    }
}
