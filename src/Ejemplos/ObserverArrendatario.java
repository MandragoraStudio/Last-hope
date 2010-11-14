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
public class ObserverArrendatario implements IObservador {

    private List<Arrendatario> arrendat;
    private ISujeto sujeto;

    public ObserverArrendatario(SujetoConcreto sujeto) {
        this.arrendat = new ArrayList();
        this.sujeto = sujeto;
        this.sujeto.attach(this);
    }

    public void update(List<Cliente> cliente, List<Arrendatario> arrendatario, List<Parking> parking, List<GestionAparcamiento> gestionAparcamiento) {
        if (arrendatario != null) {
            arrendat = arrendatario;
            display();
        }
    }

    public void display() {
        for (Arrendatario a : this.arrendat) {
            System.out.println(a.toString());
        }
    }
}
