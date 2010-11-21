/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

import Graficos.Boton;
import UtilMath.Vector2D;
import java.awt.Graphics2D;

/**
 *
 * @author Jose
 */
public class ContenidoTorres extends Contenido{
    
    public ContenidoTorres(String url, Vector2D posicion){
        super(url, posicion);
    }
    
    @Override
    public void addBotonPorDefecto(Boton b) throws Exception{
        if(this.getBotonesPorDefecto().size()<12){
            
            this.getBotonesPorDefecto().add(b);
        }
    }
    @Override
    public void draw(Graphics2D g){
        g.drawImage(this.getImagen(), (int)posicion.x, (int)posicion.y, null);

        for(Boton b: this.getBotonesPorDefecto()){
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY()+b.getHeight()+12);
        }
        for(Boton b: this.getBotones()){
            b.draw(g);
        }
    }
    @Override
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
