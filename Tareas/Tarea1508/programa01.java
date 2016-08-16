package fund_progra;

import java.util.Scanner;

public class programa01 {

    public static void main(String[] args) {
        Scanner intro = new Scanner(System.in);
        System.out.println("Encuesta sobre opinion");
        int x = 1, resp = 0;
        char array[][] = new char[2][x];
        System.out.println("Ingresar datos");
        do {
            dato_h_m(array, x, intro);
            System.out.println("Ingresar nuevos datos?\n1.-si\n2.-no\n");
            resp = intro.nextInt();
        } while (resp == 1);
        System.out.println("Mostrando Estadisticas");
        calculo(array, intro);
    }

    public static void dato_h_m(char array[][], int x, Scanner intro) {
        char resp1;
        System.out.println("Elegir opcion (m)Masculino (f)Femenino");
        resp1 = intro.next().charAt(0);
        if (resp1 == 'm') {
            System.out.println("Aprueba la gestion del gobierno?");
            System.out.println("(s)Si (n)No (x)no sabe o no responde");
            array[0][x - 1] = intro.next().charAt(0);
        } else if (resp1 == 'f') {
            System.out.println("Aprueba la gestion del gobierno?");
            System.out.println("(s)Si (n)No (x)no sabe o no responde");
            array[1][x - 1] = intro.next().charAt(0);
        }
        x++;
        
    }

    public static void calculo(char array[][], Scanner intro) {
        int H = 0, M = 0, Hs = 0, Md = 0, Ms = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        for (int row = 0; row < array.length; ++row) {
            for (int column = 0; column < array[row].length; ++column) {
                if (array[0][column] == 's') {
                        Hs++;
                    }
                    if (array[0][column] == 's' || array[0][column] == 'n'||array[0][column] == 'x') {
                        H++;
                    }
                    if (array[1][column] == 's' || array[1][column] == 'n'||array[1][column] == 'x') {
                        M++;
                    }
                    if (array[1][column] == 's') {
                        Ms++;
                    }
                    if (array[1][column] == 'n') {
                        Md++;
                    }
            }
        }
        System.out.println("Participaron " + (H + M) + " personas");
        System.out.println(Hs + " Hombres aprueban la gestion del gobierno");
        System.out.println(Md + " Mujeres desaprueban la gestion del gobierno");
        System.out.println((((Hs + Ms) * 100) / (H + M)) + " % de los encuestados aprueba la gestion de gobierno");
    }

}
