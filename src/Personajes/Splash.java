

package Personajes;

import Graficos.Lienzo;
import UtilMath.Vector2D;
import java.awt.Image;

/**
 *
 * @author Antonio Garcia
 */
public class Splash extends Actor{

    private static Image imagen=null;
    public Splash(Vector2D posicion){
        super(imagen,posicion,20);
        if(imagen==null){
            imagen=Lienzo.cargarImagen("imagenes/splash.png");
        }
        setImagen(imagen);
    }
    @Override
    public void update() {
    }

}
