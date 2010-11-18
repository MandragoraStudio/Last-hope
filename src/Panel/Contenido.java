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
public class Contenido extends Fondo {

    private List<Boton> botones;

    public Contenido(String url, int x, int y) {
        super(url);
        this.botones = new ArrayList();
        this.x=x;
        this.y=y;
    }

    @Override
    public void draw(Graphics2D g){
        g.drawImage(this.getImagen(), this.getX(), this.getY(), null);

        for(Boton b: this.getBotones()){
            b.draw(g);
        }

    }

    public List<Boton> getBotones() {
        return botones;
    }

    public void setBotones(List<Boton> botones) {
        this.botones = botones;
    }
    //addBoton añadirá un boton en la posicion relativa pasada por argumento
    public void addBoton(Image up, String nombre, int x, int y, int width, int height) throws Exception{
        this.getBotones().add(new Boton(up, up, nombre, this.getX()+x, this.getY()+y, width, height));
    }
    //addBotonPorDefecto añadirá un botón según el orden en que tienen que estar los botones por defecto
    //dependiendo del contenido en el que estemos
    public void addBotonPorDefecto(Image up, String nombre, int width, int height) throws Exception{
        this.getBotones().add(new Boton(up, up, nombre, this.calculaX(), this.calculaY(), width, height));
    }
    public int calculaX() {
        int pos = 0;
        
        return pos;
    }

    public int calculaY() {
        int pos = 0;

        return pos;
    }
}
