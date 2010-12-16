/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Screens;

import Graficos.IVentana;
import Informacion.Ventana_Informacion;
import Mapa.Ventana_Mapa;
import Panel.Ventana_Panel;
import Principal.Juego;
import Principal.Jugador;
import java.awt.Graphics2D;

/**
 *
 * @author Thanar
 */
public class GamePlayScreen implements IScreen{
    IVentana mapa; // sub ventana de mapa
    IVentana panel; // sub ventana de panel de navegacion
    IVentana informacion; // sub ventana del panel de informacion

    public void cargarModelos() {
        //inicializamos las sub ventanas con sus coordenadas y sus dimensiones
        mapa = new Ventana_Mapa(750,500, 0, 0,"imagenes/gravilla.png","imagenes/grass.png");
        panel = Ventana_Panel.getVentanaPanel(274,500, 750, 0);
        informacion = new Ventana_Informacion(1024,100, 0, 500);
    }

    public void update() {
        //actualizamos todas las subventanas
        mapa.update();
        panel.update();
        informacion.update();
    }

    public void draw(Graphics2D g) {
        //dibujamos todas las subventanas
        mapa.draw(g);
        panel.draw(g);
        informacion.draw(g);
    }

}
