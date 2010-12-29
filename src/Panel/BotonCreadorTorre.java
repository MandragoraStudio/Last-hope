/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.BotonGeneral;
import Mapa.Ventana_Mapa;
import Observador.Observador_CreadorTorre;
import Personajes.Tower;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class BotonCreadorTorre extends BotonGeneral {

    private Tower t; //torre que va a crear cuando se pulse el boton

    public BotonCreadorTorre(Image up, Image down, String nombre, int x, int y, int width, int height, Tower to) throws Exception {
        //inicializamos atributos
        super(up, down, nombre, x, y, width, height);
        this.t = to;
        new Observador_CreadorTorre(this);
    }

    public void creaTorre() {
        Ventana_Mapa.creaTorre(t);
        Ventana_Mapa.habilidad=null;
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
            if (isPulsado()){
                g.setColor(Color.BLACK);
                g.fillRect(600, 0, 150, 150);
                g.setColor(Color.green);
                g.drawString("Nombre: "+this.getNombre(), 620, 20);
                g.drawString("Daño: "+t.getAtaque(), 620, 35);
                g.drawString("Rango: "+t.getRango(), 620, 50);
                g.drawString("Area de daño: "+t.getAreaDeAtaque(), 620, 65);
                g.drawString("Congelacion: "+t.getCongelacion(), 620, 80);
                g.drawString("Fuego: "+t.getFuego(), 620, 95);
                g.drawString("Ácido: "+t.getAcido(), 620, 110);
                g.drawString("Recarga: "+t.getRecarga(), 620, 125);
                g.drawString("Penetracion: "+t.getPenetracion(), 620, 140);
                
            }
         }

    public Tower getT() {
        return t;
    }
    

}
