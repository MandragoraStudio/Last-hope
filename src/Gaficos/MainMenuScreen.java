/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gaficos;

import Personajes.Actor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Thanar
 */
public class MainMenuScreen implements IScreen {
Actor Fondo;
List<Boton> botones;

    public void cargarModelos() {
        Fondo = new Fondo("imagenes/fondo.png");
        botones=new ArrayList<Boton>();
        Image img=null;
        Image img2=null;
        try{
            img = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro.png"));
            img2 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro2.png"));
        }catch(Exception e){}
        
        botones.add(new Boton(img,img2,"boton",100,100,img.getHeight(null),img.getWidth(null)));
    }

    public void update() {
        for(Boton b: this.botones){
            b.update();
        }
    }

    public void draw(Graphics2D g) {
        Fondo.draw(g);
        for(Boton b:botones){
            b.draw(g);
        }
    }

}
