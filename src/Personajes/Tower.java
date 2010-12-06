/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Mapa.Ventana_Mapa;
import Principal.Globals;
import java.awt.Image;
import UtilMath.Vector2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jose
 */
public class Tower extends Actor {

    private float ataque;
    private float areaDeAtaque;
    private float rango;
    private float congelacion;
    private float penetracion;
    private float fuego;
    private long recarga;
    private float veneno;
    private Image im;
    private int atacando = 0;
    private long tRestante;
    private Enemy objetivo;
    private Map<String, Integer> coste;

    public Tower(float ataque, float areaDeAtaque, float rango, float congelacion, float penetracion, float fuego, long recarga, float veneno, Map<String, Integer> coste, Vector2D posicion, Image ima) {
        super(ima, posicion,null);
        this.ataque = ataque;
        this.areaDeAtaque = areaDeAtaque;
        this.rango = rango;
        this.congelacion = congelacion;
        this.penetracion = penetracion;
        this.fuego = fuego;
        this.recarga = recarga;
        this.veneno = veneno;
        this.im = ima;
        this.coste = coste;
        tRestante = 0;
    }

    @Override
    public void update() {
        boton.update();
        if (tRestante >= 0) {
            tRestante -= Globals.elapsedTime;
            
        }
        if (enemigoATiro() && isCargada()) {
            ataca(eligeEnemigo(enemigosATiro()), true);
        }
        if (objetivo != null) {
            if (this.estaAlAlcance(objetivo.posicion)) {
                rotation = posicion.subs(objetivo.posicion).getAngle();


            }
            
        }
    }

    public void ataca(Enemy e, boolean extenderAtaque) {
        if (e == null) {
            return;
        }
        atacando = 5;
        objetivo = e;
        if (ataque > 0) {
            float d = ataque - Math.max(0, e.getArmadura() - this.penetracion);
            if (d < 1) {
                d = 1;
            }
            e.quitaVida(d);

        }
        if (congelacion > 0) {
            e.congelar(10 / (congelacion + 10), 45);
        }
        if (veneno > 0) {
            e.envenenar(veneno / 60, 60);
        }
        if (fuego > 0) {
            e.envenenar(veneno / 60, 60);
        }
        if (extenderAtaque && this.areaDeAtaque > 0) {
            for (Enemy enemigo : enemigosAfectados(e)) {
                ataca(enemigo, false);
            }
        }
        tRestante = this.recarga;

    }

    public List<Enemy> enemigosATiro() {
        List<Enemy> dev = new LinkedList<Enemy>();
        for (Actor a : Ventana_Mapa.actores) {
            if (a instanceof Enemy) {
                Enemy e = (Enemy) a;
                if (estaAlAlcance(e.posicion.add(new Vector2D(e.width/2.0f,e.height/2.0f)))) {
                    dev.add(e);
                }
            }
        }
        return dev;
    }

    public List<Enemy> enemigosAfectados(Enemy e) {
        List<Enemy> dev = new LinkedList<Enemy>();
        for (Actor a : Ventana_Mapa.actores) {
            if (a instanceof Enemy) {
                Enemy obj = (Enemy) a;
                if (!obj.equals(e)) {
                    if (e.posicion.subs(obj.posicion).modulo() < this.areaDeAtaque) {
                        dev.add(obj);
                    }
                }
            }
        }
        return dev;
    }

    public Enemy eligeEnemigo(List<Enemy> enemigos) {
        Enemy dev = null;
        if (enemigos.size() > 0) {
            dev = enemigos.get(0);
        }
        for (Enemy e : enemigos) {
            if (e.getCasilla() > dev.getCasilla()) {
                dev = e;
            }
        }
        return dev;
    }

    public boolean enemigoATiro() {
        boolean dev = false;
        for (Actor a : Ventana_Mapa.actores) {
            if (a instanceof Enemy) {
                if (estaAlAlcance(a.posicion)) {
                    dev = true;
                    break;
                }
            }
        }
        return dev;
    }

    public boolean estaAlAlcance(Vector2D destino) {
        return destino.subs(posicion).modulo() < rango;

        //return destino.subs(posicion.add(new Vector2D(this.width/2.0f,this.height/2.0f))).modulo() < rango;
    }

    public boolean isCargada() {
        boolean dev;
        dev = tRestante < 0;
        return dev;
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        Color c = g.getColor();
        g.setColor(new Color(0.7f, 0.5f, 0.5f, 0.8f));
        //g.fillRect((int) posicion.x, (int) posicion.y, Ventana_Mapa.casillaWidth, Ventana_Mapa.casillaHeight);
        if (atacando > 0 && estaAlAlcance(objetivo.posicion)) {
            g.setColor(Color.red);

            g.drawLine((int) objetivo.posicion.x + objetivo.getImagen().getWidth(null) / 2, (int) objetivo.posicion.y + objetivo.getImagen().getHeight(null) / 2, (int) posicion.x + Ventana_Mapa.casillaWidth / 2, (int) posicion.y + Ventana_Mapa.casillaHeight / 2);
            atacando--;
        }
        g.setColor(Color.black);
        //g.drawString("trecarga " + tRecarga, posicion.x, posicion.y + Ventana_Mapa.casillaHeight / 2);
        //g.drawString("aqui va una torre", posicion.x, posicion.y+Ventana_Mapa.casillaHeight/2);


        g.setColor(c);
    }

    public float getAreaDeAtaque() {
        return areaDeAtaque;
    }

    public float getAtaque() {
        return ataque;
    }

    public float getCongelacion() {
        return congelacion;
    }

    public Map<String, Integer> getCoste() {
        return coste;
    }

    public float getFuego() {
        return fuego;
    }

    public Image getIm() {
        return im;
    }

    public Enemy getObjetivo() {
        return objetivo;
    }

    public float getPenetracion() {
        return penetracion;
    }

    public float getRango() {
        return rango;
    }

    public long getRecarga() {
        return recarga;
    }

    public float getVeneno() {
        return veneno;
    }

    public void setAreaDeAtaque(float areaDeAtaque) {
        this.areaDeAtaque = areaDeAtaque;
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public void setCongelacion(float congelacion) {
        this.congelacion = congelacion;
    }

    public void setFuego(float fuego) {
        this.fuego = fuego;
    }

    public void setIm(Image im) {
        this.im = im;
    }

    public void setObjetivo(Enemy objetivo) {
        this.objetivo = objetivo;
    }

    public void setPenetracion(float penetracion) {
        this.penetracion = penetracion;
    }

    public void setRango(float rango) {
        this.rango = rango;
    }

    public void setRecarga(long recarga) {
        this.recarga = recarga;
    }

    public void setVeneno(float veneno) {
        this.veneno = veneno;
    }

    public void dispara() {
    }

    public Tower clone() {
        Tower dev;
        Vector2D posicion = new Vector2D(this.posicion.x, this.posicion.y);
        Image ima = im;
        dev = new Tower(ataque, areaDeAtaque, rango, congelacion, penetracion, fuego, recarga, veneno, coste, posicion, ima);
        return dev;
    }

    public void rotarTorre(int x, int y) {
    }
}
