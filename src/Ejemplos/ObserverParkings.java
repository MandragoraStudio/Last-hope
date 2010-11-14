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
public class ObserverParkings implements IObservador {

    private List<Parking> park;
    private ISujeto sujeto;

    public ObserverParkings(SujetoConcreto sujeto) {
        this.park = new ArrayList();
        this.sujeto = sujeto;
        this.sujeto.attach(this);
    }

    public void update(List<Cliente> cliente, List<Arrendatario> arrendatario, List<Parking> parking, List<GestionAparcamiento> gestionAparcamiento) {
        if (parking != null) {
            park = parking;
            display();
        }
    }

    public void display() {
        for (Parking p : this.park) {
            System.out.println(p.toString());
        }
    }
}
