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
public class Ventana_Mapa implements IVentana {

    private int WIDTH;
    private int HEIGHT;

    public Ventana_Mapa(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void draw(Graphics2D g) {
        g.setColor(new Color(0xEBC053));
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void update() {
    }

    public void cargar() {
    }
}
