package homeWorks;

/*
Регулярные выражения
Выполнить поиск в строке шестнадцатеричных чисел, записаных по правилам Java,
с помощью регулярных выражений и вывести их на экран.
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input a string with hexadecimal numbers:");
        String str = sc.nextLine();
        sc.close();

        Pattern regexp = Pattern.compile("0[xX][0-9a-fA-F]+");
        Matcher mstr = regexp.matcher(str);

        // Поиск и вывод шестнадцатиричных чисел
        while(mstr.find()) {
            System.out.println(mstr.group());
        }
    }
}