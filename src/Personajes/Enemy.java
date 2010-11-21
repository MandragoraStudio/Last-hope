/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Graficos.Lienzo;
import Mapa.Ventana_Mapa;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Jose
 */
public class Enemy extends Actor {

    private int id;
    private float velocidad;
    private Vector2D direccion = Vector2D.uno;
    private float vida;
    private int peso;
    private int casilla;

    public Enemy(int id, float velocidad, float vida, int peso, Vector2D posicion, String imagen) {
        super(Lienzo.cargarImagen(imagen), posicion);
        this.id = id;
        this.velocidad = velocidad;
        this.vida = vida;
        this.peso = peso;
        this.posicion = posicion;
    }

    @Override
    public void draw(Graphics2D g) {
        try {
            AffineTransform at = new AffineTransform();
            AffineTransform temp = g.getTransform();
            at.rotate(-direccion.getAngle() + Math.toRadians(180), posicion.x + 2, posicion.y + 2);
            //at.rotate(Math.toRadians(315), posicion.x+2, posicion.y+2);
            g.setTransform(at);
            g.drawImage(imagen, (int) posicion.x, (int) posicion.y, null);
            g.setTransform(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if(Ventana_Mapa.getCasilla((int)posicion.x, (int)posicion.y).equals(Ventana_Mapa.map.camino.get(casilla)) ){
              casilla++;
        }
        Vector2D destino = Ventana_Mapa.map.camino.get(casilla);
        //direccion=posicion.subs(Ventana_Mapa.getCoordenadaCentro((int)destino.x,(int)destino.y));
        direccion=Ventana_Mapa.getCoordenadaCentro((int)destino.x,(int)destino.y).subs(posicion);
        posicion = posicion.add(direccion.unitario().mult(velocidad));
    }
}
