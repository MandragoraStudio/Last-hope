/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Graficos.Lienzo;
import Mapa.Ventana_Mapa;
import Principal.Juego;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Jose
 */
public abstract class Enemy extends Actor {

    private int id;
    private float velocidad;
    private float armadura;
    private float regeneracion;
    private Vector2D direccion = Vector2D.uno;
    private float vida;
    private int dano;
    private int casilla;

    public float getArmadura() {
        return armadura;
    }

    public void quitaVida(float n){
        vida-=n;
    }

    public int getDano() {
        return dano;
    }

    public Vector2D getDireccion() {
        return direccion;
    }

    public int getId() {
        return id;
    }

    public float getRegeneracion() {
        return regeneracion;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public Enemy(int id, float velocidad, float vida, int dano, float armadura,float regeneracion, Vector2D posicion, String imagen) {
        super(Lienzo.cargarImagen(imagen), posicion);
        this.id = id;
        this.velocidad = velocidad;
        this.vida = vida;
        this.dano = dano;
        this.armadura=armadura;
        this.regeneracion=regeneracion;
        this.posicion = posicion;
    }

    public int getCasilla() {
        return casilla;
    }

    @Override
    public void draw(Graphics2D g) {
        try {
            AffineTransform at = new AffineTransform();
            AffineTransform temp = g.getTransform();
            at.rotate(-direccion.getAngle() + Math.toRadians(180), posicion.x + imagen.getWidth(null)/2, posicion.y + imagen.getHeight(null)/2);
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
        boton.update();
        if(vida<0){
            //aqui el enemigo muere!!!
                Ventana_Mapa.eliminaActor(this);
                Ventana_Mapa.agregar.add(new Splash(posicion));
                Juego.jugador.agregaPuntos(this.dano);
            }
        if(Ventana_Mapa.getCasilla((int)posicion.x, (int)posicion.y).equals(Ventana_Mapa.map.camino.get(casilla)) ){
              casilla++;
        }
        if(casilla>=Ventana_Mapa.map.camino.size()){
            casilla=0;
            posicion=new Vector2D(-Ventana_Mapa.casillaWidth,-Ventana_Mapa.casillaHeight);
            Juego.jugador.restaVida(dano);
        }
        Vector2D destino = Ventana_Mapa.map.camino.get(casilla);
        //direccion=posicion.subs(Ventana_Mapa.getCoordenadaCentro((int)destino.x,(int)destino.y));
        direccion=Ventana_Mapa.getCoordenadaCentro((int)destino.x,(int)destino.y).subs(posicion);
        posicion = posicion.add(direccion.unitario().mult(velocidad));
    }
}
