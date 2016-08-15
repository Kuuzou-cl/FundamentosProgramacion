package fund_progra;

import java.util.Random;

public class programa02 {

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Ejercicio 2");
        System.out.println("Cuadrado magico");
        //generar array
        int array[][] = new int[3][3];
        random(array, rand);
        mostrar(array);
        System.out.println("Es un cuadrado magico?");
        magic(array);
    }
    public static void random(int array[][], Random rand) {
        int array2[] = new int[9];
        int x = 0;
        for (int z = 0; z < 3; z++) {
            for (int j = 0; j < 3; j++) {
                int cont;
                do {
                    cont = 0;
                    array2[x] = (int) (rand.nextDouble() * 9 + 1);
                    for (int c = 0; c < 9; c++) {
                        if (array2[c] == array2[x]) {
                            cont++;
                        }
                    }
                    array[z][j] = array2[x];
                } while (cont != 1);
                x++;
            }
        }
    }
    public static void mostrar(int array[][]) {
        for (int z = 0; z < 3; z++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(+array[z][j] + "\t");
            }
            System.out.print("\n");
        }
    }
    public static void magic(int array[][]){
        if(array[0][0] + array[1][0] + array[2][0] != 15){
            System.out.println("No es un cuadrado magico :c");
        }else{
            if(array[0][1] + array[1][1] + array[2][1] != 15){
                System.out.println("No es un cuadrado magico :c");
            }else{
                if(array[0][2] + array[1][2] + array[2][2] != 15){
                    System.out.println("No es un cuadrado magico :c");
                }else{
                    if(array[0][0] + array[0][1] + array[0][2] != 15){
                        System.out.println("No es un cuadrado magico :c");
                    }else{
                        if(array[1][0] + array[1][1] + array[1][2] != 15){
                            System.out.println("No es un cuadrado magico :c");
                        }else{
                            if(array[2][0] + array[2][1] + array[2][2] != 15){
                                System.out.println("No es un cuadrado magico :c");
                            }else{
                                if(array[0][0] + array[1][1] + array[2][2] != 15){
                                    System.out.println("No es un cuadrado magico :c");
                                }else{
                                    if(array[0][2] + array[1][1] + array[2][0] != 15){
                                        System.out.println("No es un cuadrado magico :c");
                                    }else{
                                        System.out.println("Es un cuadrado magico!");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
