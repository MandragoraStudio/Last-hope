/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Jose
 */
public class ContenidoTorres extends Contenido{
    
    public ContenidoTorres(String url, int x, int y) {
        super(url, x, y);
    }
    
    @Override
    public void addBotonPorDefecto(Image up, String nombre, int width, int height) throws Exception{
        if(this.getBotones().size()<12){
            
            this.getBotones().add(new Boton(up, up, nombre, this.calculaX(), this.calculaY(), width, height));
        }
    }
    @Override
    public void draw(Graphics2D g){
        g.drawImage(this.getImagen(), this.getX(), this.getY(), null);

        for(Boton b: this.getBotones()){
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY()+b.getHeight()+12);
        }
    }
    @Override
    public int calculaX() {
        int pos = 0;
        int modulo = this.getBotones().size() % 3;
        if (this.getBotones().size() == 0) {
            pos = this.getX() + 31;
        } else {
            pos = super.getX() + (modulo * 81) + 31;
        }
        return pos;
    }

    @Override
    public int calculaY() {
        int pos = 0;
        int cociente = this.getBotones().size() / 3;
        if (this.getBotones().size() == 0) {
            pos = this.getY() + 31;
        } else {
            pos = this.getY() + (cociente * 81) + 31;
        }
        return pos;
    }

}
