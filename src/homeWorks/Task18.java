package homeWorks;

/*
Строки
Найти в строке все знаки препинания и тире. Подсчитать их общее количество.
*/

import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease, input a string with different punctuation marks:");

        String str = sc.nextLine();
        sc.close();

        int marksNum = 0;

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

        System.out.println("\nThere are " + marksNum + " different punctuation marks in the string");
    }
}
