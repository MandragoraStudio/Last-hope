/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Panel;

/**
 *
 * @author Jose
 */
public class ContenidoEditor extends Contenido{

    public ContenidoEditor(String url, int x, int y) {
        super(url, x, y);
    }


    @Override
    public int calculaX() {
        int pos = this.getX() + 10;
        return pos;
    }

    @Override
    public int calculaY() {
        int pos = this.getY() + (this.getBotones().size() * 31) + 10;
        return pos;
    }

}
