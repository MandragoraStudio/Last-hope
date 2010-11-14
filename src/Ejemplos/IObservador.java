/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejemplos;

import Entidades.Arrendatario;
import Entidades.GestionAparcamiento;
import Entidades.Cliente;
import Entidades.Parking;
import java.util.List;

/**
 *
 * @author Javier Ruiz Hidalgo
 */
public interface IObservador {

    public void update(List<Cliente> cliente, List <Arrendatario> arrendatario, List<Parking> parking, List<GestionAparcamiento> gestionAparcamiento);
}
