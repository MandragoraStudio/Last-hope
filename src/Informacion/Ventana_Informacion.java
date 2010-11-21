/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import Graficos.IVentana;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Thanar
 */
public class Ventana_Informacion implements IVentana {

    private int WIDTH;
    private int HEIGHT;
    private int x;
    private int y;
    
    public Ventana_Informacion(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x=x;
        this.y=y;
        this.cargar();
    }

  

    public void update() {
    }

    public void draw(Graphics2D g) {
        //cambia el origen de coordenadas
        g.translate(0, 500);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //codigo de la ventana a partir de aqui
        
        //devuelve el origen de coordenadas a su posicion original
        g.translate(0, -500);
    }
    public void cargar() {
    }
}
