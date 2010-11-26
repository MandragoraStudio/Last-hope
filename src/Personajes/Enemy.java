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
    private float modVelocidad;
    private float tModVelocidad;
    private float fuerzaVeneno;
    private float tVeneno;
    private float fuerzaFuego;
    private float tFuego;
    private float armadura;
    private float regeneracion;
    private float tNoRegenerar;
    private Vector2D direccion = Vector2D.uno;
    private float vida;
    private float maxVida;
    private int dano;
    private int casilla;

    public void envenenar(float fuerza, float tiempo){
        fuerzaVeneno=fuerza;
        tVeneno=tiempo;
    }
    public void quemar(float fuerza, float tiempo){
        fuerzaFuego=fuerza;
        tFuego=tiempo;
        tNoRegenerar=4*tiempo;
    }
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

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
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
        this.maxVida=vida;
        this.dano = dano;
        this.armadura=armadura;
        this.regeneracion=regeneracion;
        this.posicion = posicion;
        this.modVelocidad=1;
        this.tModVelocidad=0;
        this.tNoRegenerar=-1;
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
            
            g.setTransform(at);
            g.drawImage(imagen, (int) posicion.x, (int) posicion.y, null);
            g.setTransform(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void congelar(float ralentizar, float tiempo){
        this.modVelocidad=ralentizar;
        tModVelocidad=tiempo;
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
        if(tModVelocidad<0){
            modVelocidad=1;
        }else{
            tModVelocidad--;
        }
        if(fuerzaVeneno>0&&tVeneno>0){
            vida-=fuerzaVeneno;
            tVeneno--;
        }
        if(tNoRegenerar<0){
            if(vida+this.regeneracion<maxVida){
                vida+=regeneracion;
            }else{
                vida=maxVida;
            }
        }else{
            tNoRegenerar--;
        }
        Vector2D destino = Ventana_Mapa.map.camino.get(casilla);
        direccion=Ventana_Mapa.getCoordenadaCentro((int)destino.x,(int)destino.y).subs(posicion);
        posicion = posicion.add(direccion.unitario().mult(velocidad*modVelocidad));
    }
}
