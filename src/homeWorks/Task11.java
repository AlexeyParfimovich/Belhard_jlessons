package homeWorks;

/*
Циклы
Имеется целое число, определить является ли это число простым,
т.е. делится без остатка только на 1 и себя.

Решение 1 - необходимо проверить деление без остатка для всех делителей
от 2 до округленного значеия корня квадратного из Х

Решение 2 - необходимо проверить деление без остатка для всех делителей
от 2 до Х/2

 */

import java.util.Random;

public class Task11 {
    public static void main(String[] args) {

        Random rnd = new Random();

        int x = rnd.nextInt(99)+1;
        int maxDivider =  (int)Math.ceil(Math.sqrt(x));

        System.out.print("Число " + x + " простое ?  Проверим:");

        /*
        // Решение 1
        for (int i=2; i<=maxDivider; i++) {
            System.out.print("\n - проверяем деление на " + i);

            if(x%i == 0){
                System.out.print("\nЧисло " + x + " не простое, т.к. делится без остатка на " + i);
                return;
            } else {
                System.out.print(" - не делится!");
            }
        }

        System.out.print("\nЧисло " + x + " простое!");
        */
        // Решение 2
        for (int i=2; i<x/i; i++) {
            System.out.print("\n - проверяем деление на " + i);

            if(x%i == 0){
                System.out.print("\nЧисло " + x + " не простое, т.к. делится без остатка на " + i);
                return;
            } else {
                System.out.print(" - не делится!");
            }
        }

        System.out.print("\nЧисло " + x + " простое!");

    }
}
