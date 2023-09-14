package epd_evaluable_al1;

import java.util.*;


public class Epd_evaluable_al1 {


    public static void main(String[] args) {
        // TODO code application logic here

        int[][] m1 = new int[2][4];
        int[][] m2 = new int[2][4];
        double tiempoIn;
        double tiempoFin;

        m1[0][0] = 0;
        m1[0][1] = 1;
        m1[0][2] = 2;
        m1[0][3] = 3;
        m1[1][0] = 4;
        m1[1][1] = 5;
        m1[1][2] = 6;
        m1[1][3] = 7;

        m2[0][0] = 0;
        m2[0][1] = 1;
        m2[0][2] = 2;
        m2[0][3] = 3;
        m2[1][0] = 4;
        m2[1][1] = 5;
        m2[1][2] = 6;
        m2[1][3] = 7;

        long startMat = System.nanoTime();
        boolean res = sonMatricesIguales(m1, m2, 2);
        long stopMat = System.nanoTime();
        double tRecMat = ((double) (stopMat - startMat)) / 1000_000_000;       
        if (res) {
            System.out.println("Las matrices son iguales.");
        } else {
            System.out.println("Las matrices son distintas.");
        }
        System.out.println("El código ha tardado " + tRecMat + " segundos en comparar las dos matrices.");
    }

    public static boolean sonMatricesIguales(int[][] matriz1, int[][] matriz2, int fila) {
        if (fila - 1 == 0) {
            return sonIguales(matriz1[0], matriz2[0]);
        } else {
            if (sonIguales(matriz1[fila - 1], matriz2[fila - 1])) {
                return sonMatricesIguales(matriz1, matriz2, fila - 1);
            } else {
                return false;
            }

        }
    }

    public static boolean sonIguales(int[] vector1, int[] vector2) {
        double tRec;
        long start = System.nanoTime();
        if (vector1.length == 0) {
            long stop = System.nanoTime();
            tRec = ((double) (stop - start)) / 1000_000_000;
            System.out.println("---- El método recursivo ha tardado " + tRec + " segundos en comparar las filas ----");
            return true;
        } else {
            if (vector1[vector1.length - 1] == vector2[vector2.length - 1]) {
                return sonIguales(Arrays.copyOfRange(vector1, 0, vector1.length - 1), Arrays.copyOfRange(vector2, 0, vector2.length - 1));
            } else {
                long stop = System.nanoTime();
                tRec = ((double) (stop - start)) / 1000_000_000;
                System.out.println("---- El método recursivo ha tardado " + tRec + " segundos en comparar las filas ---- ");
                return false;
            }

        }

    }
}
