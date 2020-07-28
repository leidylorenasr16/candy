/*
 * Violeth Valmont Azahar
 * 20181020010
 * Leidy Sanchez Rodr�guez
 * 20182020067
 * Sergio Miranda
 * 20182020064
 */
package candycrush.modelo;

import java.util.Random;

/**
 *
 * @author User
 */
public class Caramelo {
    private String color="";
    private String forma="";
    private int puntaje=0;
    
    public String tipoCaramelo(){
        Random caramel = new Random();
        int c = caramel.nextInt(5);
                switch (c) {
                    case 0:
                        forma = "*";
                        break;
                    case 1:
                        forma = "+";
                        break;
                    case 2:
                        forma = "#";
                        break;
                    case 3:
                        forma = "-";
                        break;
                    case 4:
                        forma = "@";
                        break;
                    default:
                }
                return forma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
}
