/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Thanar
 */
public class Lienzo extends Canvas {
    public BufferStrategy strategy;
    JFrame frame;
    JPanel panel;
    public JPanel getPanel() {
        return panel;
    }

    public Lienzo(int width, int height){
        frame = new JFrame("Last Hope");

        panel = (JPanel) frame.getContentPane();
        frame.addWindowListener(new WindowAdapter(){
            @Override
                  public void windowClosing(WindowEvent we){
                    System.exit(0);
                  }
                });
        frame.setLayout(null);
        panel.setPreferredSize(new Dimension(width,height));
        panel.setLayout(null);

        setBounds(0,0,width,height);
        panel.add(this);
        setIgnoreRepaint(true);

        frame.pack();
        frame.setResizable(false);
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
