/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.Boton;
import Graficos.BotonGeneral;
import Graficos.Fondo;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Contenido extends Fondo {

    private List<Boton> botonesPorDefecto;
    private List<Boton> botones;

    public Contenido(String url, Vector2D posicion) {
        super(url,posicion);
        this.botonesPorDefecto = new ArrayList();
        this.botones = new ArrayList();
    }

    @Override
    public void update() {
        for(Boton b: this.getBotonesPorDefecto()){
            b.update();
        }
        for(Boton b: this.getBotones()){
            b.update();
        }
    }



    @Override
    public void draw(Graphics2D g){
        g.drawImage(this.getImagen(), (int)posicion.x, (int)posicion.y, null);

        for(Boton b: this.getBotonesPorDefecto()){
            b.draw(g);
        }
        for(Boton b: this.getBotones()){
            b.draw(g);
        }
    }

    public List<Boton> getBotonesPorDefecto() {
        return botonesPorDefecto;
    }

    public void setBotonesPorDefecto(List<Boton> botonesPorDefecto) {
        this.botonesPorDefecto = botonesPorDefecto;
    }

    public List<Boton> getBotones() {
        return botones;
    }

    //addBoton añadirá un boton en la posicion relativa pasada por argumento
    public void addBoton(Image up, Image down, String nombre, int x, int y) throws Exception{

        this.getBotones().add(new BotonGeneral(up, down, nombre, (int)posicion.x+x, (int)posicion.y+y, up.getWidth(null), up.getHeight(null)));

    }
    //addBotonPorDefecto añadirá un botón según el orden en que tienen que estar los botones por defecto
    //dependiendo del contenido en el que estemos
    public void addBotonPorDefecto(Image up, String nombre){
        this.getBotonesPorDefecto().add(new Boton(up, nombre, this.calculaX(), this.calculaY(), up.getWidth(null), up.getHeight(null)));
    }
    public void addBotonPorDefecto(Boton b) throws Exception{
        this.getBotonesPorDefecto().add(b);
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
