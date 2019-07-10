package homeWorks;

/*
Коллекции
Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
Удалить неудовлетворительные оценки из списка.
*/

import java.util.*;

public class Task29 {
    public static void main(String[] args) {

        List<Integer> marks = new ArrayList<>();
        Random rnd = new Random();

        for(int i=0; i<20; i++){
            marks.add(rnd.nextInt(4)+1);
        }
        System.out.println("All students marks:");
        System.out.println(marks);

        Iterator<Integer> itr = marks.iterator();
        while(itr.hasNext()){
            if(itr.next().intValue()<3){
                itr.remove();
            }
        }
// Результат не верный!
// Для получения правильного результата необходио после каждого удаления начинать перебор сначала!
//        for(int i=0; i<marks.size(); i++){
//            if(marks.get(i).intValue() < 3){
//                marks.remove(i);
//            }
//        }

        System.out.println("Only good marks:");
        System.out.println(marks);
    }
}
