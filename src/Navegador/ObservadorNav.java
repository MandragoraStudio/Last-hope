/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Navegador;

/**
 *
 * @author Thanar
 */
public class ObservadorNav implements IObservadorNav {
    private Pestaña pestaña;
    public ObservadorNav(Pestaña p){
        this.pestaña = p;
        pestaña.Atach(this);
    }

    public void update(String comando) {
        if(comando.equals("torres")){
            Ventana_Panel.cambiaFondo("fondoTorres");
        }
        if(comando.equals("editor")){
            Ventana_Panel.cambiaFondo("fondoEditor");
        }
        if(comando.equals("trap")){
            Ventana_Panel.cambiaFondo("fondoTraps");
        }
    }
}
