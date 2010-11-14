/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejemplos;

import Entidades.Arrendatario;
import Entidades.GestionAparcamiento;
import Entidades.Cliente;
import Entidades.Parking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier Ruiz Hidalgo
 */
public class SujetoConcreto implements ISujeto{
    
    private List<IObservador> observadores;
    
    private List<Cliente> cliente;
    private List<Arrendatario> arrendatario;
    private List<Parking> parking;
    private List<GestionAparcamiento> gestionAparcamiento;

    public SujetoConcreto() {
        observadores=new ArrayList();

    }

    public void attach(IObservador o) {
        getObservadores().add(o);
    }

    public void dettach(IObservador o) {
        getObservadores().remove(o);
    }

    public void notifyObservers() {

        for(IObservador o: getObservadores()){

            o.update(cliente, arrendatario, parking, gestionAparcamiento);

        }

    }

    public void setMeassurements(List<Cliente> cliente, List <Arrendatario> arrendatario, List<Parking> parking, List<GestionAparcamiento> gestionAparcamiento){
        this.cliente=cliente;
        this.arrendatario=arrendatario;
        this.gestionAparcamiento=gestionAparcamiento;
        this.parking=parking;
        notifyObservers();
    }

    public List<IObservador> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<IObservador> observadores) {
        this.observadores = observadores;
    }
}
