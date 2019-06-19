package homeWorks;

/*
Массивы
Создать массив, заполнить его случайными элементами, распечатать, перевернуть, и снова распечатать
(при переворачивании нежелательно создавать еще один массив).
 */

import java.util.Random;

public class Task15 {
    public static void main(String[] args) {

        int buff = 0;
        Random rnd = new Random();
        int[] nums = new int[rnd.nextInt(10)+10];

        System.out.print("\nМассив случайных чисел в прямом порядке: ");

        // Заполнение массива случайных чисел
        for (int i=0; i< nums.length; i++) {
            nums[i] = rnd.nextInt(100);
            System.out.print(" " + nums[i]);
        }

        // Переворот массива
        for (int i=0; i< nums.length/2; i++) {
            buff = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = buff;
        }

        System.out.print("\nМассив случайных чисел в обратном порядке: ");
        for (int i=0; i< nums.length; i++) {
            System.out.print(" " + nums[i]);
        }

    }
}
