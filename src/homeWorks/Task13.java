package homeWorks;

/*
Массивы
Создать последовательность случайных чисел,
найти и вывести наибольшее из них.
 */

import java.util.Random;

public class Task13 {
    public static void main(String[] args) {

        Random rnd = new Random();
        int[] nums = new int[rnd.nextInt(10)+10];

        System.out.print("\nМассив случайных чисел : ");

        // Заполнение массива случайных чисел
        for (int i=0; i< nums.length; i++) {
            nums[i] = rnd.nextInt(1000);
            System.out.print(" " + nums[i]);
        }

        // Поиск максимального значения
        int max = nums[0];
        for (int i=1; i< nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        System.out.print("\nМаксимальное значение массива = " + max);
    }
}
