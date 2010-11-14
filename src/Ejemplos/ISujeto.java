/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejemplos;



/**
 *
 * @author Javier Ruiz Hidalgo
 */
public interface ISujeto {

    public void attach(IObservador o);

    public void dettach(IObservador o);

    public void notifyObservers();
}
