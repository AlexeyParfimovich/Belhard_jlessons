package homeWorks;

/*
Массивы
Создать двухмерный квадратный массив, и заполнить его «бабочкой»
*/

import java.util.Random;

public class Task17 {
    public static void main(String[] args) {

        Random rnd = new Random();
        int length = rnd.nextInt(5)+5;

        // Создание квадратного массива
        int[][] arr = new int[length][];
        for (int i=0; i< arr.length; i++) {
            arr[i] = new int[length];
        }

        // Заполнение массива бабочкой
        for (int i=0; i< arr.length/2+1; i++) {

            for(int j=0; j < i+1; j++){

                arr[i][j] = 1;
                arr[i][length-1-j] = 1;

                arr[length-1-i][j] = 1;
                arr[length-1-i][length-1-j] = 1;

            }
        }

        // Вывод массива
        for (int i=0; i< arr.length; i++) {

            for(int j=0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }


    }
}
