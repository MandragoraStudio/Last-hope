/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Informacion;

import Graficos.Boton;
import Graficos.Lienzo;
import Mapa.Ventana_Mapa;
import Observador.IObservador;
import Personajes.Actor;
import Personajes.Tower;
import Principal.Juego;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arcangel
 */
class ObservadorVentana_Informacion implements IObservador {
    private Boton boton;
    Image brillo;
    public ObservadorVentana_Informacion(Boton b)
    {
        boton = b;//inicializa el boton
        boton.setObservador(this); //le añadimos al boton el observador
        brillo = Lienzo.cargarImagen("imagenes/brillo.png");
    }

    public void update() {
      if (boton.getNombre().equals("sell")) {
          Tower t =(Tower) Ventana_Informacion.ac;
          Map<String,Integer> rec = new HashMap<String, Integer>();
          for(String s : t.coste.keySet())
          {
              if(s.equals("energia"))
                rec.put(s, t.coste.get(s));
              else
              rec.put(s, t.coste.get(s)/2);
          }
          Juego.getJuego().jugador.AñadirRecursos(rec);
          Ventana_Mapa.eliminar.add(Ventana_Informacion.ac);
          Ventana_Informacion.ac=null;
        }
    }
    public void draw (Graphics2D g)
    {
        if (boton.getNombre().equals("look"))
        {
            for(Actor ac : Ventana_Mapa.actores)
            {
                if(ac instanceof Tower){
                    Tower t = (Tower)ac;
                    g.drawImage(brillo,(int)(ac.posicion.x+(Ventana_Mapa.casillaWidth/2)-t.getRango()), (int)(ac.posicion.y+(Ventana_Mapa.casillaHeight/2)-t.getRango()), (int)(t.getRango()*2),(int) (t.getRango()*2), null);
                }
            }
        }
    }

}
