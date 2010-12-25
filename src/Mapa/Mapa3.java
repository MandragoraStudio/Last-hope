/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Enemigos.EGod;
import Enemigos.EJefeBasico3;
import Enemigos.EJefeMaster;
import Enemigos.EJefeRapido;
import Enemigos.EJefeTerminator;
import Graficos.Lienzo;
import UtilMath.Vector2D;

/**
 *
 * @author Jose
 */
public class Mapa3 extends Mapa {

    public Mapa3(int m[][]) {
        super(m);
        this.fondo = Lienzo.cargarImagen("imagenes/Tiles/hormigon3.jpg");
        this.hierba = Lienzo.cargarImagen("imagenes/Tiles/cuevaNieve3.png");
        this.id=3;
    }

    public void sendWave(int n) {

        if (n % 1 == 0) {
            for (int i = 0; i < 10; i++) {
                Ventana_Mapa.addEnemy(new EJefeBasico3(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
            }
        }
        if (n % 2 == 0) {
            for (int i = 0; i < 10; i++) {
                Ventana_Mapa.addEnemy(new EJefeRapido(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
            }
        }
        if (n % 3 == 0) {
            for (int i = 0; i < 10; i++) {
                Ventana_Mapa.addEnemy(new EJefeMaster(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
            }
        }
        if (n % 4 == 0) {
            for (int i = 0; i < 10; i++) {
                Ventana_Mapa.addEnemy(new EJefeTerminator(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
            }
        }
        if (n % 5 == 0) {
            for (int i = 0; i < 5; i++) {
                Ventana_Mapa.addEnemy(new EGod(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
            }
        }
    }
}
