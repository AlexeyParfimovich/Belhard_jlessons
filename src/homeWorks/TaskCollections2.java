package homeWorks;

/*
Коллекции
Написать класс, который умеет хранить в себе массив любых типов данных (int, long etc.).
Реализовать метод get(int index), который возвращает любой элемент массива по индексу.

Решение задачи см. в Task28
*/

import java.util.Random;

public class TaskCollections2 {
    public static void main(String[] args) {
        Random rnd = new Random();

        weakTypingArray<Integer> arr1 = new weakTypingArray<>(10);

        for (int i=0; i < arr1.getLength(); i++){
            arr1.setValue(i, rnd.nextInt());
        }

        for (int i=0; i < arr1.getLength(); i++){
            System.out.print(" " + arr1.getValue(i));
        }
    }
}
