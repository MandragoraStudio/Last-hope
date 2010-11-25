/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import Enemigos.EBasico;
import Graficos.IVentana;
import Graficos.Lienzo;
import Personajes.Actor;
import Personajes.Enemy;
import Personajes.Tower;
import Principal.Juego;
import UtilMath.Vector2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Thanar
 */
public class Ventana_Informacion implements IVentana {

    private int WIDTH;
    private int HEIGHT;
    private int x;
    private int y;
    private Image infIzq;
    private Image infCtr;
    private Image infDr;
    Image brillo;

    //private Actor ac;
    //creado de prueba
    public static Actor ac=null;

    
    public Ventana_Informacion(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x=x;
        this.y=y;

        this.cargar();
    }

    public void cargar() {
       infIzq = Lienzo.cargarImagen("imagenes/informacionIzq.png");
       infCtr = Lienzo.cargarImagen("imagenes/informacionCtr.png");
       infDr = Lienzo.cargarImagen("imagenes/informacionDr.png");
       brillo = Lienzo.cargarImagen("imagenes/brillo.png");
    }


    public void update() {
    }

    public void obserbaActor(Actor ac){
        this.ac=ac;
    }

    public void draw(Graphics2D g) {

        //Cambiamos el tipo de letra
        g.setFont( new Font( "SansSerif", Font.BOLD, 12 ) );
        //Barra informacion imagenes de fondo
        g.drawImage(infIzq, x, y,null);
        g.drawImage(infCtr, x+100, y,null);
        g.drawImage(infDr, WIDTH-150, y,null);
        //Barra informacion Izquierda
        g.setColor(Color.WHITE);
        g.drawString("Puntuacion", x+25, y+20);
        g.drawString("Vida", x+25, y+60);
        g.setColor(Color.BLACK);
        g.drawString(""+Juego.jugador.getPuntuacion(), x+35, y+40);
        g.drawString(""+Juego.jugador.getVida()+"/"+Juego.jugador.getVidaMax(), x+32, y+78);
        //Barra informacion Centro (Atributos)
        g.drawString("Uranio",x+150, y+40);
        g.drawString(""+Juego.jugador.getRecursos().get("uranio"), x+150, y+70);
        g.drawString("Rodio",x+250, y+40);
        g.drawString(""+Juego.jugador.getRecursos().get("rodio"), x+250, y+70);
        g.drawString("Grafeno",x+350, y+40);
        g.drawString(""+Juego.jugador.getRecursos().get("grafeno"), x+350, y+70);
        g.drawString("Radio",x+450, y+40);
        g.drawString(""+Juego.jugador.getRecursos().get("radio"), x+450, y+70);
        g.drawString("Cromo",x+550, y+40);
        g.drawString(""+Juego.jugador.getRecursos().get("cromo"), x+550, y+70);
        g.drawString("Energia",x+650, y+40);
        g.drawString(""+Juego.jugador.getEnergia()+"/"+Juego.jugador.getEnergiaMax(), x+650, y+70);
        g.drawString("Oleada",x+750, y+40);
        g.drawString("??", x+750, y+70);
        //Barra informacion derecha (Informacion)
        if(ac==null){
            //TODO: esto hay que cambiarlo por una informacion vacia por defecto!!

            ac=new EBasico(1, new Vector2D(-100,-100));
        }
         g.drawImage(ac.getImagen(), x+967, y+40,null);
         if(ac instanceof Enemy){
            Enemy e =(Enemy)ac;
            g.drawString("Vida: "+e.getVida(), x+870, y+40);
            g.drawString("Armadura: "+e.getArmadura(), x+870, y+60);
            g.drawString("Daño: "+e.getDano(), x+870, y+80);
            //brillo al bicho
            //TODO: remarcar el bicho elegido
            g.drawImage(brillo,(int)ac.posicion.x-5, (int)ac.posicion.y-5,null);
            if(e.getVida()<0){
                ac=null;
                
            }
         }else if (ac instanceof Tower){
            Tower t = (Tower)ac;
            g.drawString("Ataque: "+t.getAtaque(), x+900, y+40);
            g.drawString("Alcanze: "+t.getRango(), x+900, y+60);
            g.drawString("Velocidad: "+t.getRecarga(), x+900, y+70);
         }
        
    }

}
