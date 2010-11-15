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
    private int casillaHeight;
    private int casillaWidth;
    Mapa map;

    public Ventana_Mapa(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void draw(Graphics2D g) {
        g.setColor(new Color(0xEBC053));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for(int i =0; i < map.getMapa().length;i++ ){
            for (int j=0;j<map.getMapa().length;j++){
                g.setColor(Color.green);
                if(map.getMapa()[i][j]>0)
                    g.fillRect(j*casillaWidth,i*casillaHeight,  casillaWidth, casillaHeight);
            }
        }

    }

    public void update() {
    }

    public void cargar() {
        int[][] mapa=
        {
            {0,1,1,1,1,1,1,1,1,1},
            {0,1,1,0,0,0,1,1,1,1},
            {0,0,1,0,1,0,1,1,1,1},
            {1,0,0,0,1,0,1,1,1,1},
            {1,1,1,1,1,0,1,0,0,0},
            {1,1,1,1,1,0,1,0,1,1},
            {1,1,1,1,1,0,1,0,1,1},
            {1,1,1,1,1,0,0,0,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1}
        };
        casillaHeight = HEIGHT / mapa[0].length;
        casillaWidth = WIDTH / mapa[0].length;

        map = new Mapa(mapa);
    }
}
