/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import Graficos.Lienzo;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class ContenidoTorres extends Contenido{
    
    public ContenidoTorres(String url, Vector2D posicion){
        super(url, posicion);
        Image img6;
        try {
            //cargamos el boton que lleva al menu
            img6 = Lienzo.cargarImagen("imagenes/imagenpro.png");
            Image img7 = Lienzo.cargarImagen("imagenes/imagenpro2.png");
            addBoton(img6, img7, "Menu", getImagen().getWidth(null)-img6.getWidth(null), getImagen().getHeight(null)-img6.getHeight(null));

        } catch (Exception ex) {
            Logger.getLogger(ContenidoTorres.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
    @Override
    //sobreescribimos el metodo para asegurarnos de que solo se creen 12 botones como máximo
    public void addBotonPorDefecto(Boton b) throws Exception{
        if(this.getBotonesPorDefecto().size()<12){
            
            this.getBotonesPorDefecto().add(b);
        }
    }
    @Override
    public void draw(Graphics2D g){
        //dibujamos el fondo
        g.drawImage(this.getImagen(), (int)posicion.x, (int)posicion.y, null);
        // dibujamos los botones por defecto (los que crean torres)
        for(Boton b: this.getBotonesPorDefecto()){
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY()+b.getHeight()+12);
        }
        //dibujamos el resto de botones
        for(Boton b: this.getBotones()){
            b.draw(g);
        }
    }
    @Override
    //metodo que calcula la posicion X del proximo boton por defecto
    public int calculaX() {
        int pos = 0;
        int modulo = this.getBotonesPorDefecto().size() % 3;
        if (this.getBotonesPorDefecto().size() == 0) {
            pos = (int)posicion.x + 31;
        } else {
            pos = (int)posicion.x + (modulo * 81) + 31;
        }
        return pos;
    }

    @Override
    //metodo que calcula la posicion Y del proximo boton por defecto
    public int calculaY() {
        int pos = 0;
        int cociente = this.getBotonesPorDefecto().size() / 3;
        if (this.getBotonesPorDefecto().size() == 0) {
            pos = (int)posicion.y + 66;
        } else {
            pos = (int)posicion.y + (cociente * 81) + 66;
        }
        return pos;
    }

}
