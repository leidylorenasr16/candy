/*
 * Violeth Valmont Azahar
 * 20181020010
 * Leidy Sanchez Rodr�guez
 * 20182020067
 * Sergio Miranda
 * 20182020064
 */
package candycrush.modelo;

import java.util.Scanner;



/**
 *
 * @author User
 */
public class Jugador {
    
    Vida v=new Vida();
    private String nick;
    Scanner teclado= new Scanner(System.in);
    
    public void solicitarNick(){
        System.out.println("¡BIENVENIDO!");
        System.out.println("Ingresa tu nick");
        setNick(teclado.nextLine());
    }
    //Metodo que envie una cantidad de vidas aleatoria entre 0 y 5
    public void establecerVida(){

        v.setVidas(5);
        //System.out.println(v.getVidas());
    }
    
    public void establecerMov(int m){

        v.setMovs(m);
        //System.out.println(v.getMovs());
    }
    
    public int getVidas(){
        return v.getVidas();
    }
    public int getMovs(){
        return v.getMovs();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }    
}
