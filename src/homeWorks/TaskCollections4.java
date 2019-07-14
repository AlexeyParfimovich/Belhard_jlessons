package homeWorks;

/*
Коллекции
Написать методы union(Set set1, Set set2) и intersect(Set set1, Set set2), реализующих операции объединения и пересечения двух множеств.
Протестировать работу методов на двух предварительно заполненных множествах.
(Вам понадобится написать вспомогательный метод, выводящий все элементы множества в консоль).
Под пересечением следует понимать выделение в коллекцию объектов, содержащихся в каждой из коллекций (т.е. одинаковых элементов, встречающихся в каждой коллекции).
Например:
Коллекция 1: 1,2,3,5,7,8
Коллекция 2: 1,6,9,14,3,7
Результат работы union: 1,2,3,5,7,8,1,6,9,14,3,7
Результат работы intersect: 1,3,7
*/

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TaskCollections4 {

    public static <S extends Set> S union(S set1, S set2, Class<S> sClass){
        try {
            S set = sClass.getDeclaredConstructor().newInstance();

            set.addAll(set1);
            set.addAll(set2);

            return set;

        } catch(Exception Ex){
            System.out.println(Ex);
            return null;
        }
    }

    public static <S extends Set> S intersect(S set1, S set2, Class<S> sClass){
        try {
            S set = sClass.getDeclaredConstructor().newInstance();

            set.addAll(set1);
            set.retainAll(set2);

            return set;

        } catch(Exception Ex){
            System.out.println(Ex);
            return null;
        }
    }

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Collections.addAll(set1,1,2,3,5,7,8);
        Collections.addAll(set2,1,6,9,14,3,7);

        System.out.print("Set 1: ");
        System.out.println(set1);

        System.out.print("Set 2: ");
        System.out.println(set2);

        System.out.print("Sets union: ");
        System.out.println(union(set1,set2, (Class)set1.getClass()));

        System.out.print("Sets intersect: ");
        System.out.println(intersect(set1,set2, (Class)set1.getClass()));

    }
}
