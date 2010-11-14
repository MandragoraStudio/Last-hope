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
public class Ventana_Panel implements IVentana {
private int WIDTH;
    private int HEIGHT;

    public Ventana_Panel(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }
    public void draw(Graphics2D g) {
        //cambia el origen de coordenadas
        g.translate(750, 0);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //devuelve el origen de coordenadas a su posicion original
        g.translate(-750, 0);
    }

    public void update() {
    }

    public void cargar() {
    }

}
