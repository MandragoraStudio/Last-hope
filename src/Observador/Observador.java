/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Graficos.Boton;
import Panel.BotonCreadorTorre;
import Panel.BotonCreadorTrap;
import Panel.ContenidoEditor;
import Panel.Ventana_Panel;
import Principal.Juego;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanar
 */
public class Observador implements IObservador {
    private Boton boton;
    public Observador(Boton b){
        boton = b;
        boton.Atach(this);
    }

    public void update(String comando) {
        if(comando.equals("start")){
            Juego.changeScreen("Game");
        }else if (comando.equals("exit")) {
            System.exit(0);
        }
        else if(comando.equals("Menu")){
            Juego.changeScreen("Menu");
        }
        else if(comando.equals("torres")){
            Ventana_Panel.cambiaFondo("fondoTorres");
        }
        else if(comando.equals("editor")){
            Ventana_Panel.cambiaFondo("fondoEditor");
        }
        else if(comando.equals("trap")){
            Ventana_Panel.cambiaFondo("fondoTraps");
        }
        else if(comando.equals(ContenidoEditor.getAtributos().get("Nombre"))){
            BotonCreadorTorre.creaTorre();
        }
        else if(comando.equals("creaTrap")){
            BotonCreadorTrap.creaTrap();
        }
        else if(comando.equals("creaBotonCreador")){
            ContenidoEditor.creaBotonCreador();
        }else if(comando.equals("Nombre")){
            String nombre = JOptionPane.showInputDialog( null, "Introduzca el Nombre de la torre:", "Nombre", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Nombre", nombre);
        }
        else if(comando.equals("Daño")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de daño:", "Daño", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Daño", nivel);
        }
        else if(comando.equals("Rango")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de Rango:", "Rango", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Rango", nivel);
        }
        else if(comando.equals("Área de daño")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de Área de daño:", "Área de daño", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Área de daño", nivel);
        }
        else if(comando.equals("Congelación")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de Congelación:", "Congelación", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Congelación", nivel);
        }
        else if(comando.equals("Fuego")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de Fuego:", "Fuego", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Fuego", nivel);
        }
        else if(comando.equals("Veneno")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de Veneno:", "Veneno", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Veneno", nivel);
        }
        else if(comando.equals("Recarga")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de Recarga:", "Recarga", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Recarga", nivel);
        }
        else if(comando.equals("Penetración")){
            String nivel = JOptionPane.showInputDialog( null, "Introduzca el nivel de Penetración:", "Penetración", JOptionPane.INFORMATION_MESSAGE);
            ContenidoEditor.inicializaAtributo("Penetración", nivel);
        }
    }
}
