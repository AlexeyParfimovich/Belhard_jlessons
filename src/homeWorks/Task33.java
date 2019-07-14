package homeWorks;

/*
Файлы
Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
*/

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task33 {

    public static void main(String[] args) {

        File file = new File("text.txt");
        StringBuffer text = new StringBuffer();

        // Проверка наличия файла. Если файл не найден - создание файла
        if(!file.exists()) {
            System.out.println("The file " + file.getName() + " is not found - it will be created");

            try {
                file.createNewFile();
            } catch(Exception Ex) {
                System.out.println("The file could not be created! The app will be terminated");
                return;
            }
        } else {
            System.out.println("The file " + file.getName() + " is found");
            System.out.println("The file size is " + file.length());
        }

        // Если файл пустой - заполнение файла данными
        if(file.length()==0) {
            if (!file.canWrite()) {
                System.out.println("The file is empty and can't be written. The app will be terminated");
                return;
            } else {
                System.out.println("The file is empty and will be filled with data");

                try (FileWriter writer = new FileWriter(file, true)) {

                    writer.write("Всё, всё, шо нажил непосильным трудом, всё же погибло! 3.5 магнитофона, 3.5 кинокамеры заграничных, 4 портсигара отечественных, " +
                                     "куртка… замшевая… 4 Куртки. И они ещё борются за почётное звание «дома высокой культуры быта», а?");
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
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

                // Подсчет количества знаков препинания
                Pattern pattern = Pattern.compile("[.,;:!?-]");
                Matcher matcher = pattern.matcher(text);
                int matches = 0;
                while (matcher.find()) {
                    matches++;
                }
                System.out.println("Number of punctuation marks is " + matches);

                // Подсчет количества слов
                pattern = Pattern.compile("[0-9а-яА-ЯёЁ]+");
                matcher = pattern.matcher(text);
                matches = 0;
                while (matcher.find()) {
                    matches++;
                }
                System.out.println("Number of words is " + matches);

            } catch(IOException ex){
                System.out.println(ex);
            }
        }
    }
}
