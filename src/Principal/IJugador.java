/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import java.util.Map;

/**
 *
 * @author Arcangel
 */
public interface IJugador {
   
    //public Integer getEnergia();
    //public void setEnergia(Integer energia);
    public Integer getEnergiaMax();
    public long getPuntuacion();
    public void setPuntuacion(long puntuacion);
    public Integer getVida();
    public void setVida(Integer vida);
    public Integer getVidaMax();
    public Map<String, Integer> getRecursos();
    public void AñadirRecursos(Map<String,Integer> rec);
    public void AñadirPuntuacion(Integer p);
}
