/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Gaficos.IVentana;
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
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void draw(Graphics2D g) {
        //limpio la pantalla con un color arenilla
        g.setColor(new Color(0xEBC053));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //pinto las casillas de hierba con color hierba...
        //lo suyo seria una imagencilla... pero por ahora no tengo
        for(int i =0; i < map.getMapa().length;i++ ){
            for (int j=0;j<map.getMapa().length;j++){
                g.setColor(Color.green);
                if(map.getMapa()[i][j]>0)
                    g.fillRect(j*casillaWidth,i*casillaHeight,  casillaWidth, casillaHeight);
            }
        }
        //ahora pintariamos unas torres...
        //y ahora pintamos unos enemiguillos...
        //pintamos los proyectiles ahora?

    }

    public void update() {
    }

    public void cargar() {
        //matriz del mapa
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
        //calculo el tamaño de las casillas
        casillaHeight = HEIGHT / mapa[0].length;
        casillaWidth = WIDTH / mapa[0].length;
        //y ya tenemos mapa!!!! ^^ ^^
        map = new Mapa(mapa);
    }
}
