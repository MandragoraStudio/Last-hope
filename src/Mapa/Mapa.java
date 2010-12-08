
package Mapa;

import Enemigos.EBasico;
import UtilMath.Vector2D;
import java.awt.Image;
import java.util.Vector;

/**
 *
 * @author Thanar
 */
public class Mapa {

    private int[][] mapa;
    public static Vector<Vector2D> camino;
    public Image fondo;
    public Image hierba;

    public Mapa(int[][] map) {
        camino = new Vector<Vector2D>();
        mapa = map;
        camino = analizaMapa();
    }

    public int[][] getMapa() {
        return mapa;
    }

    public static void sendWave(int n) {
        if(n%10==0){
            Ventana_Mapa.actores.clear();
            Ventana_Mapa.eliminar.clear();
            Ventana_Mapa.agregar.clear();
            int[][] a={
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
           Ventana_Mapa.cargar(a);
        }
        for (int i = 0; i < 20; i++) {
            Ventana_Mapa.addEnemy(new EBasico(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
        }

    }

    //este metodo analiza el array bidimensional que es el mapa y te devuelve una lista con las casillas que forman el camino
    public Vector<Vector2D> analizaMapa() {
        Vector<Vector2D> dev = new Vector<Vector2D>();
        Vector2D casillaAnterior = new Vector2D(0, 0);
        Vector2D casillaActual = new Vector2D(0, 0);
        Vector2D casillaSiguiente = new Vector2D(0, 0);
        boolean sigue=true;
        while (sigue) {
            sigue=false;
            dev.add(casillaActual);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int x = i;
                    int y = j;
                    if (j == 0 && i == 0) {
                        y = -1;
                    }
                    if (j == 1 && i == 1) {
                        y = 0;
                        x = -1;
                    }
                    if (casillaActual.x + x < 0 || casillaActual.y + y < 0 || casillaActual.y + y >= mapa.length || casillaActual.x + x >= mapa[0].length) {
                        continue;
                    }
                    if (mapa[(int) casillaActual.y + y][(int) casillaActual.x + x] == 0 && !casillaAnterior.equals(new Vector2D(casillaActual.x + x, casillaActual.y + y))) {
                        casillaSiguiente = new Vector2D(casillaActual.x + x, casillaActual.y + y);
                        casillaAnterior = casillaActual;
                        casillaActual = casillaSiguiente;
                        casillaSiguiente = null;
                        sigue=true;
                        break;
                    }
                }
                if (sigue) {
                    break;
                }
            }
        }
        return dev;
    }
}
