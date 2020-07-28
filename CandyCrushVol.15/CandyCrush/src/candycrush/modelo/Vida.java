/*
 * Violeth Valmont Azahar
 * 20181020010
 * Leidy Sanchez Rodr�guez
 * 20182020067
 * Sergio Miranda
 * 20182020064
 */
package candycrush.modelo;

/**
 *
 * @author User
 */
public class Vida {
    private String forma;
    private int vidas=5;
    private int movs=50;

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getMovs() {
        return movs;
    }

    public void setMovs(int movs) {
        this.movs = movs;
    }
}
