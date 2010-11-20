/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import Graficos.Fondo;
import Screens.GamePlayScreen;
import Screens.IScreen;
import Graficos.Lienzo;
import Screens.MainMenuScreen;
import Personajes.Actor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thanar
 */
public class Juego {
    Lienzo imagen;
    long startTime;
    long previousTime;
    boolean salir=false;
    Graphics2D pincel;
    static final int WIDTH = 1024;
    static final int HEIGHT = 600;
    private static Map<String,IScreen> screens;
    private static IScreen currentScreen;
    List<Actor> actores;
    Actor fondo;
    MouseHandler manejadorRaton;
    

    public Juego(){
        imagen = new Lienzo(WIDTH, HEIGHT);
        pincel = (Graphics2D) imagen.strategy.getDrawGraphics();
        actores = new ArrayList<Actor>();
        screens= new HashMap<String,IScreen>();
        cargarPantallas();


        manejadorRaton = new MouseHandler(imagen);

    }

    private void cargarPantallas(){
        screens.put("Menu", new MainMenuScreen());
        screens.put("Game", new GamePlayScreen());
        currentScreen= screens.get("Menu");
    }
    public void runGame(){
        startTime=System.currentTimeMillis();
        previousTime = startTime;
        cargarModelos();
        while(!salir){
            update();
            draw();
            if(System.currentTimeMillis()-previousTime<33){
                try{
                Thread.sleep(33-(System.currentTimeMillis()-previousTime));
                }catch(Exception e){}
            }
            previousTime=System.currentTimeMillis();
        }
    }
    public void cargarModelos(){
        for(IScreen s:screens.values()){
            try{
            s.cargarModelos();
            }catch(Exception e){}
        }
    }
    public void update(){
        currentScreen.update();
    }
    public void draw(){
        pincel.setColor(Color.GREEN);
        pincel.fillRect(0,0,WIDTH,HEIGHT);
        currentScreen.draw(pincel);
        imagen.strategy.show();
    }

    public static void changeScreen(String screen){

        currentScreen= screens.get(screen);
    }

}
