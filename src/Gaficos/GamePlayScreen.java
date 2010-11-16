/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gaficos;

import Navegador.Ventana_Panel;
import java.awt.Graphics2D;

/**
 *
 * @author Thanar
 */
public class GamePlayScreen implements IScreen{
    IVentana mapa;
    IVentana panel;
    IVentana informacion;
    public void cargarModelos() {
        mapa = new Ventana_Mapa(750,500);
        panel = new Ventana_Panel(274,500);
        informacion = new Ventana_Informacion(1024,100);
        mapa.cargar();
        panel.cargar();
        informacion.cargar();
    }

    public void update() {
        mapa.update();
        panel.update();
        informacion.update();
    }

    public void draw(Graphics2D g) {
        mapa.draw(g);
        panel.draw(g);
        informacion.draw(g);
    }

}
