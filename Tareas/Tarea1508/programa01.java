package fund_progra;

import java.util.Scanner;
import java.util.regex.Pattern;

public class programa01 {

    public static void main(String[] args) {
        Scanner intro = new Scanner(System.in);
        System.out.println("Encuesta sobre opinion");
        int c = 0;
        System.out.println("Cantidad de personas a encuestar?");
        int x = intro.nextInt();
        char array[][] = new char[2][x];
        do {
            System.out.println("Ingresar datos");
            c++;
            dato_h_m(array, c, intro);
        } while (c < x);
        System.out.println("Mostrando Estadisticas");
        calculo(array, intro, x);
    }

    public static void dato_h_m(char array[][], int c, Scanner intro) {
        char resp1,resp2;
        int m = 0, f = 0;
        do {
            System.out.println("Elegir opcion (m)Masculino (f)Femenino");
            resp1 = intro.next().charAt(0);
        } while (validacion(resp1)==false);
        if (resp1 == 'm') {
            do{
            System.out.println("Aprueba la gestion del gobierno?");
            System.out.println("(s)Si (n)No (x)no sabe o no responde");
            resp2=intro.next().charAt(0);
            array[0][c - 1] = intro.next().charAt(0);
            array[1][c - 1] = 'O';
            }while(validacion2(resp2)==false);
        } else if (resp1 == 'f') {
            do{
            System.out.println("Aprueba la gestion del gobierno?");
            System.out.println("(s)Si (n)No (x)no sabe o no responde");
            resp2=intro.next().charAt(0);
            array[1][c - 1] = intro.next().charAt(0);
            array[0][c - 1] = 'O';
            }while(validacion2(resp2)==false);
        }
    }

    public static void calculo(char array[][], Scanner intro, int x) {
        int m = 0, ms = 0, mn = 0, mx = 0, f = 0, fs = 0, fn = 0, fx = 0;
        for (int z = 0; z < x; ++z) {
            if (array[0][z] != 'O') {
                m++;
                if (array[0][z] == 's') {
                    ms++;
                } else if (array[0][z] == 'n') {
                    mn++;
                } else if (array[0][z] == 'x') {
                    mx++;
                }
            }
        }
        for (int z = 0; z < x; ++z) {
            if (array[1][z] != 'O') {
                f++;
                if (array[1][z] == 's') {
                    fs++;
                } else if (array[1][z] == 'n') {
                    fn++;
                } else if (array[1][z] == 'x') {
                    fx++;
                }
            }
        }

        System.out.println("Participaron " + (m + f) + " personas");
        System.out.println(ms + " Hombres aprueban la gestion del gobierno");
        System.out.println(fn + " Mujeres desaprueban la gestion del gobierno");
        System.out.println((((ms + fs) * 100) / (m + f)) + " % de los encuestados aprueba la gestion de gobierno");
    }

    public static boolean validacion(char resp1) {
        if (Character.toString(resp1).matches("^[mf]*$")) {
            return true;
        } else {
            System.out.println("respuesta invalidad, ingresar letra (m) o (f)");
            return false;
        }
    }
    public static boolean validacion2(char resp2) {
        if (Character.toString(resp2).matches("^[snx]*$")) {
            return true;
        } else {
            System.out.println("respuesta invalidad, ingresar letra (s) o (n) o (x)");
            return false;
        }
    }
    

}
