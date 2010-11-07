/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gaficos;

import java.awt.Graphics2D;


/**
 *
 * @author Thanar
 */
public interface IScreen {
    public void cargarModelos();
    public void update();
    public void draw(Graphics2D g);
}
