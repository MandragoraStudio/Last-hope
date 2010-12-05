/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arcangel
 */
public class Jugador implements IJugador {

    private long puntuacion;
    // Vida del Jugador
    private final Integer vidaMax =100;
    private Integer vida;
    //Energia
    private Integer energiaMax;
    private Integer energia;
    //recursos
    private final Integer maxRecursos = 9999;
    Map<String,Integer> recursos;

    //Contructores;
    public Jugador ()
    {
        puntuacion=0;
        vida=vidaMax;
        energiaMax = 200;
        energia=energiaMax;
        recursos = new HashMap<String, Integer> ();
        recursos.put("uranio",100);
        recursos.put("rodio",100);
        recursos.put("grafeno",100);
        recursos.put("radio",100);
        recursos.put("cromo",100);
    }

    public Jugador (boolean b)
    {
        puntuacion=0;
        vida=vidaMax;
        energiaMax = 200;
        energia=energiaMax;
        recursos = new HashMap<String, Integer> ();
        if(b){
            recursos.put("uranio",maxRecursos);
            recursos.put("rodio",maxRecursos);
            recursos.put("grafeno",maxRecursos);
            recursos.put("radio",maxRecursos);
            recursos.put("cromo",maxRecursos);
        }else{
            recursos.put("uranio",100);
            recursos.put("rodio",100);
            recursos.put("grafeno",100);
            recursos.put("radio",100);
            recursos.put("cromo",100);
        }
    }


    //Getters & setters
    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getEnergiaMax() {
        return energiaMax;
    }

    public void setEnergiaMax(Integer energiaMax) {
        this.energiaMax = energiaMax;
    }
    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void agregaPuntos(int n){
        puntuacion+=n;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public void restaVida(int vida){
        if(vida>this.vida)
            this.vida=0;
        else
            this.vida-=vida;
    }

    public Integer getVidaMax() {
        return vidaMax;
    }
    public Map<String, Integer> getRecursos() {
        return recursos;
    }
    public void restaRecursos(Map<String,Integer> r){
        recursos.put("uranio",recursos.get("uranio")-(r.containsKey("uranio")?r.get("uranio"):0));
        recursos.put("rodio",recursos.get("rodio")-(r.containsKey("rodio")?r.get("rodio"):0));
        recursos.put("grafeno",recursos.get("grafeno")-(r.containsKey("grafeno")?r.get("grafeno"):0));
        recursos.put("radio",recursos.get("radio")-(r.containsKey("radio")?r.get("radio"):0));
        recursos.put("cromo",recursos.get("cromo")-(r.containsKey("cromo")?r.get("cromo"):0));
        this.energia-=r.get("energia");
    }
    
    public static boolean suficientesRecursos(Map<String,Integer> r){
        boolean dev = true;
        //TODO: un metodo que devuelva true si hay suficientes recursos y false en caso contrario
        return dev;
    }

    //Metodos

    public void AñadirRecursos(Map<String,Integer> rec) {
        Integer aux = 0;
        for (String s : rec.keySet()){
        aux = recursos.get(s);
        aux= aux + rec.get(s);
        if(aux>maxRecursos)
            aux=maxRecursos;
        recursos.remove(s);
        recursos.put(s, aux);
        }
    }

     public void AñadirPuntuacion(Integer p){
         setPuntuacion(getPuntuacion()+p);
     }

}
