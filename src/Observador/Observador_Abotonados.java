

package Observador;

import Graficos.Abotonador;
import Informacion.Ventana_Informacion;
import Personajes.Enemy;

/**
 *
 * @author Antonio Garcia
 */
public class Observador_Abotonados implements IObservador{
    private Abotonador sujeto;
    public Observador_Abotonados(Abotonador a){
        sujeto=a;
        sujeto.Atach(this);
    }
    public void update(String comando) {
        if(sujeto.sujeto instanceof Enemy){
            Enemy e = (Enemy)sujeto.sujeto;
            Ventana_Informacion.ac=e;
        }
    }


}
