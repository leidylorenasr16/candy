/*
 * Violeth Valmont Azahar
 * 20181020010
 * Leidy Sanchez Rodr�guez
 * 20182020067
 * Sergio Miranda
 * 20182020064
 */
package candycrush.vista;

import candycrush.modelo.Caramelo;
import candycrush.modelo.Jugador;
import candycrush.modelo.Nivel;
import candycrush.modelo.Partida;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Tablero {

    String Tab[][] = new String[9][9];
    Jugador j = new Jugador();
    Nivel n = new Nivel();
    Partida p = new Partida();
    Caramelo ca = new Caramelo();
    Scanner teclado = new Scanner(System.in);
    Scanner teclado2 = new Scanner(System.in);
    private static int Columnas, Filas;

    public Tablero(Jugador j) {
        this.j = j;
    }

    //metodo que devuelva un valor aleatorio entre 1 y 3 pero despues :v
    public void establecerNivel() {
        n.setDificultad(1);
        if (n.getDificultad() == 1) {
            n.setNombreNivel("Nivel 1 - Jelly");
        } else if (n.getDificultad() == 2) {
            n.setNombreNivel("Nivel 2 - Ingredient");
        } else {
            n.setNombreNivel("Nivel 3 - Timed");
        }
        //System.out.println(n.getDificultad());
        //System.out.println(n.getNombreNivel());
    }

    public void establecerPuntaje(int puntos) {
        int puntaje;
        puntaje = n.getPuntaje();
        n.setPuntaje(puntaje + puntos);
    }

    public void miau() {
        System.out.println("miau");
    }

    public void tamMatriz() {
        Columnas = 9;
        Filas = 9;
    }

    public void generarTablero() {
        for (int i = 0; i < Filas; i++) {
            for (int j = 0; j < Columnas; j++) {
                Tab[i][j] = ca.tipoCaramelo();
            }
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < Filas; i++) {
            System.out.println(" ");
            for (int j = 0; j < Columnas; j++) {
                System.out.print(Tab[i][j] + "  ");
            }
        }
        System.out.println("");
    }

    public void panelSuperior() {
        System.out.println(n.getNombreNivel() + " | " + j.getNick() + " | Vidas: " + j.getVidas() + " | Mov: " + j.getMovs() + " | Puntos: " + n.getPuntaje());
    }

    public void quitarCaramelo() {
        for (int u = 0; u < 9; u++) {
            int j;
            j = (0 + (int) (Math.random() * 9));
            int i;
            i = (0 + (int) (Math.random() * 9));
            Tab[i][j] = "N";
        }
    }

    public void caerCaramelo() {
        for (int u = 0; u < 10; u++) {
            rellenarTab();
            for (int i = 8; i > 0; i--) {
                for (int j = 8; j > -1;) {
                    if (Tab[i][j] != "N") {
                        j--;
                    } else {
                        Tab[i][j] = Tab[i - 1][j];
                        Tab[i - 1][j] = "N";
                        j--;
                    }
                }
            }
        }
    }

    public void rellenarTab() {
        for (int j = 0; j < Columnas;) {
            if (Tab[0][j] != "N") {
                j++;
            } else {
                Tab[0][j] = ca.tipoCaramelo();
                caerCaramelo();
                j++;
            }
        }
    }

    public int buscarNo3Horizontal() { //Si no hay lineas de minimo 3 en horizontal devuelve true
        int cantCandy = 0;
        int candyValid = 0;
        String nextCandy = "";
        for (int i = 0; i < Columnas; i++) {
            for (int j = 0; j < Filas; j++) {

                String candyBuscar = Tab[i][j];

                if (j == 0 || j == 8) {

                } else {

                    String izquierdaCandy = Tab[i][j - 1];
                    String derechaCandy = Tab[i][j + 1];

                    if (candyBuscar == izquierdaCandy && candyBuscar == derechaCandy) {
                        String newCandy = ca.tipoCaramelo();
                        String auxCandy = candyBuscar;

                        while (auxCandy == newCandy) {

                            newCandy = ca.tipoCaramelo();

                        }

                        candyBuscar = newCandy;

                        Tab[i][j] = candyBuscar;

                        cantCandy++;
                    }

                }

                /* 
                candyBuscar = Tab[i][j];
                if (j > 0 && j < 7) {
                    nextCandy = Tab[i][j + 1];
                    if (candyBuscar.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                        nextCandy = Tab[i][j + 2];
                        if (candyBuscar.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                            cantCandy++;
                        }
                    }
                }
                 */
            }
        }
        if (cantCandy > 0) {
            candyValid = 1;
        }
        return candyValid;
    }

    public int buscarNo3Vertical() { //Si no hay lineas de minimo 3 en vertical devuelve true
        int cantCandy = 0;
        int candyValid = 0;
        for (int j = 0; j < Filas; j++) {
            for (int i = 0; i < Columnas; i++) {

                String candyBuscar = Tab[i][j];

                if (i == 0 || i == 8) {

                } else {

                    String arribaCandy = Tab[i - 1][j];
                    String abajoCandy = Tab[i + 1][j];

                    if (candyBuscar == arribaCandy && candyBuscar == abajoCandy) {
                        String newCandy = ca.tipoCaramelo();
                        String auxCandy = candyBuscar;

                        while (auxCandy == newCandy) {
                            newCandy = ca.tipoCaramelo();
                        }
                        candyBuscar = newCandy;

                        Tab[i][j] = candyBuscar;

                        cantCandy++;
                    }

                }

                /*
                String candyBuscar = Tab[i][j];
                if (i > 0 && i < 7) {
                    String nextCandy = Tab[i + 1][j];
                    if (candyBuscar.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                        nextCandy = Tab[i + 2][j];
                        if (candyBuscar.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                            cantCandy++;
                        }
                    }
                }
                 */
            }
        }
        if (cantCandy > 0) {
            candyValid = 1;
        }
        return candyValid;//verdadero si no hay mas caramelos
    }

    public int cambiaHorizontal() { //Si no hay lineas de minimo 3 en horizontal devuelve true
        int cantCandy = 0;
        int candyValid = 0;
        String nextCandy = "";
        String candyBuscar = "";
        for (int i = 0; i < Columnas; i++) {
            for (int j = 0; j < Filas; j++) {
                candyBuscar = Tab[i][j];
                if (j > 0 && j < 7) {
                    nextCandy = Tab[i][j + 1];
                    if (candyBuscar.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                        nextCandy = Tab[i][j + 2];
                        if (candyBuscar.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                            cantCandy++;
                        }
                    }
                }
            }
        }
        if (cantCandy > 0) {
            candyValid = 1;
        }
        return candyValid;
    }

    public int cambiaVertical() { //Si no hay lineas de minimo 3 en vertical devuelve true
        int cantCandy = 0;
        int candyValid = 0;
        for (int j = 0; j < Filas; j++) {
            for (int i = 0; i < Columnas; i++) {
                String candyBuscar = Tab[i][j];
                if (i > 0 && i < 7) {
                    String nextCandy = Tab[i + 1][j];
                    if (candyBuscar.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                        nextCandy = Tab[i + 2][j];
                        if (candyBuscar.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                            cantCandy++;
                        }
                    }
                }
            }
        }
        if (cantCandy > 0) {
            candyValid = 1;
        }
        return candyValid;//verdadero si no hay mas caramelos

    }

    public void tableroJugable() {
        int a = buscarNo3Horizontal();
        int b = buscarNo3Vertical();
        while (a == 1 && b == 1) {
            a = buscarNo3Horizontal();
            b = buscarNo3Vertical();
        }
    }

    public void cambiarCaramelo() {
        String candy = "";
        String candyAux = "";
        int dir = 0;
        int xx, yy;
        System.out.println("Ingresa la posicion del caramelo que quieres mover");
        System.out.println("Coordenada en y: ");
        int x = teclado.nextInt();
        System.out.println("Coordenada en x: ");
        int y = teclado.nextInt();
        System.out.println(Tab[y][x]);

        if (y >= 0 && x >= 0 && x < Columnas && y < Filas) {//Define que movimientos puede hacer el usuario.
            System.out.println("¿A donde quieres mover el dulce?");
            if (x < Columnas && x != 0 && y < Filas && y != 0) {
                System.out.println("1 = Abajo");
                System.out.println("2 = Arriba");
                System.out.println("3 = Derecha");
                System.out.println("4 = Izquierda");
                System.out.println("Ingresa la direccion a donde quieres moverlo");
                dir = teclado2.nextInt();
            }
            if (x == 0) {
                if (y == 0) {
                    System.out.println("1 = Abajo");
                    System.out.println("3 = Derecha");
                    System.out.println("Ingresa la direccion a donde quieres moverlo");
                    dir = teclado2.nextInt();
                } else {
                    if (y == Filas) {
                        System.out.println("1 = Abajo");
                        System.out.println("4 = Izquierda");
                        System.out.println("Ingresa la direccion a donde quieres moverlo");
                        dir = teclado2.nextInt();
                    } else {
                        System.out.println("1 = Abajo");
                        System.out.println("3 = Derecha");
                        System.out.println("4 = Izquierda");
                        System.out.println("Ingresa la direccion a donde quieres moverlo");
                        dir = teclado2.nextInt();
                    }
                }
            } else if (x == Columnas) {
                if (y == 0) {
                    System.out.println("2 = Arriba");
                    System.out.println("3 = Derecha");
                    System.out.println("Ingresa la direccion a donde quieres moverlo");
                    dir = teclado2.nextInt();
                } else {
                    if (y == Filas) {
                        System.out.println("2 = Arriba");
                        System.out.println("4 = Izquierda");
                        System.out.println("Ingresa la direccion a donde quieres moverlo");
                        dir = teclado2.nextInt();
                    } else {
                        System.out.println("2 = Arriba");
                        System.out.println("3 = Derecha");
                        System.out.println("4 = Izquierda");
                        System.out.println("Ingresa la direccion a donde quieres moverlo");
                        dir = teclado2.nextInt();
                    }
                }
            }

        } else {
            System.out.println("Las coordenadas estan fueran del rango del tablero");
        }
        switch (dir) {
            case 3:
                xx = x;
                yy = y + 1;
                candy = Tab[xx][yy];
                candyAux = Tab[x][y];
                Tab[x][y] = candy;
                Tab[xx][yy] = candyAux;
                restarMov();
                break;
            case 4:
                xx = x;
                yy = y - 1;
                candy = Tab[xx][yy];
                candyAux = Tab[x][y];
                Tab[x][y] = candy;
                Tab[xx][yy] = candyAux;
                restarMov();
                break;
            case 1:
                xx = x + 1;
                yy = y;
                candy = Tab[xx][yy];
                candyAux = Tab[x][y];
                Tab[x][y] = candy;
                Tab[xx][yy] = candyAux;
                restarMov();
                break;
            case 2:
                xx = x - 1;
                yy = y;
                candy = Tab[xx][yy];
                candyAux = Tab[x][y];
                Tab[x][y] = candy;
                Tab[xx][yy] = candyAux;
                restarMov();
                break;
            default:
                System.out.println("Opción invalida");
        }
    }

    public void buscarLineasHorizontal() {
        for (int i = 0; i < Columnas; i++) {
            for (int j = 0; j < Filas - 1; j++) {
                String candy = Tab[i][j];
                if (j < Filas) {
                    String nextCandy = Tab[i][j + 1];
                    if (j > -1 && j < 4) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i][j + 2];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                //puntuar los 3 caramelos 
                                nextCandy = Tab[i][j + 3];
                                if (candy.equals(nextCandy)) {
                                    //puntuar los 4 caramelos
                                    nextCandy = Tab[i][j + 4];
                                    if (candy.equals(nextCandy)) {
                                        //puntuar los 5 caramelos
                                        nextCandy = Tab[i][j + 5];
                                        if (candy.equals(nextCandy)) {
                                            establecerPuntaje(400);
                                            Tab[i][j] = "N";
                                            Tab[i][j + 1] = "N";
                                            Tab[i][j + 2] = "N";
                                            Tab[i][j + 3] = "N";
                                            Tab[i][j + 4] = "N";
                                            Tab[i][j + 5] = "N";
                                            caerCaramelo();
                                            rellenarTab();
                                            //puntuar los 6 caramelos
                                        } else {
                                            establecerPuntaje(200);
                                            Tab[i][j] = "N";
                                            Tab[i][j + 1] = "N";
                                            Tab[i][j + 2] = "N";
                                            Tab[i][j + 3] = "N";
                                            Tab[i][j + 4] = "N";
                                            caerCaramelo();
                                            rellenarTab();
                                            //eliminar los 5 caramelos y reestablecer el Tab, es decir que caigan los de arriba 
                                        }
                                    } else {
                                        establecerPuntaje(100);
                                        Tab[i][j] = "N";
                                        Tab[i][j + 1] = "N";
                                        Tab[i][j + 2] = "N";
                                        Tab[i][j + 3] = "N";
                                        caerCaramelo();
                                        rellenarTab();
                                        //eliminar los 4 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                    }
                                } else {
                                    establecerPuntaje(50);
                                    Tab[i][j] = "N";
                                    Tab[i][j + 1] = "N";
                                    Tab[i][j + 2] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //eliminar los 3 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                }
                            }
                        }
                    }
                    if (j == 4) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i][j + 2];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                //puntuar los 3 caramelos 
                                nextCandy = Tab[i][j + 3];
                                if (candy.equals(nextCandy)) {
                                    //puntuar los 4 caramelos
                                    nextCandy = Tab[i][j + 4];
                                    if (candy.equals(nextCandy)) {
                                        establecerPuntaje(200);
                                        Tab[i][j] = "N";
                                        Tab[i][j + 1] = "N";
                                        Tab[i][j + 2] = "N";
                                        Tab[i][j + 3] = "N";
                                        Tab[i][j + 4] = "N";
                                        caerCaramelo();
                                        rellenarTab();
                                        //puntuar los 5 caramelos 
                                    } else {
                                        establecerPuntaje(100);
                                        Tab[i][j] = "N";
                                        Tab[i][j + 1] = "N";
                                        Tab[i][j + 2] = "N";
                                        Tab[i][j + 3] = "N";
                                        caerCaramelo();
                                        rellenarTab();
                                        //eliminar los 4 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                    }
                                } else {
                                    establecerPuntaje(50);
                                    Tab[i][j] = "N";
                                    Tab[i][j + 1] = "N";
                                    Tab[i][j + 2] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //eliminar los 3 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                }
                            }
                        }
                    }
                    if (j == 5) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i][j + 2];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                //puntuar los 3 caramelos 
                                nextCandy = Tab[i][j + 3];
                                if (candy.equals(nextCandy)) {
                                    establecerPuntaje(100);
                                    Tab[i][j] = "N";
                                    Tab[i][j + 1] = "N";
                                    Tab[i][j + 2] = "N";
                                    Tab[i][j + 3] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //puntuar los 4 caramelos 
                                } else {
                                    establecerPuntaje(50);
                                    Tab[i][j] = "N";
                                    Tab[i][j + 1] = "N";
                                    Tab[i][j + 2] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //eliminar los 3 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                }
                            }
                        }
                    }
                    if (j == 6) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i][j + 2];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                establecerPuntaje(50);
                                Tab[i][j] = "N";
                                Tab[i][j + 1] = "N";
                                Tab[i][j + 2] = "N";
                                caerCaramelo();
                                rellenarTab();
                                //puntuar los 3 caramelos 
                            }
                        }
                    }
                }
            }
        }
    }

    public void buscarLineasVertical() {
        for (int j = 0; j < Filas; j++) {
            for (int i = 0; i < Columnas - 1; i++) {
                String candy = Tab[i][j];
                if (j < Columnas) {
                    String nextCandy = Tab[i + 1][j];
                    if (i > -1 && i < 4) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i + 2][j];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                //puntuar los 3 caramelos 
                                nextCandy = Tab[i + 3][j];
                                if (candy.equals(nextCandy)) {
                                    //puntuar los 4 caramelos
                                    nextCandy = Tab[i + 4][j];
                                    if (candy.equals(nextCandy)) {
                                        //puntuar los 5 caramelos
                                        nextCandy = Tab[i + 5][j];
                                        if (candy.equals(nextCandy)) {
                                            establecerPuntaje(400);
                                            Tab[i][j] = "N";
                                            Tab[i + 1][j] = "N";
                                            Tab[i + 2][j] = "N";
                                            Tab[i + 3][j] = "N";
                                            Tab[i + 4][j] = "N";
                                            Tab[i + 5][j] = "N";
                                            caerCaramelo();
                                            rellenarTab();
                                            //puntuar los 6 caramelos
                                        } else {
                                            establecerPuntaje(200);
                                            Tab[i][j] = "N";
                                            Tab[i + 1][j] = "N";
                                            Tab[i + 2][j] = "N";
                                            Tab[i + 3][j] = "N";
                                            Tab[i + 4][j] = "N";
                                            caerCaramelo();
                                            rellenarTab();
                                            //eliminar los 5 caramelos y reestablecer el Tab, es decir que caigan los de arriba 
                                        }
                                    } else {
                                        establecerPuntaje(100);
                                        Tab[i][j] = "N";
                                        Tab[i + 1][j] = "N";
                                        Tab[i + 2][j] = "N";
                                        Tab[i + 3][j] = "N";
                                        caerCaramelo();
                                        rellenarTab();
                                        //eliminar los 4 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                    }
                                } else {
                                    establecerPuntaje(50);
                                    Tab[i][j] = "N";
                                    Tab[i + 1][j] = "N";
                                    Tab[i + 2][j] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //eliminar los 3 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                }
                            }
                        }
                    }
                    if (i == 4) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i + 2][j];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                //puntuar los 3 caramelos 
                                nextCandy = Tab[i + 3][j];
                                if (candy.equals(nextCandy)) {
                                    //puntuar los 4 caramelos
                                    nextCandy = Tab[i + 4][j];
                                    if (candy.equals(nextCandy)) {
                                        establecerPuntaje(200);
                                        Tab[i][j] = "N";
                                        Tab[i + 1][j] = "N";
                                        Tab[i + 2][j] = "N";
                                        Tab[i + 3][j] = "N";
                                        Tab[i + 4][j] = "N";
                                        caerCaramelo();
                                        rellenarTab();
                                        //puntuar los 5 caramelos 
                                    } else {
                                        establecerPuntaje(100);
                                        Tab[i][j] = "N";
                                        Tab[i + 1][j] = "N";
                                        Tab[i + 2][j] = "N";
                                        Tab[i + 3][j] = "N";
                                        caerCaramelo();
                                        rellenarTab();
                                        //eliminar los 4 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                    }
                                } else {
                                    establecerPuntaje(50);
                                    Tab[i][j] = "N";
                                    Tab[i + 1][j] = "N";
                                    Tab[i + 2][j] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //eliminar los 3 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                }
                            }
                        }
                    }
                    if (i == 5) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i + 2][j];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                //puntuar los 3 caramelos 
                                nextCandy = Tab[i + 3][j];
                                if (candy.equals(nextCandy)) {
                                    establecerPuntaje(100);
                                    Tab[i][j] = "N";
                                    Tab[i + 1][j] = "N";
                                    Tab[i + 2][j] = "N";
                                    Tab[i + 3][j] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //puntuar los 4 caramelos 
                                } else {
                                    establecerPuntaje(50);
                                    Tab[i][j] = "N";
                                    Tab[i + 1][j] = "N";
                                    Tab[i + 1][j] = "N";
                                    caerCaramelo();
                                    rellenarTab();
                                    //eliminar los 3 caramelos y reestablecer el Tab, es decir que caigan los de arriba
                                }
                            }
                        }
                    }
                    if (i == 6) {
                        if (candy.equals(nextCandy)) {//si la primera condicion no se cumple automaticamente busca en la siguiente posicion horizontalmente 
                            nextCandy = Tab[i + 2][j];
                            if (candy.equals(nextCandy)) {//Si no hay un minimo de 3 caramelos sigue buscando
                                establecerPuntaje(50);
                                Tab[i][j] = "N";
                                Tab[i + 1][j] = "N";
                                Tab[i + 2][j] = "N";
                                caerCaramelo();
                                rellenarTab();
                                //puntuar los 3 caramelos 
                            }
                        }
                    }
                }
            }
        }
    }

    public void superEliminacion() {
        int a = 1;
        int b = 1;
        while (a == 1 && b == 1) {
            buscarLineasHorizontal();
            buscarLineasVertical();
            a = cambiaHorizontal();
            b = cambiaVertical();
        }
    }

    public void restarMov() {
        int mov = j.getMovs();
        mov = mov - 1;
        j.establecerMov(mov);
    }

    public void verificarVida() {
        if (j.getVidas() > 0) {

        } else if (j.getVidas() == 0) {
            System.out.println("Perdiste");
        }
    }

    public String[][] getTab() {
        return Tab;
    }

    public void setTab(String[][] Tab) {
        this.Tab = Tab;
    }

    public Caramelo getCa() {
        return ca;
    }

    public void setCa(Caramelo ca) {
        this.ca = ca;
    }

    public static int getColumnas() {
        return Columnas;
    }

    public static void setColumnas(int Columnas) {
        Tablero.Columnas = Columnas;
    }

    public static int getFilas() {
        return Filas;
    }

    public static void setFilas(int Filas) {
        Tablero.Filas = Filas;
    }
}
