package homeWorks;

/*
Коллекции
Написать метод для конвертации массива строк/чисел в список.
Желательно использовать реализацию функционального интерфейса, содержащего метод: List <T> convert(T [] objectArray).
*/

import java.util.Random;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Convertible<T>{
    List <T> convert(T [] objectArray);
}

public class TaskCollections1 {
    public static void main(String[] args) {

        List<Integer> list;

        Random rnd = new Random();

        // Создание и заполнение случайного массива целых чисел
        Integer[] arr = new Integer[rnd.nextInt(20)+20];

        for(int i=0; i<arr.length; i++){
            arr[i] = rnd.nextInt(99);
        }

        System.out.println("Random array of random integers:");
        for(Integer val: arr){
            System.out.print(" " + val.intValue() + ",");
        }

        // Конвертация массива в список (ЭТА КРУТАЯ МАГИЯ - НЕ СПРАШИВАЙ КАК РАБОТАЕТ)
        Convertible<Integer> converter = objectArray -> Arrays.asList(objectArray);
        list = converter.convert(arr);

        System.out.println("\nList converted from an array of integers:");
        System.out.println(list);
    }
}
