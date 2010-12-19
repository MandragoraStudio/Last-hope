/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import Graficos.Abotonador;
import Graficos.Lienzo;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanar
 */
public class CajaRecurso extends Actor {
    public Map recursos;
    Abotonador boton;
    Vector2D destino;


    public CajaRecurso(Vector2D posicion, Map recursos, Vector2D destino){
        super(Lienzo.cargarImagen("imagenes/caja.png"),  posicion, 40, 40);
        this.recursos=recursos;
        this.destino = destino;
        try {
            boton = new Abotonador("Actor", 20, 20, this);
        } catch (Exception ex) {
            Logger.getLogger(CajaRecurso.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void update(){
        boton.update();
        posicion.x=posicion.x*0.4f+destino.x*0.6f;
        posicion.y=posicion.y*0.8f+destino.y*0.2f;
    }

    @Override
    public void draw(Graphics2D g){
        g.drawImage(imagen, (int)posicion.x,(int)posicion.y,20,20, null);
    }

}
