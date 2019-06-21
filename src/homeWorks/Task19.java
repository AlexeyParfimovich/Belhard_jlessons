package homeWorks;

/*
Строки
Подсчитать количество слов разделенных пробелами. Учесть, что слова могут разделяться несколькими пробелами, в начале и конце
текста также могут быть пробелы, но могут и отсутствовать.
*/

import java.util.Scanner;

public class Task19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease, input a string:");
        String str = sc.nextLine();
        sc.close();

        int wordsNum = 0;
        int currPos = 0;
        int lastPos = 0;
        char sep = ' ';

        do {
            lastPos = str.indexOf(sep,currPos);

            if (lastPos > currPos) {
                currPos = lastPos+1;
                wordsNum++;
            } else if (lastPos == currPos) {
                currPos++;
            } else {
                wordsNum++;
                break;
            }

        } while (currPos < str.length());

        System.out.println("\nThere are " + wordsNum + " words in the string");
    }
}
