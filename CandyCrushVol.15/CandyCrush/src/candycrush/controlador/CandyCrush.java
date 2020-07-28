/*
 * Violeth Valmont Azahar
 * 20181020010
 * Leidy Sanchez Rodr�guez
 * 20182020067
 * Sergio Miranda
 * 20182020064
 */
package candycrush.controlador;

import candycrush.modelo.Jugador;
import candycrush.modelo.Nivel;
import candycrush.modelo.Partida;
import candycrush.modelo.Vida;
import candycrush.vista.Tablero;

/**
 *
 * @author User
 */
public class CandyCrush {

    public static void main(String[] args) {
        Jugador j = new Jugador();
        Tablero t = new Tablero(j);
        Nivel n = new Nivel();
        Vida v=new Vida();
        int nivel,vidas;
        t.miau();
        j.solicitarNick();
        j.establecerVida();
        j.establecerMov(50);
        t.establecerNivel();
        t.tamMatriz();
        t.generarTablero();
        nivel=n.getPuntaje();
        vidas=v.getVidas();
        while(nivel<1000||vidas<0){
        t.panelSuperior();
        t.tableroJugable();
        t.imprimirTablero();
        t.cambiarCaramelo();
        //t.buscarLineasHorizontal();
        //t.buscarLineasVertical();
        t.superEliminacion();
        t.panelSuperior();
        t.imprimirTablero();  
        if(nivel>=1000){
            System.out.println("FELICIDADES haz ganado");
            System.out.println("Gracias diosito funciona");
        }
        if(vidas<=0){
            System.out.println("Perdiste, no se como porque son demasiados intentos");
            System.out.println("Impedido!!!");
        }
        }
    }

}
