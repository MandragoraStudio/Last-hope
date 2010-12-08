/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Handlers.MouseHandler;
import Screens.GamePlayScreen;
import Screens.IScreen;
import Graficos.Lienzo;
import Screens.GameOverScreen;
import Screens.MainMenuScreen;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thanar
 */
public class Juego {

    Lienzo lienzo;//objeto en el que vamos a digujar
    long startTime; //tiempo en el que empieza la aplicacion
    long previousTime; // tiempo de la ultima vez que se hizo un bucle completo
    boolean salir = false; // controla si debemos salir o no de la aplicacion
    Graphics2D pincel; // objeto con el que pintaremos en el lienzo
    static final int WIDTH = 1024; //ancho de la pantalla
    static final int HEIGHT = 600; //alto de la pantalla
    private static Map<String, IScreen> screens; // ventanas del juego (menu, gameplay, ...)
    private static IScreen currentScreen; //ventana que se está mostrando actualmente
    public static Jugador jugador; // objeto del jugador
    MouseHandler manejadorRaton; // objeto que controla la actividad del raton

    public Juego() {
        //inicializacion de las variables
        lienzo = new Lienzo(WIDTH, HEIGHT);
        pincel = (Graphics2D) lienzo.strategy.getDrawGraphics();
        screens = new HashMap<String, IScreen>();
        jugador = new Jugador(true);
        manejadorRaton = new MouseHandler(lienzo);
        //carga de las pantallas
        Globals.elapsedTime = 0;
        cargarPantallas();
    }

    private void cargarPantallas() {
        //cargamos el menu
        screens.put("Menu", new MainMenuScreen());
        //cargamos el game
        screens.put("Game", new GamePlayScreen());
        //Cargamos el game Over
        screens.put("GameOver", new GameOverScreen());
        //actualizamos el current Screen a menu
        currentScreen = screens.get("Menu");
    }

    public void runGame() {
        //tomamos el tiempo en el que empieza la aplicacion
        startTime = System.currentTimeMillis();
        long auxTime = 0;
        //inicializamos previous time
        previousTime = startTime;
        //cargamos los modelos (solo una vez)
        cargarModelos();
        //bucle principal
        while (!salir) {
            //update principal para actualizar el estado del juego
            update();
            // draw principal para dibujar todo lo dibujable
            draw();
            //nos aseguramos que como minimo cada bucle tarde 33 milisegundos
            if (System.currentTimeMillis() - previousTime < 33) {
                try {
                    Thread.sleep(33 - (System.currentTimeMillis() - previousTime));
                } catch (Exception e) {
                }
            }
            //actualizamos el valor de previous time
            auxTime = System.currentTimeMillis();
            Globals.elapsedTime = auxTime - previousTime;
            previousTime = auxTime;
        }
    }

    public void cargarModelos() {
        //recorremos todas las ventanas y las cargamos
        for (IScreen s : screens.values()) {
            try {
                s.cargarModelos();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // actualizamos solo la ventana principal
        currentScreen.update();
    }

    public void draw() {

        //ponemos un fondo verde siempre de ancho y alto igual que el de la ventana
        pincel.setColor(Color.GREEN);
        pincel.fillRect(0, 0, WIDTH, HEIGHT);
        // dibujamos solo la ventana actual con el pincel
        currentScreen.draw(pincel);
        lienzo.strategy.show();
    }
    //metodo estatico para cambiar la ventana

    public static void changeScreen(String screen) {

        currentScreen = screens.get(screen);
    }
}
