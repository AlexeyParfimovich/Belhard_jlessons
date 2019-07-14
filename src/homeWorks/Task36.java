package homeWorks;

/*
Файлы
Вывести список файлов и каталогов выбранного каталога на диске.
Файлы и каталоги должны быть распечатаны отдельно.
*/

import java.io.File;
import java.util.Scanner;

public class Task36 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        File file = new File(".");

        System.out.println("\n" + file.getAbsolutePath());

        System.out.println("<DIR> ..");
        for(File fl:file.listFiles()) {
            if (fl.isDirectory()) {
                System.out.println("<DIR> "+fl.getName().toUpperCase());
            }
        }
        for(File fl:file.listFiles()) {
            if (fl.isFile()) {
                System.out.println("<file> "+fl.getName());
            }
        }

        sc.close();
    }
}
