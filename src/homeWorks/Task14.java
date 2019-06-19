package homeWorks;

/*
Массивы
Создать массив оценок произвольной длины,
вывести максимальную и минимальную оценку, её (их) номера.
 */

import java.util.Random;

public class Task14 {
    public static void main(String[] args) {

        int iMax = 0;
        int iMin = 0;

        Random rnd = new Random();
        int[] marks = new int[rnd.nextInt(10)+10];

        System.out.print("\nМассив оценок (" + marks.length + " элементов) номер/значение: ");

        // Заполнение массива случайных чисел
        for (int i=0; i< marks.length; i++) {
            marks[i] = rnd.nextInt(1000);
            System.out.print(" " + (i+1) + "/" + marks[i]);
        }

        // Поиск максимальной и минимальной оценок
        for (int i=1; i< marks.length; i++) {

            if (marks[iMax] < marks[i]) {
                iMax = i;
            }
            if (marks[iMin] > marks[i]) {
                iMin = i;
            }

        }
        System.out.print("\nМаксимальная оценка - №" + (iMax+1) + " = " + marks[iMax]);
        System.out.print("\nМинимальная оценка - №" + (iMin+1) + " = " + marks[iMin]);
    }
}
