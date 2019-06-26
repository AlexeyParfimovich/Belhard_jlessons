package homeWorks;

/*
Регулярные выражения
Выполнить поиск в строке

всех <p> тегов абзацев < /p>, в т.ч. <p id=”p1” > тех </p >, у которых есть параметры, например <p id=”p2”>,

и заменить их на простые теги абзацев <p>
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task23 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input a string with <p> tags:");

        // Скопировать и вставить строку из комментрия в заголовке
        String str = sc.nextLine();
        sc.close();

        // Регулярное выражение для выделения тегов абзацев
        Pattern regexp = Pattern.compile("<[ ]*[pP][ ]+[^<>/]*>");
        Matcher mstr = regexp.matcher(str);

        // Замена найденных "сложных" тегов на "простые"
        System.out.println(mstr.replaceAll("<p>"));
    }
}
