package homeWorks;

/*
Циклы
посчитать факториал случайного числа.
 */

import java.util.Random;

public class Task9 {
    public static void main(String[] args) {

        Random rnd = new Random();

        int factorial = 1;
        int x = rnd.nextInt(9);

        System.out.print("Факториал числа " + x + "! = ");
        for (int i=1; i<=x; i++) {
            System.out.print(i+"*");
            factorial *= i;
        }

        System.out.print("= " + factorial);

    }
}
