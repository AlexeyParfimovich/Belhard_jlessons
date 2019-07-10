package homeWorks;

/*
Коллекции
Имеется текст. Следует составить для него частотный словарь.
*/

import java.util.HashMap;
import java.util.Map;

public class Task32 {
    public static void main(String[] args) {

        String text = "сюда надо вставить какой-нибудь текст, и сюда надо-бы, и вот сюда тоже. А сюда не надо!";

        Map<String, Integer> wordMap = new HashMap<>();

        // Разделители слов
        String punctMarks = "[ ,.:;!?-]+";

        // Разбивка строки на слова с использованием регулярных выражений
        String[] textParts = text.split(punctMarks);

        // Составление частотного словаря
        for(String word: textParts){
            Integer value = wordMap.get(word);
            if(value == null){
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, value + 1);
            }
        }

        System.out.println("Frequency dictionary of the text:");
        System.out.println(wordMap);
    }
}
