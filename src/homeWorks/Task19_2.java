package homeWorks;

/*
Строки
Подсчитать количество слов разделенных пробелами и знаками препинания.
*/

import java.util.Scanner;

public class Task19_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input a string:");
        String str = sc.nextLine();
        sc.close();

        int wordsNum = 0;                                                                                                // Счетчик количества слов
        //int wordStartPos = 0;                                                                                            // Позиция начала слова в строке
        String punctMarks = "[ ,.:;!?-]+";                                                                                  // Множество разделителей слов

        // Разбивка строки на слова с использованием регулярных выражений
        String[] parts = str.split(punctMarks);
        wordsNum = parts.length;

/*
        // Поиск слов между разделителями - не оптимальный вариант c использованием цикла
        for(int i = 0; i < str.length(); i++) {
            // Проверка если символ в строке есть множестве разделителей
            if (punctMarks.indexOf(str.charAt(i)) >= 0) {

                if (i > wordStartPos) {
                    wordsNum++;
                    wordStartPos = i+1;
                } else {
                    wordStartPos++;
                }
            }
        }

        // если последнее слово в стоке не закончилось разделителем
        if (wordStartPos < str.length()) {
            wordsNum++;
        }
*/
        System.out.println("\nThere are " + wordsNum + " words in the string");
    }
}