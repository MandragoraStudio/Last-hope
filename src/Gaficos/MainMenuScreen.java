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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Thanar
 */
public class MainMenuScreen implements IScreen {
Actor Fondo;
List<Boton> botones;

    public void cargarModelos() {
        try {
            Fondo = new Fondo("imagenes/fondo.png");
            botones = new ArrayList<Boton>();
            Image img = null;
            Image img2 = null;
            try {
                img = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro.png"));
                img2 = ImageIO.read(this.getClass().getClassLoader().getResource("imagenes/imagenpro2.png"));
            } catch (Exception e) {
            }
            botones.add(new Boton(img, img2, "boton", 100, 100, img.getWidth(null), img.getHeight(null)));
        } catch (Exception ex) {
            Logger.getLogger(MainMenuScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {
        for(Boton b:botones){
            b.update();
        }
        //esto pa boton update
        String comando;
        for(Boton b:botones){
            if(b.ejecutar){
                comando=b.getNombre();
                if(comando.equals("boton")){
                    System.out.println("PROOOOOEEEEZZ");
                }
                b.ejecutar=false;
            }
        }
    }

    public void draw(Graphics2D g) {
        Fondo.draw(g);
        for(Boton b:botones){
            //esto pa boton update
            b.draw(g);
        }
    }

}
