/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Enemigos.EBasico;
import Enemigos.EGod;
import Enemigos.ERapido;
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
        this.fondo = Lienzo.cargarImagen("");
        this.hierba = Lienzo.cargarImagen("");
    }

    public static void sendWave(int n) {
        if (n + 1 >= 3) {
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
        }else{
            Map recursos = new HashMap<String, Integer>();
            recursos.put("uranio", 500);
            recursos.put("rodio", 500);
            recursos.put("grafeno", 500);
            recursos.put("radio", 500);
            recursos.put("cromo", 500);
            recursos.put("energia", 0);
            Jugador.agregaRecursos(recursos);
            int a[][]={
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
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
            Ventana_Mapa.cargar(m.getMapa());
            Ventana_Mapa.setMap(m);
            Juego.getJuego().changeScreen("FinFase2");
        }

    }
}
