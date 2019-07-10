package homeWorks;

/*
Коллекции
Создать коллекцию, наполнить ее случайными числами.
Удалить повторяющиеся числа.
*/

import java.util.*;

public class Task30 {
    public static void main(String[] args) {

        List<Integer> anyNumners = new ArrayList<>();
        Set<Integer> uniqNumbers = new HashSet<>();
        Random rnd = new Random();

        // Наполнить коллекцию случайными числами
        for(int i=0; i<20; i++){
            anyNumners.add(rnd.nextInt(10));
        }
        System.out.println("All random numbers:");
        System.out.println(anyNumners);

        // Выделить набор уникальных чисел
        for(Integer num: anyNumners){
            uniqNumbers.add(num);
        }
        // Очистить коллекцию
        anyNumners.clear();
        // Заполнить уникальными
        anyNumners.addAll(uniqNumbers);

        System.out.println("Only unique numbers:");
        System.out.println(anyNumners);
    }
}
