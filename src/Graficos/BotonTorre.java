/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graficos;

import Handlers.MouseHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author usuario
 */
//extiende de boton y le añade la funcionalidad de que mientras está pulsado muestra otra imagen
public class BotonTorre extends Boton{
    Image down; //imagen cuando el boton esta pulsado

    public BotonTorre(Image up, Image down, String nombre, int x, int y, int width, int height) throws Exception {
        //inicializamos variables
        super( up, nombre, x, y, width, height);
        this.down = down;
        //comprobamos si las imagenes (up y down) tienen el mismo tamaño
        if(up.getWidth(null)!=down.getWidth(null)||up.getHeight(null)!=down.getHeight(null))
            throw new Exception("Ambas imagenes deben tener el mismo tamaño");

    }

    @Override
    public void draw(Graphics2D g) {
        //dibujamos el boton segun si esta pulsado o no
        Image im = pulsado ? down : up;
        g.drawImage(im, this.getX(), this.getY(), null);
    }
}
