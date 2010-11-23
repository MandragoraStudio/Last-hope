/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Enemigos.EBasico;
import Personajes.Actor;
import Personajes.Enemy;
import Personajes.Tower;
import Graficos.IVentana;
import Observador.IObservador;
import Observador.Observador_Mapa;
import Personajes.Splash;
import Handlers.MouseHandler;
import UtilMath.Vector2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Thanar
 */
public class Ventana_Mapa implements IVentana {

    private int WIDTH;
    private int HEIGHT;
    private static int x;
    private static int y;
    public static int casillaHeight;
    public static int casillaWidth;
    public static Mapa map;
    public static List<Actor> actores;
    public static List<Actor> eliminar;
    public static List<Actor> agregar;
    public static boolean construir = false;
    public static Tower torre = null;
    List<IObservador> observadores;

    public Ventana_Mapa(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        actores = new ArrayList<Actor>();
        eliminar = new LinkedList<Actor>();
        agregar = new LinkedList<Actor>();
        this.x = x;
        this.y = y;
        this.cargar();
        observadores = new ArrayList<IObservador>();
        new Observador_Mapa(this);
    }

    public void attach(IObservador o) {
        observadores.add(o);
    }

    public static void eliminaActor(Actor a){
        eliminar.add(a);
    }

    public static Vector2D getCasilla(int x1, int y1) {
        return new Vector2D((x1 - x) / casillaWidth, (y1 - y) / casillaHeight);
    }

    public Vector2D getCoordenadaCasilla(int x, int y) {
        return new Vector2D(((x - this.x) / casillaWidth) * casillaWidth, ((y - this.y) / casillaHeight) * casillaHeight);
    }

    public Vector2D getCoordenada(int x, int y) {
        return new Vector2D(x * casillaWidth, y * casillaHeight);
    }
    public static Vector2D getCoordenadaCentro(int x, int y) {
        return new Vector2D(x * casillaWidth + casillaWidth/2, y * casillaHeight + casillaHeight /2);
    }
    public static Vector2D getCoordenadaCentro(Vector2D posicion) {
        return new Vector2D(posicion.x * casillaWidth + casillaWidth/2, posicion.y * casillaHeight + casillaHeight /2);
    }

    public boolean casillaValidaTorre(Vector2D casilla) {
        boolean dev;
        dev = map.getMapa()[(int) casilla.y][(int) casilla.x] > 0;
        for (Actor a : actores) {
            if (getCasilla((int) a.posicion.x, (int) a.posicion.y).equals(casilla)) {
                dev = false;
                break;
            }
        }
        return dev;
    }

    public void draw(Graphics2D g) {
        //limpio la pantalla con un color arenilla
        g.setColor(new Color(0xEBC053));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //pinto las casillas de hierba con color hierba...
        //lo suyo seria una imagencilla... pero por ahora no tengo
        for (int i = 0; i < map.getMapa().length; i++) {
            for (int j = 0; j < map.getMapa()[0].length; j++) {
                g.setColor(Color.green);

                if (map.getMapa()[i][j] > 0) {
                    g.fillRect(j * casillaWidth, i * casillaHeight, casillaWidth, casillaHeight);
                }
            }
        }

        // cosas del suelo
        for (Actor a : actores) {
            if((a instanceof Splash))
                a.draw(g);
        }
        //ahora pintariamos unas torres...
        //y ahora pintamos unos enemiguillos...
        for (Actor a : actores) {
            if(!(a instanceof Splash))
                a.draw(g);
        }
        //pintamos los proyectiles ahora?

        //aqui datos de debug
        pintaDatosDebug(g);

    }

    public void addEnemy(Enemy e) {
        actores.add(e);
    }

    public void addTower(Tower t) {
        actores.add(t);
    }

    public void update() {
        for(Actor a : agregar){
            actores.add(a);
        }
        agregar.clear();
        for (Actor a : actores) {
            a.update();
        }
        for(Actor a : eliminar){
            if(actores.contains(a))
                actores.remove(a);
        }
        eliminar.clear();
        if (isPulsado()) {
            for (IObservador o : observadores) {
                o.update("");
            }
        }
    }

    public boolean isPulsado() {
        boolean dev = false;
        if (MouseHandler.isPulsado()) {
            if (MouseHandler.getX() > x && MouseHandler.getX() < x + WIDTH && MouseHandler.getY() > y && MouseHandler.getY() < y + HEIGHT) {
                dev = true;
            }
        }
        return dev;
    }

    public void cargar() {
        //matriz del mapa
        int[][] mapa = {
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        //calculo el tamaño de las casillas
        casillaHeight = HEIGHT / mapa.length;
        casillaWidth = WIDTH / mapa[0].length;
        //y ya tenemos mapa!!!! ^^ ^^
        map = new Mapa(mapa);
        sendWave(1);
    }

    private void pintaDatosDebug(Graphics2D g) {
        Color c = g.getColor();
        g.setColor(Color.black);


        g.drawString(torre == null ? "no hay torre" : "si hay torre", 10, 10);
        g.drawString(construir ? "construir" : "no construir", 10, 30);
        g.drawString("hay " + actores.size() + " actores", 10, 50);


        g.setColor(c);
    }

    public void sendWave(int n) {
        for (int i = 0; i < 20; i++) {
            addEnemy(new EBasico(n,new Vector2D(10, (int)(-Ventana_Mapa.casillaWidth*1.3*i))));
        }
    }
}
