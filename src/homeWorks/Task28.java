package homeWorks;

/*
Классы
Написать класс, который умеет хранить в себе массив любых типов данных (int, long, etc.).
Реализовать метод get(int index), который возвращает любой элемент массива по индексу.
*/

import java.util.Random;

class weakTypingArray <Type extends Number> {

    private Number[] array;

    public weakTypingArray(Integer index) {
        array = new Number[index];
    }

    public int getLength(){
        return array.length;
    }

    public Type getValue(int index) {
        return (Type)array[index];
    }

    public void setValue(int index, Type value) {
        array[index] = value;
    }
}

public class Task28 {
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
