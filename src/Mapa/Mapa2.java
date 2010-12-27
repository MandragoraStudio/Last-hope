/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Enemigos.EJefeBasico;
import Enemigos.EJefeBasico3;
import Enemigos.EJefeRapido;
import Enemigos.EMaster;
import Enemigos.ETerminator;
import Graficos.Lienzo;
import Principal.Juego;
import Principal.Jugador;
import UtilMath.Vector2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jose
 */
public class Mapa2 extends Mapa {

    public Mapa2(int m[][]) {
        super(m);
        this.fondo = Lienzo.cargarImagen("imagenes/Tiles/arena4.jpg");
        this.hierba = Lienzo.cargarImagen("imagenes/Tiles/desierto camino.png");
        this.id=2;
    }

    public void sendWave(int n) {
        if (n + 1 <= 2) {
            if (n%1==0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new EMaster(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n%2 == 0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new ETerminator(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n %3 == 0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new EJefeBasico(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n %4 == 0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new EJefeBasico3(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n %5 == 0) {
                for (int i = 0; i < 5; i++) {
                    Ventana_Mapa.addEnemy(new EJefeRapido(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }
        }else{
            Map recursos = new HashMap<String, Integer>();
            recursos.put("uranio", 1000);
            recursos.put("rodio", 1000);
            recursos.put("grafeno", 1000);
            recursos.put("radio", 1000);
            recursos.put("cromo", 1000);
            recursos.put("energia", 0);
            Jugador.agregaRecursos(recursos);
            int a[][]={
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},};

            Mapa3 m = new Mapa3(a);
            Ventana_Mapa.setMap(m);
            Juego.getJuego().changeScreen("FinFase2");
        }

    }
}
