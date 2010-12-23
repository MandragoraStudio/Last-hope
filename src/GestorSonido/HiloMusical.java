/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestorSonido;

/**
 *
 * @author Jose
 */
public class HiloMusical extends Thread{

    private String sonido;
    private static HiloMusical hilo;

    private HiloMusical(String sonido){
        this.sonido=sonido;
    }

    public static HiloMusical getHiloMusical(String sonido){
        if(hilo==null){
            hilo= new HiloMusical(sonido);
        }else{
            hilo.setSonido(sonido);
        }
        return hilo;
    }

    @Override
    public void run() {
        ReproduceAudio r = ReproduceAudio.getReproductor();
        r.changeAudio(sonido);
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }


}
