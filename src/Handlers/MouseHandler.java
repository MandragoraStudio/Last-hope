/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Handlers;

import Graficos.Lienzo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Thanar
 */
public class MouseHandler {

    private static boolean pulsado; //variable que controla si se ha pulsado o no el raton
    private static int x,y; //coordenadas de donde se pulsa



    public MouseHandler(Lienzo l){
        l.addMouseListener( new MouseAdapter() {
	public void mousePressed(MouseEvent e){
	MouseHandler.mousePressed(e);
	}
	public void mouseClicked(MouseEvent e){
	MouseHandler.mouseClicked(e);
	}
	public void mouseReleased(MouseEvent e){
	MouseHandler.mouseReleased(e);
	}
	public void mouseEntered(MouseEvent e){
	MouseHandler.mouseEntered(e);
	}
	public void mouseExited(MouseEvent e){
	MouseHandler.mouseExited(e);
	}

	});
    }
    public static boolean isPulsado() {
        return pulsado;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    //este metodo se ejecuta cuando el raton sale de la pantalla
    private static void mouseExited(MouseEvent e) {
        
    }
    //este metodo se ejecuta cuando el raton es presionado
    private static void mousePressed(MouseEvent e) {
        pulsado = true;
        x=e.getX();
        y=e.getY();
    }
    //este metodo se ejecuta cuando el raton se presiona y se suelta
    private static void mouseClicked(MouseEvent e) {
    }
    //este metodo se ejecuta cuando el raton deja de estar presionado
    private static void mouseReleased(MouseEvent e) {
        pulsado = false;
        x=e.getX();
        y=e.getY();
    }
    //este metodo se ejecuta cuando el raton entra de la pantalla
    private static void mouseEntered(MouseEvent e) {
    }

    public static void setPulsado(boolean pulsado) {
        MouseHandler.pulsado = pulsado;
    }

    public static void setX(int x) {
        MouseHandler.x = x;
    }

    public static void setY(int y) {
        MouseHandler.y = y;
    }


}
