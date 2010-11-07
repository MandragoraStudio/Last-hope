/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import Gaficos.Lienzo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Thanar
 */
public class MouseHandler {

    private static boolean pulsado;
    private static int x,y;



    public MouseHandler(Lienzo l){
        l.getFrame().addMouseListener( new MouseAdapter() {
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
        l.getPanel().addMouseListener( new MouseAdapter() {
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

    private static void mouseExited(MouseEvent e) {
        pulsado = false;
    }

    private static void mousePressed(MouseEvent e) {
        pulsado=true;
        x=e.getX();
        y=e.getY();
    }

    private static void mouseClicked(MouseEvent e) {
    }

    private static void mouseReleased(MouseEvent e) {
        pulsado=false;
        x=e.getX();
        y=e.getY();
    }

    private static void mouseEntered(MouseEvent e) {
    }

}
