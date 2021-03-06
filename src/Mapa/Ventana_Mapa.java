/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Personajes.Actor;
import Personajes.Enemy;
import Personajes.Tower;
import Graficos.IVentana;
import Graficos.Lienzo;
import Observador.IObservador;
import Observador.Observador_Mapa;
import Personajes.Splash;
import Handlers.MouseHandler;
import Informacion.Ventana_Informacion;
import Personajes.CentralEnergia;
import Personajes.Habilidad;
import Principal.Juego;
import UtilMath.Vector2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Thanar
 */
public class Ventana_Mapa implements IVentana {

    public static int WIDTH;
    public static int HEIGHT;
    private static int x;
    private static int y;
    public static int casillaHeight;
    public static int casillaWidth;
    public static Mapa map;
    public static List<Actor> actores;
    public static List<Actor> eliminar;
    public static List<Actor> agregar;
    public static boolean construir = false;
    public static Tower torre = null; // Se usa tambien en Ventana informacion
    public static boolean construirH = false;
    public static Habilidad habilidad = null;
    List<IObservador> observadores;
    public static int nivel = 1;
    public static boolean pausa = true;

    public Ventana_Mapa(int WIDTH, int HEIGHT, int x, int y, String imagenCamino, String imagenHierba) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        actores = new ArrayList<Actor>();
        eliminar = new LinkedList<Actor>();
        agregar = new LinkedList<Actor>();
        this.x = x;
        this.y = y;
        this.cargar(null);
        nivel = 1;
        observadores = new ArrayList<IObservador>();
        if (imagenCamino != null) {
            map.fondo = Lienzo.cargarImagen(imagenCamino);
        }
        if (imagenHierba != null) {
            map.hierba = Lienzo.cargarImagen(imagenHierba);
        }
        new Observador_Mapa(this);
    }

    public void attach(IObservador o) {
        observadores.add(o);
    }

    public static void creaTorre(Tower t) {
        Ventana_Mapa.construirH = false;
        Ventana_Mapa.construir = true;
        Ventana_Mapa.torre = t;
    }

    public static void creaHabilidad(Habilidad h) {
        Ventana_Mapa.construir = false;
        Ventana_Mapa.construirH = true;
        Ventana_Mapa.habilidad = h;
    }

    public static void eliminaActor(Actor a) {
        eliminar.add(a);
    }

    public static Vector2D getCasilla(int x1, int y1) {
        return new Vector2D((x1 - x) / casillaWidth, (y1 - y) / casillaHeight);
    }

    //te da las coordenadas de la casilla en una posicion dada
    public Vector2D getCoordenadaCasilla(int x, int y) {
        return new Vector2D(((x - this.x) / casillaWidth) * casillaWidth, ((y - this.y) / casillaHeight) * casillaHeight);
    }

    public Vector2D getCoordenadaCasilla(Vector2D v) {
        int x = (int) v.x;
        int y = (int) v.y;
        return new Vector2D(((x - this.x) / casillaWidth) * casillaWidth, ((y - this.y) / casillaHeight) * casillaHeight);
    }

    //te da las coordenadas de una casilla dada
    public Vector2D getCoordenada(int x, int y) {
        return new Vector2D(x * casillaWidth, y * casillaHeight);
    }

    //te da las coordenadas del centro de una casilla dada
    public static Vector2D getCoordenadaCentro(int x, int y) {
        return new Vector2D(x * casillaWidth + casillaWidth / 2.0f, y * casillaHeight + casillaHeight / 2.0f);
    }

    //similar al anterior, recibe un vector
    public static Vector2D getCoordenadaCentro(Vector2D posicion) {
        return new Vector2D(posicion.x * casillaWidth + casillaWidth / 2.0f, posicion.y * casillaHeight + casillaHeight / 2.0f);
    }

    //comprobamos si la casilla dada por las coordenadas del vector es valida para construir
    public boolean casillaValidaConstruir(Vector2D casilla) {
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
                    g.drawImage(map.hierba, j * casillaWidth, i * casillaHeight, casillaWidth, casillaHeight, null);
                } else {
                    if (map.fondo != null) {
                        g.drawImage(map.fondo, j * casillaWidth, i * casillaHeight, casillaWidth, casillaHeight, null);
                    }
                }
            }
        }


        // cosas del suelo
        for (Actor a : actores) {
            if ((a instanceof Splash)) {
                a.draw(g);
            }
        }
        //ahora pintariamos unas torres...
        //y ahora pintamos unos enemiguillos...
        for (Actor a : actores) {
            if (!(a instanceof Splash)) {
                a.draw(g);
            }
        }

        //pintado de cosas temporales
        //aqui hay unos offsets metidos a pelo de 25, es para que las torres se pinten en la casilla en la qeu van a construirse, no se por que no sale bien si no
        if (construir) {
            torre.posicion = getCoordenadaCasilla(new Vector2D(MouseInfo.getPointerInfo().getLocation().x - Lienzo.frame.getX(), MouseInfo.getPointerInfo().getLocation().y - 25 - Lienzo.frame.getY()));
            torre.draw(g);
            g.drawImage(Ventana_Informacion.brillo, (int) (torre.posicion.x + (Ventana_Mapa.casillaWidth / 2) - torre.getRango()), (int) (torre.posicion.y + (Ventana_Mapa.casillaHeight / 2) - torre.getRango()), (int) (torre.getRango() * 2), (int) (torre.getRango() * 2), null);
        } else if (construirH) {
            habilidad.posicion = getCoordenadaCasilla(new Vector2D(MouseInfo.getPointerInfo().getLocation().x - Lienzo.frame.getX(), MouseInfo.getPointerInfo().getLocation().y - 25 - Lienzo.frame.getY()));
            habilidad.draw(g);
        }


        //pintamos los proyectiles ahora?

        //aqui datos de debug
        //pintaDatosDebug(g);
        if (Ventana_Mapa.pausa) {
            g.setColor(Color.red);
            g.setFont(new Font("SansSerif", Font.BOLD, 40));
            g.drawString("PAUSA", 350, 250);
            g.setFont(new Font("SansSerif", Font.BOLD, 12));
        }
    }

    public static void addEnemy(Enemy e) {
        agregar.add(e);
    }

    public void addTower(Tower t) {
        agregar.add(t);
    }

    public void addHabilidad(Habilidad h) {
        agregar.add(h);
        if (h.getNombre().equalsIgnoreCase("CentralEnergia")) {
            CentralEnergia.accionHabilidad();
        }

    }

    public static void eliminaTodo() {
        for (Actor a : actores) {
            eliminar.add(a);
        }
        for (Actor a : agregar) {
            eliminar.add(a);
        }
    }

    public void update() {
        for (Actor a : agregar) {
            actores.add(a);
        }
        agregar.clear();


        for (Actor a : actores) {
            a.update();
        }

        for (Actor a : eliminar) {
            if (actores.contains(a)) {
                actores.remove(a);
            }
        }
        eliminar.clear();


        //si no quedan enemigos... algo habra uqe hacer ;-)
        if (numeroEnemigos() == 0) {
            nivel++;
            sendWave(nivel);
        }
        if (isPulsado()) {
            for (IObservador o : observadores) {
                o.update();
            }
        }
    }

    //devuelve el numero de enemigos en pantalla
    public int numeroEnemigos() {
        int dev = 0;
        for (Actor a : actores) {
            if (a instanceof Enemy) {
                dev++;
            }
        }
        return dev;
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

    public static void cargar(int[][] mapa) {
        //matriz del mapa
        /*int[][] mapa = {
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
        };*/

        int[][] ma = {
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};
        if (mapa == null) {
            mapa = ma;
        }

        //calculo el tamaño de las casillas
        casillaHeight = HEIGHT / mapa.length;
        casillaWidth = WIDTH / mapa[0].length;
        //y ya tenemos mapa!!!! ^^ ^^
        map = new Mapa1(mapa);
        nivel = 1;
        sendWave(1);
    }

    //pintemos algunos datos utiles para nosotros que desarrollamos!! (si, claro, utiles)
    private void pintaDatosDebug(Graphics2D g) {
        Color c = g.getColor();
        g.setColor(Color.black);


        g.drawString(habilidad == null ? "no hay edificio" : "si hay edicifio", 10, 10);
        g.drawString(construirH ? "construir" : "no construir", 10, 30);
        g.drawString("hay " + actores.size() + " actores", 10, 50);


        g.setColor(c);
    }

    //pues eso, manda una oleada
    public static void sendWave(int n) {

        map.sendWave(n);
    }

    public void cargar() {

        cargar(null);
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Ventana_Mapa.HEIGHT = HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Ventana_Mapa.WIDTH = WIDTH;
    }

    public static List<Actor> getActores() {
        return actores;
    }

    public static void setActores(List<Actor> actores) {
        Ventana_Mapa.actores = actores;
    }

    public static List<Actor> getAgregar() {
        return agregar;
    }

    public static void setAgregar(List<Actor> agregar) {
        Ventana_Mapa.agregar = agregar;
    }

    public static int getCasillaHeight() {
        return casillaHeight;
    }

    public static void setCasillaHeight(int casillaHeight) {
        Ventana_Mapa.casillaHeight = casillaHeight;
    }

    public static int getCasillaWidth() {
        return casillaWidth;
    }

    public static void setCasillaWidth(int casillaWidth) {
        Ventana_Mapa.casillaWidth = casillaWidth;
    }

    public static boolean isConstruir() {
        return construir;
    }

    public static void setConstruir(boolean construir) {
        Ventana_Mapa.construir = construir;
    }

    public static boolean isConstruirH() {
        return construirH;
    }

    public static void setConstruirH(boolean construirH) {
        Ventana_Mapa.construirH = construirH;
    }

    public static List<Actor> getEliminar() {
        return eliminar;
    }

    public static void setEliminar(List<Actor> eliminar) {
        Ventana_Mapa.eliminar = eliminar;
    }

    public static Habilidad getHabilidad() {
        return habilidad;
    }

    public static void setHabilidad(Habilidad habilidad) {
        Ventana_Mapa.habilidad = habilidad;
    }

    public static Mapa getMap() {
        return map;
    }

    public static void setMap(Mapa map) {
        Ventana_Mapa.map = map;
        Ventana_Mapa.pausa = true;
        Ventana_Mapa.eliminaTodo();
        Ventana_Mapa.setNivel(0);
        Juego.getJuego().jugador.setVida(100);
        Juego.getJuego().jugador.getRecursos().remove("energia");
        Juego.getJuego().jugador.getRecursos().put("energia", 0);
    }

    public static int getNivel() {
        return nivel;
    }

    public static void setNivel(int nivel) {
        Ventana_Mapa.nivel = nivel;
    }

    public List<IObservador> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<IObservador> observadores) {
        this.observadores = observadores;
    }

    public static boolean isPausa() {
        return pausa;
    }

    public static void setPausa(boolean pausa) {
        Ventana_Mapa.pausa = pausa;
    }

    public static Tower getTorre() {
        return torre;
    }

    public static void setTorre(Tower torre) {
        Ventana_Mapa.torre = torre;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        Ventana_Mapa.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Ventana_Mapa.y = y;
    }
}
