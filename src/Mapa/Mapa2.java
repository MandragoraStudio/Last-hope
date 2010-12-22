/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mapa;

import Enemigos.EBasico;
import Enemigos.EGod;
import Enemigos.ERapido;
import Enemigos.ETerminator;
import UtilMath.Vector2D;

/**
 *
 * @author Jose
 */
public class Mapa2 extends Mapa{

    int a[][]={
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};

    public Mapa2(int m[][]) {
        super(m);
        this.setMapa(a);
    }
    public static void sendWave(int n) {
        if (n % 10 == 0) {
            for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new EGod(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
        } else {
            if (n % 3 == 0) {
                for (int i = 0; i < 20; i++) {
                    Ventana_Mapa.addEnemy(new EBasico(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            } else if (n % 3 == 1) {
                for (int i = 0; i < 20; i++) {
                    Ventana_Mapa.addEnemy(new ERapido(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            } else {
                for (int i = 0; i < 15; i++) {
                    Ventana_Mapa.addEnemy(new ETerminator(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }
        }


    }
}
