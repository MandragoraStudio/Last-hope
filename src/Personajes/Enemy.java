/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Graficos.Lienzo;
import Informacion.Ventana_Informacion;
import Mapa.Ventana_Mapa;
import Principal.Juego;
import Principal.Jugador;
import UtilMath.Vector2D;
import java.util.HashMap;
import java.util.Map;

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
    Vector2D destino;

    public void envenenar(float fuerza, float tiempo) {
        fuerzaVeneno = fuerza;
        tVeneno = tiempo;
    }

    public void quemar(float fuerza, float tiempo) {
        fuerzaFuego = fuerza;
        tFuego = tiempo;
        tNoRegenerar = 4 * tiempo;
    }

    public float getArmadura() {
        return armadura;
    }

    public void quitaVida(float n) {
        vida -= n;
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

    public Enemy(int id, float velocidad, float vida, int dano, float armadura, float regeneracion, Vector2D posicion, String imagen, int width) {
        super(Lienzo.cargarImagen(imagen), posicion, width, 50);
        this.id = id;
        this.velocidad = velocidad;
        this.vida = vida;
        this.maxVida = vida;
        this.dano = dano;
        this.armadura = armadura;
        this.regeneracion = regeneracion;
        this.posicion = posicion;
        this.modVelocidad = 1;
        this.tModVelocidad = 0;
        this.tNoRegenerar = -1;
    }

    public int getCasilla() {
        return casilla;
    }

    public void congelar(float ralentizar, float tiempo) {
        this.modVelocidad = ralentizar;
        tModVelocidad = tiempo;
    }

    public Vector2D centro() {
        float x = posicion.x;
        float y = posicion.y;
        x += this.width / 2.0f;
        y += this.height / 2.0f;
        return new Vector2D(x, y);
    }

    public void muere() {
        Ventana_Mapa.eliminaActor(this);
        Ventana_Mapa.agregar.add(new Splash(this.centro()));
        Juego.jugador.agregaPuntos(this.dano);
        //recursos que le vas a dar al jugador
        //TODO: dar recursos al jugador en funcion de las caracteristicas del enemigo, de manera proporcionada
        Map<String,Integer> recursos = new HashMap<String,Integer>();
        recursos.put("uranio", (int)this.maxVida);
        recursos.put("rodio", (int)this.regeneracion);
        recursos.put("grafeno", (int)this.velocidad);
        recursos.put("radio", (int)this.armadura+this.dano);
        recursos.put("cromo", (int)this.armadura);
        Jugador.agregaRecursos(recursos);
    }

    @Override
    public void update() {

        boton.update();
        if (vida < 0) {
            //aqui el enemigo muere!!!
            this.muere();
        }
        if (this.centro().subs(Ventana_Mapa.getCoordenadaCentro(Ventana_Mapa.map.camino.get(casilla))).modulo() <= this.velocidad) {

            casilla++;
        }
        if (casilla >= Ventana_Mapa.map.camino.size()) {
            casilla = 0;
            posicion = new Vector2D(-Ventana_Mapa.casillaWidth, -Ventana_Mapa.casillaHeight);
            //elimino al actor que lo dice jose
            Ventana_Mapa.eliminaActor(this);
            if (!Juego.jugador.restaVida(dano)) {
                Ventana_Informacion.ac=null;
                Juego.changeScreen("GameOver");
                Juego.restartGame();
            }
        }
        if (tModVelocidad < 0) {
            //aqui ya no me ralentizo
            modVelocidad = 1;
        } else {
            //seguramente este ralentizado
            tModVelocidad--;
        }
        if (fuerzaVeneno > 0 && tVeneno > 0) {
            //estoy envenenado
            vida -= fuerzaVeneno;
            tVeneno--;
        }
        if (tNoRegenerar < 0) {
            //me puedo regenerar
            if (vida + this.regeneracion < maxVida) {
                vida += regeneracion;
            } else {
                vida = maxVida;
            }
        } else {
            //no me puedo regenear
            tNoRegenerar--;
        }
        destino = Ventana_Mapa.map.camino.get(casilla);
        direccion = Ventana_Mapa.getCoordenadaCentro((int) destino.x, (int) destino.y).subs(centro());
        this.posicion = posicion.add(direccion.unitario().mult(velocidad * modVelocidad));
        rotation = direccion.getAngle() + (float) Math.toRadians(180);
    }
}
