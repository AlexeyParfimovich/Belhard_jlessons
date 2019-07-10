package homeWorks;

/*
Коллекции
Создать список оценок учеников с помощью ArryList, заполнить случайными оценками.
Найти самую высокую оценку с использованием итератора.
*/

import java.util.*;

public class Task31 {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        Random rnd = new Random();

        int maxValue =0;

        for(int i=0; i<20; i++){
            marks.add(rnd.nextInt(4)+1);
        }
        System.out.println("All students marks:");
        System.out.println(marks);

// Найти максимальное значение в списке можно так:
//        Iterator<Integer> itr = marks.iterator();
//        while(itr.hasNext()){
//            int value = itr.next().intValue();
//            if(value > maxValue){
//                maxValue = value;
//            }
//        }

        // можно так:
//        maxValue = Collections.max(marks);


        // или так:
//        marks.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer i1, Integer i2) {
//                return i2.compareTo(i1);
//            }
//        });

        // или вот так (самый модный способ):
        marks.sort((Integer i1, Integer i2)->i2.compareTo(i1));

        System.out.print("The maximum value is ");
        //System.out.println(maxValue);
        System.out.println(marks.get(0).intValue());
    }
}
