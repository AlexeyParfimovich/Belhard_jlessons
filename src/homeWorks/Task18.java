package homeWorks;

/*
Строки
Найти в строке все знаки препинания и тире. Подсчитать их общее количество.
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task18 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input a string with different punctuation marks:");
        String str = sc.nextLine();
        sc.close();

        Pattern regexp = Pattern.compile("[,.:;!?-]");
        Matcher mstr = regexp.matcher(str);

        int marksNum = 0;

        // Поиск знаков препинания - через регулярные выражения
        while(mstr.find()) {
            marksNum++;
        }
/*
        // Поиск знаков препинания - не оптимальный вариант методом перебора всех символов строки
        for(int i = 0;i < str.length(); i++){

            switch (str.charAt(i)) {
                case ',' : marksNum++; break;
                case '.' : marksNum++; break;
                case ':' : marksNum++; break;
                case ';' : marksNum++; break;
                case '-' : marksNum++; break;
                case '!' : marksNum++; break;
                case '?' : marksNum++; break;
                case '(' : marksNum++; break;
                case ')' : marksNum++; break;
                case '"' : marksNum++; break;
            };
        }
*/

        System.out.println("\nThere are " + marksNum + " different punctuation marks in the string");
    }
}
