/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import GestorSonido.ReproductorMp3;
import Graficos.Lienzo;
import Handlers.MouseHandler;
import Screens.CreditsScreen;
import Screens.FinFase1;
import Screens.FinFase2;
import Screens.GameOverScreen;
import Screens.GamePlayScreen;
import Screens.IScreen;
import Screens.InicioFase1;
import Screens.LoadingScreen;
import Screens.MainMenuScreen;
import Screens.Presentacion;
import Screens.Tutorial;
import java.net.URL;

/**
 *
 * @author Thanar
 */
public class Juego {

    private static Juego juego = null; //instancia privada del juego (patrón singleton)
    private Lienzo lienzo;//objeto en el que vamos a digujar
    private long startTime; //tiempo en el que empieza la aplicacion
    private long previousTime; // tiempo de la ultima vez que se hizo un bucle completo
    private boolean salir = false; // controla si debemos salir o no de la aplicacion
    private Graphics2D pincel; // objeto con el que pintaremos en el lienzo
    public final int WIDTH = 1024; //ancho de la pantalla
    public final int HEIGHT = 600; //alto de la pantalla
    private Map<String, IScreen> screens; // ventanas del juego (menu, gameplay, ...)
    private IScreen currentScreen; //ventana que se está mostrando actualmente
    public Jugador jugador; // objeto del jugador
    private MouseHandler manejadorRaton; // objeto que controla la actividad del raton

    private Juego() {
        //inicializacion de las variables
        lienzo = new Lienzo(WIDTH, HEIGHT);
        pincel = (Graphics2D) lienzo.strategy.getDrawGraphics();
        screens = new HashMap<String, IScreen>();
        manejadorRaton = new MouseHandler(lienzo);
        //carga de las pantallas
        Globals.elapsedTime = 0;
        cargarPantallas();
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public static Juego getJuego() {
        if (juego == null) {
            juego = new Juego();
        }
        return juego;
    }

    private void cargarPantallas() {
        //Cargamos el FinFase1
        screens.put("FinFase1", FinFase1.getFinFase1());
        //Cargamos el FinFase2
        screens.put("FinFase2", FinFase2.getFinFase2());
        //Cargamos el FinFase3
        screens.put("InicioFase1", InicioFase1.getInicioFase1());
        //cargamos el tutorial
        screens.put("Tutorial", Tutorial.getTutorial());
        //Cargamos el Loading...
        screens.put("Loading", LoadingScreen.getLoadingScreen());
        //Cargamos el Presentacion
        screens.put("Presentacion", Presentacion.getPresentacion());

        //cargamos el menu
        screens.put("Menu", MainMenuScreen.getMenu());
        //cargamos el game
        screens.put("Game", new GamePlayScreen());
        //Cargamos el game Over
        screens.put("GameOver", GameOverScreen.getGameOver());
        //Cargamos los creditos
        screens.put("Credits", new CreditsScreen());
        //actualizamos el current Screen a Loading
        currentScreen = screens.get("Loading");
    }

    public void runGame() {
        //tomamos el tiempo en el que empieza la aplicacion
        startTime = System.currentTimeMillis();
        long auxTime = 0;
        //inicializamos previous time
        previousTime = startTime;
        draw();
        //cargamos los modelos (solo una vez)
        cargarModelos();
        //bucle principal
        while (!salir) {
            System.gc();
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

    public void restartGame() {
        screens.remove("Game");
        screens.put("Game", new GamePlayScreen());
        screens.get("Game").cargarModelos();
        jugador = new Jugador(false);
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

    public void changeScreen(String screen) {
        if (screen.equals("GameOver")) {
            ReproductorMp3.cambiaMusica("Sonidos/LastHope.mp3");
            ReproductorMp3 r = new ReproductorMp3("");
            r.start();
        } else if (screen.equals("InicioFase1")||screen.equals("FinFase1")||screen.equals("FinFase2")) {
            ReproductorMp3.cambiaMusica("Sonidos/finFase.mp3");
            ReproductorMp3 r = new ReproductorMp3("");
            r.start();
        } else if (screen.equals("Game")) {
            ReproductorMp3.cambiaMusica("Sonidos/ingame.mp3");
            ReproductorMp3 r = new ReproductorMp3("");
            r.start();
        }

        currentScreen = screens.get(screen);
    }

    public IScreen getCurrentScreen() {
        return currentScreen;
    }
}
