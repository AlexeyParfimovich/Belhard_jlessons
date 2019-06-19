package homeWorks;

/*
Массивы
Определите сумму элементов одномерного массива,
расположенных между минимальным и максимальным значениями.
 */

import java.util.Random;

public class Task16 {
    public static void main(String[] args) {

        int iMax = 0;
        int iMin = 0;
        int sum = 0;

        Random rnd = new Random();
        int[] nums = new int[rnd.nextInt(10)+10];

        System.out.print("\nМассив значений : ");

        // Заполнение массива случайными числами
        for (int i=0; i< nums.length; i++) {
            nums[i] = rnd.nextInt(1000);
            System.out.print(" " + nums[i]);
        }

        // Поиск индексов максимальной и минимальной оценок
        for (int i=1; i< nums.length; i++) {

            if (nums[iMax] < nums[i]) {
                iMax = i;
            }
            if (nums[iMin] > nums[i]) {
                iMin = i;
            }
        }

        // Рассчет суммы значений между минимальным и максимальным
        if (iMin < iMax) {
            for (int i=iMin; i <= iMax; i++) {
                sum += nums[i];
            }
        } else {
                for (int i=iMax; i <= iMin; i++) {
                    sum += nums[i];
                }
            }

        System.out.print("\nМаксимальная оценка - №" + (iMax+1) + " = " + nums[iMax]);
        System.out.print("\nМинимальная оценка - №" + (iMin+1) + " = " + nums[iMin]);
        System.out.print("\nСумма оценок между минимальной и максимальной в массиве (включая минимальную и максимальную) = " + sum);
    }
}
