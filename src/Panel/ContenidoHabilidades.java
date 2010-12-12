/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Graficos.Boton;
import Graficos.Lienzo;
import Observador.Observador_CreadorHabilidad;
import Personajes.CentralEnergia;
import Personajes.Fuego;
import Personajes.Lluvia;
import UtilMath.Vector2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class ContenidoHabilidades extends Contenido {

    

    public ContenidoHabilidades(String url, Vector2D posicion) {
        super(url, posicion);
        try {
            this.cargar();
        } catch (Exception ex) {
            Logger.getLogger(ContenidoHabilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargar() throws Exception {
        Image img4 = Lienzo.cargarImagen("imagenes/centralEnergia.png");
        //cargamos los botones del contenido 3
        BotonCreadorHabilidad b =new BotonCreadorHabilidad(img4, img4, "Central", calculaX(), calculaY(), img4.getWidth(null), img4.getHeight(null), new CentralEnergia(img4, Vector2D.zero));
        new Observador_CreadorHabilidad(b);
        addBotonPorDefecto(b);

        Image img5 = Lienzo.cargarImagen("imagenes/Lluvia.png");
        BotonCreadorHabilidad b2 =new BotonCreadorHabilidad(img5, img5, "Lluvia", calculaX(), calculaY(), img5.getWidth(null), img5.getHeight(null), new Lluvia(img5, Vector2D.zero));
        new Observador_CreadorHabilidad(b2);
        addBotonPorDefecto(b2);

        Image img6 = Lienzo.cargarImagen("imagenes/Fuego.png");
        BotonCreadorHabilidad b3 =new BotonCreadorHabilidad(img6, img6, "Fuego", calculaX(), calculaY(), img6.getWidth(null), img6.getHeight(null), new Fuego(img6, Vector2D.zero));
        new Observador_CreadorHabilidad(b3);
        addBotonPorDefecto(b3);

    }

    @Override
    public void addBotonPorDefecto(Boton b) throws Exception {
        if (this.getBotonesPorDefecto().size() < 12) {
            this.getBotonesPorDefecto().add(b);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(this.getImagen(), (int) posicion.x, (int) posicion.y, null);

        for (Boton b : this.getBotonesPorDefecto()) {
            b.draw(g);
            g.drawString(b.getNombre(), b.getX(), b.getY() + b.getHeight() + 12);
        }
    }

    @Override
    public int calculaX() {
        int pos = 0;
        int modulo = this.getBotonesPorDefecto().size() % 3;
        if (this.getBotonesPorDefecto().size() == 0) {
            pos = (int) posicion.x + 31;
        } else {
            pos = (int) posicion.x + (modulo * 81) + 31;
        }
        return pos;
    }

    @Override
    public int calculaY() {
        int pos = 0;
        int cociente = this.getBotonesPorDefecto().size() / 3;
        if (this.getBotonesPorDefecto().size() == 0) {
            pos = (int) posicion.y + 66;
        } else {
            pos = (int) posicion.y + (cociente * 81) + 66;
        }
        return pos;
    }
}
