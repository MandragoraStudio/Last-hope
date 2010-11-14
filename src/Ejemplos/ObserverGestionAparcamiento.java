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
public class ObserverGestionAparcamiento implements IObservador {

    private List<GestionAparcamiento> gestAparct;
    private ISujeto sujeto;

    public ObserverGestionAparcamiento(SujetoConcreto sujeto) {
        this.gestAparct = new ArrayList();
        this.sujeto = sujeto;
        this.sujeto.attach(this);
    }

    public void update(List<Cliente> cliente, List<Arrendatario> arrendatario, List<Parking> parking, List<GestionAparcamiento> gestionAparcamiento) {
        if (gestionAparcamiento != null) {
            this.gestAparct = gestionAparcamiento;
            display();
        }
    }

    public void display() {
        for (GestionAparcamiento gA : this.gestAparct) {
            System.out.println(gA.toString());
        }
    }
}
