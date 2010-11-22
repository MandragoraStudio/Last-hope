

package Observador;

import Graficos.Abotonador;
import Personajes.Actor;

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
        System.out.println("funciono!!!!!");
    }


}
