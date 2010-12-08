

package Observador;

import Mapa.Ventana_Mapa;
import Principal.Juego;
import Handlers.MouseHandler;
import Informacion.Ventana_Informacion;

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
    public void update() {
        Ventana_Informacion.ac=null;
        if(mapa.construir){
            int x = MouseHandler.getX();
            int y = MouseHandler.getY();
            if(mapa.casillaValidaConstruir(mapa.getCasilla(x,y))&&Juego.jugador.suficientesRecursos(mapa.torre.getCoste())){
                Juego.jugador.restaRecursos(mapa.torre.getCoste());
                mapa.torre.setPosicion(mapa.getCoordenadaCasilla(x, y));
                mapa.addTower(mapa.torre.clone());
                mapa.torre=null;
                mapa.construir=false;
            }
        }else if(mapa.construirH){
            int x = MouseHandler.getX();
            int y = MouseHandler.getY();
            if(mapa.casillaValidaConstruir(mapa.getCasilla(x,y))&&Juego.jugador.suficientesRecursos(mapa.habilidad.getCoste())){
                Juego.jugador.restaRecursos(mapa.habilidad.getCoste());
                mapa.habilidad.setPosicion(mapa.getCoordenadaCasilla(x, y));
                mapa.addHabilidad(mapa.habilidad.clone());
                mapa.habilidad=null;
                mapa.construirH=false;
            }
        }
    }

}
