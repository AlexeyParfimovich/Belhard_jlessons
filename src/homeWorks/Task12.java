package homeWorks;

/*
Циклы
Найдите сумму первых n целых чисел, которые делятся на 3.
 */

import java.util.Random;

public class Task12 {
    public static void main(String[] args) {

        Random rnd = new Random();

        int sum = 0;
        int x = rnd.nextInt(19)+1;  // количество суммируемых чисел

        System.out.println("Сумма первых " + x + " чисел, которые делатся на 3:");

        for (int i=1; i<=x; i++) {
            sum += i*3;
            System.out.print(i*3 + "+");
        }

        System.out.print(" = " + sum);
    }
}
