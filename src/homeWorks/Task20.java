package homeWorks;

/*
Строки
Имеется строка с текстом. Вывести текст, составленный из последних букв всех слов.
*/

import java.util.Scanner;

public class Task20 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease, input a string:");
        String str = sc.nextLine();
        sc.close();

        int wordStartPos = 0;                                                                                            // Позиция начала слова в строке
        String punctMarks = ",.:;-!? ";                                                                                  // Множество разделителей слов

        System.out.print("\nThe last letters of each word in a line: ");

        for(int i = 0; i < str.length(); i++) {
            // Проверка если символ в строке есть множестве разделителей
            if (punctMarks.indexOf(str.charAt(i)) >= 0) {

                if (i > wordStartPos) {
                    System.out.print(str.charAt(i-1));
                    wordStartPos = i+1;
                } else {
                    wordStartPos++;
                }
            }
        }

        // если последнее слово в стоке не закончилось разделителем
        if (wordStartPos < str.length()) {
            System.out.print(str.charAt(str.length()-1));
        }
    }
}
