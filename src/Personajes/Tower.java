/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Personajes;

import Mapa.Ventana_Mapa;
import java.awt.Image;
import UtilMath.Vector2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Jose
 */
public class Tower extends Actor{

    private int id;
    private float ataque;
    private int area;
    private float alcance;
    private float ralentizacion;
    private long ultimoDisparo;
    private long tRecarga;
    private float dañoPasivo;
    private float coste;
    private Image im;

    public Tower(int id, float ataque, int area, float alcance, float ralentizacion, long tRecarga, float dañoPasivo, float coste, Vector2D posicion, Image im) {
        super(null,posicion);
        this.id = id;
        this.ataque = ataque;
        this.area = area;
        this.alcance=alcance;
        this.ralentizacion = ralentizacion;
        this.ultimoDisparo = System.currentTimeMillis();
        this.tRecarga = tRecarga;
        this.dañoPasivo = dañoPasivo;
        this.coste = coste;

        this.im = im;


    }
    

    @Override
    public void update() {
        if(enemigoATiro()&&isCargada()){
            ataca(eligeEnemigo(enemigosATiro()));
        }
    }
    public void ataca(Enemy e){
        
    }
    public List<Enemy> enemigosATiro(){
        List<Enemy> dev=new LinkedList<Enemy>();
        for(Actor a : Ventana_Mapa.actores){
            if(a instanceof Enemy){
                Enemy e = (Enemy)a;
                if(estaAlAlcance(e.posicion)){
                    dev.add(e);
                }
            }
        }
        return dev;
    }
    public Enemy eligeEnemigo(List<Enemy> enemigos){
        Enemy dev = enemigos.get(0);
        for(Enemy e: enemigos){
            if(e.getCasilla()>dev.getCasilla()){
                dev=e;
            }
        }
        return dev;
    }
    public boolean enemigoATiro(){
        boolean dev=false;
        for(Actor a:Ventana_Mapa.actores){
            if(estaAlAlcance(a.posicion)){
                dev=true;
                break;
            }
        }
        return dev;
    }
    public boolean estaAlAlcance(Vector2D destino){
        return destino.subs(posicion).modulo()<alcance;
    }
    public boolean isCargada(){
        boolean dev;
        dev=System.currentTimeMillis()- ultimoDisparo>tRecarga;
        return dev;
    }

    @Override
    public void draw(Graphics2D g){
        Color c = g.getColor();
        g.setColor(new Color(0.7f,0.5f,0.5f,0.8f));
        g.fillRect((int)posicion.x, (int)posicion.y, Ventana_Mapa.casillaWidth, Ventana_Mapa.casillaHeight);
        g.drawImage(imagen, (int)posicion.x, (int)posicion.y, null);
        
        //g.setColor(Color.black);
        //g.drawString("aqui va una torre", posicion.x, posicion.y+Ventana_Mapa.casillaHeight/2);


        g.setColor(c);
    }

    public Vector2D getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2D posicion) {
        this.posicion = posicion;
    }

    public void dispara(){

    }

    public Tower clone(){
        Tower dev;
        Vector2D posicion = new Vector2D (this.posicion.x,this.posicion.y);
        Image ima = im;
        dev= new Tower(id, ataque, area, ralentizacion, ultimoDisparo, tRecarga, dañoPasivo, coste, posicion, ima);
        return dev;
    }

    public void rotarTorre(int x, int y){

    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public float getAtaque() {
        return ataque;
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    public float getDañoPasivo() {
        return dañoPasivo;
    }

    public void setDañoPasivo(float dañoPasivo) {
        this.dañoPasivo = dañoPasivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }

    public float getRalentizacion() {
        return ralentizacion;
    }

    public void setRalentizacion(float ralentizacion) {
        this.ralentizacion = ralentizacion;
    }

    public float gettRecarga() {
        return tRecarga;
    }

    public void settRecarga(long tRecarga) {
        this.tRecarga = tRecarga;
    }

    public float getUltimoDisparo() {
        return ultimoDisparo;
    }

   /* public void setUltimoDisparo(long ultimoDisparo) {
        this.ultimoDisparo = ultimoDisparo;
    }*/


}
