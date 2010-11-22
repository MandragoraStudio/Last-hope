

package Observador;

import Mapa.Ventana_Mapa;
import Principal.Juego;
import Principal.MouseHandler;

/**
 *
 * @author Antonio Garcia
 */
public class Observador_Mapa implements IObservador {
private Ventana_Mapa mapa;
public Observador_Mapa(Ventana_Mapa m){
    mapa=m;
    mapa.attach(this);
}
    public void update(String comando) {
        if(mapa.construir){
            int x = MouseHandler.getX();
            int y = MouseHandler.getY();
            if(mapa.casillaValidaTorre(mapa.getCasilla(x,y))&&Juego.jugador.suficientesRecursos(mapa.torre.getCoste())){
                Juego.jugador.restaRecursos(mapa.torre.getCoste());
                mapa.torre.setPosicion(mapa.getCoordenadaCasilla(x, y));
                mapa.addTower(mapa.torre.clone());
                mapa.torre=null;
                mapa.construir=false;
            }
        }
    }

}
