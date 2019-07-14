package homeWorks;

/*
Файлы
Имеется файл с текстом, в котором присутствуют числа.
Найти все числа, распечатать, посчитать сумму, убрать все повторяющиеся числа и снова распечатать.
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task34 {
    public static void main(String[] args) {

        File file = new File("text.txt");
        StringBuffer text = new StringBuffer();

        // Проверка наличия файла. Если файл не найден - создание файла
        if(!file.exists()) {
            System.out.println("The file not found! The app will be terminated");
            return;
        }

        // Если файл пустой - заполнение файла данными
        if(file.length()==0) {
            System.out.println("The file is empty! The app will be terminated");
            return;
        }

        // Чтение файла и подсчет количество слов и знаков препинания в тексте
        if(!file.canRead()) {
            System.out.println("The file can't be read. The app will be terminated");
            return;
        } else {
            try(FileReader reader = new FileReader(file)) {

                // Чтение текста из файла
                int res;
                while((res=reader.read())!=-1){
                    text.append((char)res);
                }
                reader.close();

                System.out.println("So, the text from the file:");
                System.out.println(text);

                // Поиск чисел в тексте по шаблону
                Pattern pattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
                Matcher matcher = pattern.matcher(text);

                Set<String> set = new HashSet<>();
                Double sum = 0.0;

                System.out.print("\nThe numbers in the text: ");
                while (matcher.find()) {
                    // Отбор неповторяющихся чисел
                    set.add(matcher.group());
                    // Подсчет суммы
                    sum += Double.parseDouble(matcher.group());
                    // Печать чисел из текста
                    System.out.print(" " + matcher.group());
                }
                System.out.println("\nSum of all numbers is " + sum);
                System.out.println("\nOnly non-repeating numbers: " + set);

            } catch(IOException ex){
                System.out.println(ex);
            }
        }
    }
}
