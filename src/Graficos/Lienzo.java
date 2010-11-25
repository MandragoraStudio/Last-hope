/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graficos;

import UtilMath.Vector2D;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Thanar
 */
public class Lienzo extends Canvas {
    //adoptamos la estrategia del doble buffer para que no se vean los saltos
    public BufferStrategy strategy; 
    public JFrame frame; //ventana sobre la que pintaremos
    public JPanel panel; // subcontenido de la ventana
    public JPanel getPanel() {
        return panel;
    }

    public static Image cargarImagen(String url){
        Image i = null;
        try{
            i= ImageIO.read((new Vector2D(0,0)).getClass().getClassLoader().getResource(url));
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public Lienzo(int width, int height){
        frame = new JFrame("Last Hope");
        frame.setIconImage(Lienzo.cargarImagen("imagenes/mounstrillo.png"));

        panel = (JPanel) frame.getContentPane();
        frame.addWindowListener(new WindowAdapter(){
            @Override
                  public void windowClosing(WindowEvent we){
                    System.exit(0);
                  }
                });
        frame.setResizable(false);
        frame.setLayout(null);
        panel.setPreferredSize(new Dimension(width,height));
        panel.setLayout(null);

        setBounds(0,0,width,height);
        panel.add(this);
        setIgnoreRepaint(true);
        frame.pack();
        frame.setVisible(true);

        createBufferStrategy(2);
        strategy = this.getBufferStrategy();


    }
public JFrame getFrame(){
    return frame;
}
    @Override
    public void paint(Graphics g)
    {

    }

}
