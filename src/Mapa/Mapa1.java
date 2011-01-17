package Mapa;

import Enemigos.EBasico;
import Enemigos.EJefeBasico;
import Enemigos.EMaster;
import Enemigos.ERapido;
import Enemigos.ETerminator;
import Principal.Juego;
import UtilMath.Vector2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thanar
 */
public class Mapa1 extends Mapa {

    public Mapa1(int[][] map) {
        super(map);
        this.id=1;
    }

    public void sendWave(int n) {
        if (n + 1 <= 6) {
            if (n%1==0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new EBasico(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n%2 == 0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new ERapido(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n %3 == 0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new EMaster(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n %4 == 0) {
                for (int i = 0; i < 10; i++) {
                    Ventana_Mapa.addEnemy(new ETerminator(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }if (n %5 == 0) {
                for (int i = 0; i < 5; i++) {
                    Ventana_Mapa.addEnemy(new EJefeBasico(n, new Vector2D(10, (int) (-Ventana_Mapa.casillaWidth * 1.3 * i))));
                }
            }
        } else {
            Map recursos = new HashMap<String, Integer>();
            recursos.put("uranio", 100);
            recursos.put("rodio", 100);
            recursos.put("grafeno", 100);
            recursos.put("radio", 100);
            recursos.put("cromo", 100);
            recursos.put("energia", 0);
            Juego.getJuego().jugador.agregaRecursos(recursos);
            int a[][] = {
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};
            Mapa2 m = new Mapa2(a);
            Ventana_Mapa.setMap(m);
            Juego.getJuego().changeScreen("FinFase1");
        }
    }
}
