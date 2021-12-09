package proyectojuego;

import java.util.Random;
import java.util.Scanner;

public class ProyectoJuego {

    public static int[] cartas = new int[52];
    public static int[] fila1 = new int[13];
    public static int[] fila2 = new int[13];
    public static int[] fila3 = new int[13];
    public static int[] fila4 = new int[13];
    public static int[] fila5 = new int[13];
    public static int[] fila6 = new int[13];
    public static int[] fila7 = new int[13];
    public static int[] pila = new int[24];
    public static int[] monton1 = new int[13];
    public static int[] monton2 = new int[13];
    public static int[] monton3 = new int[13];
    public static int[] monton4 = new int[13];
    public static int primera = 1, segunda = 2, tercera = 3, cuarta = 4,
            quinta = 5, sexta = 6, septima = 7, cont1 = 0, cont2 = 1, cont3 = 2,
            cont4 = 3, cont5 = 4, cont6 = 5, cont7 = 6, cuentaPila = 0, m1 = 0, m2 = 0,
            m3 = 0, m4 = 0, filaMover, cuantas, filaCogida;

    public static int menu() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Elige una opción: ");
        System.out.println("1. Mostrar Tablero \n"
                + "2. Mover carta a fila \n"
                + "3. Mover carta a monton \n"
                + "4. Sacar carta de la pila \n"
                + "5. Comprobar victoria \n"
                + "6. Dejar de jugar \n");
        int opcion = lector.nextInt();

