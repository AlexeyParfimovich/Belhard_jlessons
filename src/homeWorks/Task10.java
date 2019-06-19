package homeWorks;

/*
Циклы
Посчитать факториал числа в границах от 10 до 15 (не используя рекурсию).
 */

import java.util.Random;

public class Task10 {
    public static void main(String[] args) {

        Random rnd = new Random();

        int factorial = 1;
        int x = rnd.nextInt(5)+10;

        System.out.print("Факториал числа " + x + "! = ");
        for (int i=1; i<=x; i++) {
            System.out.print(i+"*");
            factorial *= i;
        }

        System.out.print("= " + factorial);
    }
}
