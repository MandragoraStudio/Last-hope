

package Graficos;

import Observador.Observador_Abotonados;
import Personajes.Actor;
import Handlers.MouseHandler;
import java.awt.Graphics2D;

/**
 *
 * @author Antonio Garcia
 */
public class Abotonador extends Boton {
    public Actor sujeto; // sujeto al que nos vamos a referir
    public Abotonador(String nombre,  int width, int height, Actor sujeto) throws Exception {
        //inicializamos los atributos de Abotonador
        super(null, nombre,(int)sujeto.posicion.x,(int)sujeto.posicion.y,  width,  height);
        this.sujeto=sujeto;
        //le creamos un observador
        new Observador_Abotonados(this);
    }
    @Override
    public void draw(Graphics2D g) {
        //g.drawImage(up, x, y, width, height, null);
    }

    @Override
    public void update() {
        //redefinimos update para indicarle que el boton se va a ir moviendo a lo largo de la pantalla
        x=(int)sujeto.posicion.x;
        y=(int)sujeto.posicion.y;
        if (MouseHandler.isPulsado()) {
            if (MouseHandler.getX() > x && MouseHandler.getX() < x + width && MouseHandler.getY() > y && MouseHandler.getY() < y + height) {
                pulsado = true;
            }
        } else {
            if (MouseHandler.getX() > x && MouseHandler.getX() < x + width && MouseHandler.getY() > y && MouseHandler.getY() < y + height) {
                if (pulsado) {
                    this.presionado();
                }
            }
            pulsado = false;
        }
    }

}
