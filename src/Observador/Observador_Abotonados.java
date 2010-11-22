

package Observador;

import Graficos.Abotonador;
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
        System.out.println("funciono!!!!!");
        if(sujeto.sujeto instanceof Enemy){
            Enemy e = (Enemy)sujeto.sujeto;
            e.setVelocidad(e.getVelocidad()*1.5f);
        }
    }


}