        return opcion;
    }

    public static boolean comprobarFilaLLena(int fila) {
        switch (fila) {
            case 1:
                if (primera == 0) {
                    return false;
                } else {
                    return true;
                }

            case 2:
                if (segunda == 0) {
                    return false;
                } else {
                    return true;
                }
            case 3:
                if (tercera == 0) {
                    return false;
                } else {
                    return true;
                }
            case 4:
                if (cuarta == 0) {
                    return false;
                } else {
                    return true;
                }
            case 5:
                if (quinta == 0) {
                    return false;
                } else {
                    return true;
                }
            case 6:
                if (sexta == 0) {
                    return false;
                } else {
                    return true;
                }
            case 7:
                if (septima == 0) {
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    public static boolean comprobarVictoria() {
        if (m1 == 13 && m2 == 13 && m3 == 13 && m4 == 13) {
            return true;
        } else {
            return false;
        }
    }

    public static void realizaAccion(int opcion) {
        Scanner lector = new Scanner(System.in);
        int fila;
        switch (opcion) {
            case 1:
                mostrarTablero();
                break;
            case 2:
                System.out.println("¿Cuantas cartas quieres mover?");
                cuantas = lector.nextInt();
                do {
                    System.out.println("¿A que fila?");
                    filaMover = lector.nextInt();
                } while (comprobarFilaLLena(filaMover) == false);
                
                for (int i = 0; i < cuantas; i++) {
                    moverCartaFila(elegirCarta());
                }
                break;
            case 3:
                moverCartaMonton(elegirCarta());
                break;
            case 4:
                sacarCartaPila();
                break;
            case 5:
                if (comprobarVictoria() == true) {
                    System.out.println("Felicidades has ganado!!!!!");
                    opcion = 6;
                } else {
                    System.out.println("Aun no has conseguido ganar");
                }

                break;
            case 6:
                System.out.println("Adios");
                break;
        }
    }
    
    public static void borrarCarta(){
        switch (filaCogida) {
            case 1:
                primera -= cuantas;
                break;
            case 2:
                segunda -= cuantas;
                cont2 -= cuantas;
                break;
            case 3:
                tercera -= cuantas;
                cont3 -= cuantas;
                break;
            case 4:
                cuarta -= cuantas;
                cont4 -= cuantas;
                break;
            case 5:
                quinta -= cuantas;
                cont5 -= cuantas;
                break;
            case 6:
                sexta -= cuantas;
                cont6 -= cuantas;
                break;
            case 7:
                septima -= cuantas;
                cont7 -= cuantas;
                break;
        }
    }

    public static void prepararCartas() {
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = i + 1;
        }
        int cont = 0;
        for (int i = 1; i <= 13; i++) {
            monton1[cont] = i;
            cont++;
        }
        cont = 0;
        for (int i = 14; i <= 26; i++) {
            monton2[cont] = i;
            cont++;
        }
        cont = 0;
        for (int i = 27; i <= 39; i++) {
            monton3[cont] = i;
            cont++;
        }
        cont = 0;
        for (int i = 40; i <= 52; i++) {
            monton4[cont] = i;
            cont++;
        }
    }

    public static void barajar() {
        Random r = new Random();
        for (int i = 0; i < cartas.length; i++) {
            int posAleatoria = r.nextInt(cartas.length);
            int temp = cartas[i];
            cartas[i] = cartas[posAleatoria];
            cartas[posAleatoria] = temp;
        }
    }

    public static void colocarEnTablero() {
        int cont = 0;
        for (int i = 0; i < primera; i++) {
            fila1[i] = cartas[cont];
            cont++;
        }
        for (int i = 0; i < segunda; i++) {
            fila2[i] = cartas[cont];
            cont++;
        }
        for (int i = 0; i < tercera; i++) {
            fila3[i] = cartas[cont];
            cont++;
        }
        for (int i = 0; i < cuarta; i++) {
            fila4[i] = cartas[cont];
            cont++;
        }
        for (int i = 0; i < quinta; i++) {
            fila5[i] = cartas[cont];
            cont++;
        }
        for (int i = 0; i < sexta; i++) {
            fila6[i] = cartas[cont];
            cont++;
        }
        for (int i = 0; i < septima; i++) {
            fila7[i] = cartas[cont];
            cont++;
        }
        for (int i = 0; i < pila.length; i++) {
            pila[i] = cartas[cont];
            cont++;
        }
    }

    public static void mostrarTablero() {
        System.out.print("Fila 1: ");
        for (int i = 0; i < primera; i++) {
            System.out.print(fila1[i] + " ");
        }
        System.out.println("");
        System.out.print("Fila 2: ");
        for (int i = 0; i < segunda; i++) {
            if (i >= cont2) {
                System.out.print(fila2[i] + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println("");
        System.out.print("Fila 3: ");
        for (int i = 0; i < tercera; i++) {
            if (i >= cont3) {
                System.out.print(fila3[i] + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println("");
        System.out.print("Fila 4: ");
        for (int i = 0; i < cuarta; i++) {
            if (i >= cont4) {
                System.out.print(fila4[i] + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println("");
        System.out.print("Fila 5: ");
        for (int i = 0; i < quinta; i++) {
            if (i >= cont5) {
                System.out.print(fila5[i] + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println("");
        System.out.print("Fila 6: ");
        for (int i = 0; i < sexta; i++) {
            if (i >= cont6) {
                System.out.print(fila6[i] + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println("");
        System.out.print("Fila 7: ");
        for (int i = 0; i < septima; i++) {
            if (i >= cont7) {
                System.out.print(fila7[i] + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println("");
        System.out.print("Pila: ");
        for (int i = 0; i < cuentaPila; i++) {
            System.out.print(pila[i] + " ");
        }
        System.out.println("");
        System.out.print("Monton 1: ");
        for (int i = 0; i < m1; i++) {
            System.out.println(monton1[i] + " ");
        }
        System.out.println("");
        System.out.print("Monton 2: ");
        for (int i = 0; i < m2; i++) {
            System.out.println(monton2[i] + " ");
        }
        System.out.println("");
        System.out.print("Monton 3: ");
        for (int i = 0; i < m3; i++) {
            System.out.println(monton3[i] + " ");
        }
        System.out.println("");
        System.out.print("Monton 4: ");
        for (int i = 0; i < m4; i++) {
            System.out.print(monton4[i] + " ");
        }
        System.out.println("");
    }

    public static void sacarCartaPila() {
        if (cuentaPila == 24) {
            cuentaPila = 0;
        }
        cuentaPila++;
    }

    public static int elegirCarta() {
        Scanner lector = new Scanner(System.in);
        System.out.println("De donde quieres coger la carta: ");
        System.out.println("1. De una fila \n"
                + "2. De la pila");
        int elegir = lector.nextInt();
        switch (elegir) {
            case 1:
                System.out.println("De que fila: ");
                filaCogida = lector.nextInt();
                borrarCarta();
                switch (filaCogida) {
                    case 1:
                        System.out.println("¿Que carta quieres mover?");
                        int carta = lector.nextInt();
                        return fila1[carta - 1];
                    case 2:
                        System.out.println("¿Que carta quieres mover?");
                        carta = lector.nextInt();
                        return fila2[carta - 1];
                    case 3:
                        System.out.println("¿Que carta quieres mover?");
                        carta = lector.nextInt();
                        return fila3[carta - 1];

                    case 4:
                        System.out.println("¿Que carta quieres mover?");
                        carta = lector.nextInt();
                        return fila4[carta - 1];
                    case 5:
                        System.out.println("¿Que carta quieres mover?");
                        carta = lector.nextInt();
                        return fila5[carta - 1];
                    case 6:
                        System.out.println("¿Que carta quieres mover?");
                        carta = lector.nextInt();
                        return fila6[carta - 1];
                    case 7:
                        System.out.println("¿Que carta quieres mover?");
                        carta = lector.nextInt();
                        return fila7[carta - 1];
                }
                break;
            case 2:
                int cartaMovida = pila[cuentaPila];
                pila[cuentaPila] = 0;
                return cartaMovida;
        }
        return 0;
    }

    public static void moverCartaMonton(int carta) {
        Scanner lector = new Scanner(System.in);
        System.out.println("A que montón quieres moverla: ");
        int monton = lector.nextInt();

        switch (monton) {
            case 1:
                if (monton1[m1] == carta) {
                    m1++;
                }
                break;
            case 2:
                if (monton2[m2] == carta) {
                    m2++;
                }
                break;
            case 3:
                if (monton3[m3] == carta) {
                    m3++;
                }
            case 4:
                if (monton4[m4] == carta) {
                    m4++;
                }
        }
    }

    public static void moverCartaFila(int carta) {
        Scanner lector = new Scanner(System.in);
        switch (filaMover) {
            case 1:
                if (fila1[primera - 1] == (carta + 1)) {
                    fila1[primera] = carta;
                    primera++;
                }
                break;
            case 2:
                if (fila2[segunda - 1] == (carta + 1)) {
                    fila2[segunda] = carta;
                    segunda++;
                }
                break;
            case 3:
                if (fila3[tercera - 1] == (carta + 1)) {
                    fila3[tercera] = carta;
                    tercera++;
                }
                break;
            case 4:
                if (fila4[cuarta - 1] == (carta + 1)) {
                    fila4[cuarta] = carta;
                    cuarta++;
                }
                break;
            case 5:
                if (fila5[quinta - 1] == (carta + 1)) {
                    fila5[quinta] = carta;
                    quinta++;
                }
                break;
            case 6:
                if (fila6[sexta - 1] == (carta + 1)) {
                    fila6[sexta] = carta;
                    sexta++;
                }
                break;
            case 7:
                if (fila7[septima - 1] == (carta + 1)) {
                    fila7[septima] = carta;
                    septima++;
                }
                break;
        }
    }

    public static void main(String[] args) {

        prepararCartas();
        barajar();
        colocarEnTablero();
        int opcion;
        do {
            opcion = menu();
            realizaAccion(opcion);
            System.out.println("");
        } while (opcion != 6);

    }

}
