/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplos;

import Entidades.Arrendatario;
import Entidades.GestionAparcamiento;
import Entidades.Cliente;
import Entidades.Parking;
import prueba.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Javier Ruiz Hidalgo
 */
public class ObserverCliente implements IObservador {

    private List<Cliente> client;
    private ISujeto sujeto;

    public ObserverCliente(SujetoConcreto sujeto) {
        this.client = new ArrayList();
        this.sujeto = sujeto;
        this.sujeto.attach(this);
    }

    public void update(List<Cliente> cliente, List<Arrendatario> arrendatario, List<Parking> parking, List<GestionAparcamiento> gestionAparcamiento) {
        if (cliente != null) {
            client = cliente;
            display();
        }
    }

    public void display() {
        for (Cliente c : this.client) {
            System.out.println(c.toString());
        }
    }
}
