/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Personajes.Actor;
import Personajes.Enemy;
import Personajes.Tower;
import Graficos.IVentana;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thanar
 */
public class Ventana_Mapa implements IVentana {

    private int WIDTH;
    private int HEIGHT;
    private int x;
    private int y;
    private int casillaHeight;
    private int casillaWidth;
    Mapa map;
    List<Actor> actores;

    public Ventana_Mapa(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        actores = new ArrayList<Actor>();
        this.x=x;
        this.y=y;
        this.cargar();
    }

    public void draw(Graphics2D g) {
        //limpio la pantalla con un color arenilla
        g.setColor(new Color(0xEBC053));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //pinto las casillas de hierba con color hierba...
        //lo suyo seria una imagencilla... pero por ahora no tengo
        for(int i =0; i < map.getMapa().length;i++ ){
            for (int j=0;j<map.getMapa()[0].length;j++){
                g.setColor(Color.green);
                
                if(map.getMapa()[i][j]>0)
                    g.fillRect(j*casillaWidth,i*casillaHeight,  casillaWidth, casillaHeight);
            }
        }
        //ahora pintariamos unas torres...
        //y ahora pintamos unos enemiguillos...
        for(Actor a : actores){
            a.draw(g);
        }
        //pintamos los proyectiles ahora?

    }

    public void addEnemy(Enemy e){
        actores.add(e);
    }
    public void addTower(Tower t){
        actores.add(t);
    }

    public void update() {
        for(Actor a : actores){
            a.update();
        }
    }

    public void cargar() {
        //matriz del mapa
        int[][] mapa=
        {
            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,1,1,1,0,0,0,1,1,1,1},
            {1,0,1,1,0,0,0,1,0,1,0,1,1,1,1},
            {1,0,0,1,0,1,0,0,0,1,0,1,1,1,1},
            {1,1,0,1,0,1,1,1,1,1,0,1,0,0,0},
            {1,1,0,1,0,0,1,1,1,1,0,1,0,1,1},
            {1,1,0,1,1,0,1,1,1,1,0,1,0,1,1},
            {1,1,0,0,0,0,1,1,1,1,0,0,0,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        //calculo el tamaño de las casillas
        casillaHeight = HEIGHT / mapa.length;
        casillaWidth = WIDTH / mapa[0].length;
        //y ya tenemos mapa!!!! ^^ ^^
        map = new Mapa(mapa);
    }
}
