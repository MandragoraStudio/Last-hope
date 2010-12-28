/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Mapa.Ventana_Mapa;
import Personajes.Actor;
import Personajes.CentralEnergia;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arcangel
 */
public class Jugador implements IJugador {

    private long puntuacion;
    // Vida del Jugador
    private final Integer vidaMax = 100;
    private Integer vida;
    //recursos
    private final Integer maxRecursos = 9999;
    static Map<String, Integer> recursos;

    //Contructores;
    public Jugador() {
        puntuacion = 0;
        vida = vidaMax;
        //energia=energiaMax;
        recursos = new HashMap<String, Integer>();
        recursos.put("uranio", 200);
        recursos.put("rodio", 200);
        recursos.put("grafeno", 200);
        recursos.put("radio", 200);
        recursos.put("cromo", 200);
        recursos.put("energia", getEnergiaMax());
    }

    public Jugador (boolean b)
    {
        puntuacion=0;
        vida=vidaMax;
        recursos = new HashMap<String, Integer> ();
        if(b){
            recursos.put("uranio",maxRecursos);
            recursos.put("rodio",maxRecursos);
            recursos.put("grafeno",maxRecursos);
            recursos.put("radio",maxRecursos);
            recursos.put("cromo",maxRecursos);
            recursos.put("energia", getEnergiaMax());
        }else{
            recursos.put("uranio",300);
            recursos.put("rodio",300);
            recursos.put("grafeno",300);
            recursos.put("radio",300);
            recursos.put("cromo",300);
            recursos.put("energia", 0);
        }
    }

    //Getters & setters
    //public Integer getEnergia() {
    //    return energia;
    //}
    //public void setEnergia(Integer energia) {
    //    this.energia = energia;
    //}
    //public Boolean restaEnergia(Integer energia){
    //    Boolean energiaSuf = true;
    //    if(energia>this.energia){
    //        this.energia=0;
    //        energiaSuf=false;
    //    }
    //    else
    //        this.energia-=energia;
    //    return energiaSuf;
    //}
    public Integer getEnergiaMax() {
        int aux=0;
            for(Actor ac : Ventana_Mapa.actores)
            {
                if(ac instanceof CentralEnergia){
                    aux++;
                }
            }
        return (aux*CentralEnergia.energiaProducida);
    }

    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void agregaPuntos(int n) {
        puntuacion += n;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Boolean restaVida(int vida) {
        Boolean vivo = true;
        if (vida >= this.vida) {
            this.vida = 0;
            vivo = false;
        } else {
            this.vida -= vida;
        }
        return vivo;
    }

    public Integer getVidaMax() {
        return vidaMax;
    }

    public Map<String, Integer> getRecursos() {
        return recursos;
    }

    //TODO: un metodo que añade recursos
    public static boolean agregaRecursos(Map<String, Integer> rec) {
        boolean dev = true;
        if (dev) {
            Integer aux = 0;
            for (String s : rec.keySet()) {
                aux = recursos.get(s);
                aux = aux + rec.get(s);
                recursos.remove(s);
                recursos.put(s, aux);
            }
        }
        return dev;
    }

    public Boolean restaRecursos(Map<String, Integer> rec) {
        Boolean dev = true;
        for (String s : rec.keySet()) {
            if (recursos.get(s) < rec.get(s)) {
                dev = false;
                break;
            }
        }
        if (dev) {
            Integer aux = 0;
            for (String s : rec.keySet()) {
                aux = recursos.get(s);
                aux = aux - rec.get(s);
                recursos.remove(s);
                recursos.put(s, aux);
            }
        }
        //recursos.put("uranio",recursos.get("uranio")-(r.containsKey("uranio")?r.get("uranio"):0));
        //recursos.put("rodio",recursos.get("rodio")-(r.containsKey("rodio")?r.get("rodio"):0));
        //recursos.put("grafeno",recursos.get("grafeno")-(r.containsKey("grafeno")?r.get("grafeno"):0));
        //recursos.put("radio",recursos.get("radio")-(r.containsKey("radio")?r.get("radio"):0));
        //recursos.put("cromo",recursos.get("cromo")-(r.containsKey("cromo")?r.get("cromo"):0));
        //restaEnergia(r.containsKey("energia")?r.get("energia"):0);
        return dev;
    }

    public boolean suficientesRecursos(Map<String, Integer> rec) {
        boolean dev = true;
        for (String s : rec.keySet()) {
            if (recursos.get(s) < rec.get(s)) {
                dev = false;
                break;
            }
        }
        return dev;
    }

    //Metodos
    public void AñadirRecursos(Map<String, Integer> rec) {
        Integer aux = 0;
        for (String s : rec.keySet()) {
            aux = recursos.get(s);
            aux = aux + rec.get(s);
            if (s == "energia") {
                if (aux >= getEnergiaMax()) {
                    aux = getEnergiaMax();
                }
            } else {
                if (aux > maxRecursos) {
                    aux = maxRecursos;
                }
            }
            recursos.remove(s);
            recursos.put(s, aux);
        }
    }

    public void AñadirPuntuacion(Integer p) {
        setPuntuacion(getPuntuacion() + p);
    }
}
