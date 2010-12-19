

package Observador;

import Graficos.Abotonador;
import Informacion.Ventana_Informacion;
import Mapa.Ventana_Mapa;
import Personajes.CajaRecurso;
import Personajes.Enemy;
import Personajes.Tower;
import Principal.Jugador;

/**
 *
 * @author Antonio Garcia
 */
public class Observador_Abotonados implements IObservador{
    private Abotonador sujeto;
    public Observador_Abotonados(Abotonador a){
        sujeto=a;
        sujeto.setObservador(this);
    }
    public void update() {
        if(sujeto.sujeto instanceof Enemy || sujeto.sujeto instanceof Tower){
            Ventana_Informacion.ac=sujeto.sujeto;
        }
        if(sujeto.sujeto instanceof CajaRecurso){
            CajaRecurso c =(CajaRecurso) sujeto.sujeto;
            Jugador.agregaRecursos(c.recursos);
            Ventana_Mapa.eliminar.add(c);
        }
    }


}
