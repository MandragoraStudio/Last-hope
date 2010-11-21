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

/**
 *
 * @author Thanar
 */
public class Ventana_Informacion implements IVentana {

    private int WIDTH;
    private int HEIGHT;
    private int x;
    private int y;
    
    public Ventana_Informacion(int WIDTH, int HEIGHT, int x, int y) {
        //los parametros magicos
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x=x;
        this.y=y;
        this.cargar();
    }

    public void cargar() {
       Lienzo.cargarImagen("a");
    }


    public void update() {
    }

    public void draw(Graphics2D g) {
        
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.GRAY);
        g.fillRect(x,y, 100+x,HEIGHT);
        g.fillRect(WIDTH-150,y, WIDTH,HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont( new Font( "SansSerif", Font.BOLD, 12 ) );
        g.drawString("Puntuacion", x+20, y+20);
        g.drawString(""+Juego.jugador.getPuntuacion(), x+20, y+35);
        g.drawString("Vida", x+20, y+55);
        g.drawString(""+Juego.jugador.getVida()+"/"+Juego.jugador.getVidaMax(), x+20, y+70);

        //codigo de la ventana a partir de aqui
        
    }

}
