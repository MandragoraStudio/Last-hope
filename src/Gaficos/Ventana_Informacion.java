/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Thanar
 */
public class Ventana_Informacion implements IVentana {

    private int WIDTH;
    private int HEIGHT;

    public Ventana_Informacion(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void draw(Graphics2D g) {
        //cambia el origen de coordenadas
        g.translate(0, 500);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //devuelve el origen de coordenadas a su posicion original
        g.translate(0, -500);
    }

    public void update() {
    }

    public void cargar() {
    }
}
