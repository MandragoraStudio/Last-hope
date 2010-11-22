/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import Graficos.IVentana;
import Graficos.Lienzo;
import Principal.Juego;
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
    }


    public void update() {
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

        //Barra informacion derecha (Informacion)
        
    }

}
