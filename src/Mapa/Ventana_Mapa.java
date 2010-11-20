/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Personajes.Actor;
import Personajes.Enemy;
import Personajes.Tower;
import Graficos.IVentana;
import Observador.IObservador;
import Observador.Observador_Mapa;
import Principal.MouseHandler;
import UtilMath.Vector2D;
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
    public static int casillaHeight;
    public static int casillaWidth;
    Mapa map;
    List<Actor> actores;
    public static boolean construir = false;
    public static Tower torre = null;
    List<IObservador> observadores;

    public Ventana_Mapa(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        actores = new ArrayList<Actor>();
        this.x=x;
        this.y=y;
        this.cargar();
        observadores = new ArrayList<IObservador>();
        new Observador_Mapa(this);
    }
    public void attach(IObservador o){
        observadores.add(o);
    }

    public Vector2D getCasilla(int x, int y){
        return new Vector2D((x-this.x)/casillaWidth,(y-this.y)/casillaHeight);
    }
    public Vector2D getCoordenadaCasilla(int x, int y){
        return new Vector2D(((x-this.x)/casillaWidth)*casillaWidth,((y-this.y)/casillaHeight)*casillaHeight);
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

        pintaDatosDebug(g);
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
        if(isPulsado()){
            for(IObservador o:observadores){
                o.update("");
            }
        }
    }

    public boolean isPulsado(){
        boolean dev=false;
        if(MouseHandler.isPulsado()){
            if(MouseHandler.getX()>x&&MouseHandler.getX()<x+WIDTH&&MouseHandler.getY()>y&&MouseHandler.getY()<y+HEIGHT){
               dev=true;
            }
        }
        return dev;
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

    private void pintaDatosDebug(Graphics2D g){
        Color c = g.getColor();
        g.setColor(Color.black);

        
        g.drawString(torre==null?"no hay torre":"si hay torre", 10, 10);
        g.drawString(construir?"construir":"no construir", 10, 30);
        g.drawString("hay "+actores.size()+" torres", 10, 50);


        g.setColor(c);
    }
}
