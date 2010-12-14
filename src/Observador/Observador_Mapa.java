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

    public Observador_Mapa(Ventana_Mapa m) {
        mapa = m;
        mapa.attach(this);
    }

    public void update() {
        Ventana_Informacion.ac = null;
        if (mapa.isConstruir()) {
            int x = MouseHandler.getX();
            int y = MouseHandler.getY();
            if (mapa.casillaValidaConstruir(mapa.getCasilla(x, y)) && Juego.getJuego().jugador.suficientesRecursos(mapa.getTorre().getCoste())) {
                Juego.getJuego().jugador.restaRecursos(mapa.getTorre().getCoste());
                mapa.getTorre().setPosicion(mapa.getCoordenadaCasilla(x, y));
                mapa.addTower(mapa.getTorre().clone());
                mapa.setTorre(null);
                mapa.setConstruir(false);
            }
        } else if (mapa.isConstruirH()) {
                int x = MouseHandler.getX();
                int y = MouseHandler.getY();
                if (mapa.casillaValidaConstruir(mapa.getCasilla(x, y)) && Juego.getJuego().jugador.suficientesRecursos(mapa.getHabilidad().getCoste())) {
                    Juego.getJuego().jugador.restaRecursos(mapa.getHabilidad().getCoste());
                    mapa.getHabilidad().setPosicion(mapa.getCoordenadaCasilla(x, y));
                    mapa.addHabilidad(mapa.getHabilidad().clone());
                    mapa.setHabilidad(null);
                    mapa.setConstruirH(false);
                }
        }

    }
}
