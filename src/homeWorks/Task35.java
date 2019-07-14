package homeWorks;

/*
Файлы
Записать в двоичный файл 20 случайных чисел.
Прочитать записанный файл, распечатать числа и их среднее арифметическое.
*/

import java.io.*;
import java.util.Random;

public class Task35 {

    public static void main(String[] args) {

        Random rnd = new Random();
        File file = new File("data.dat");

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
            System.out.println("The file is empty and will be filled with data");
            try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
                for(int i=0; i< 20; i++) {
                    dos.writeDouble(rnd.nextDouble());
                }
                dos.flush();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        // Чтение файла и подсчет среднего арифмитического чисел
         try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
             // Чтение данных из файла
             System.out.println("\nThe following numbers were read:");
             Double res, sum = 0.0;
             int counter = 0;
             do {
                 try {
                     res = dis.readDouble();
                 } catch (EOFException e) {
                     break;
                 }
                 counter++;
                 sum += res;
                 System.out.print(" " +res);
             } while (true);

             // Среднее арифметическое
             if(counter>0) {
                 System.out.print("\nNumber of values read: " + counter);
                 System.out.print("\nSum of values is " + sum);
                 System.out.print("\nThe arithmetic mean is " + sum / counter);
             }

         } catch (Exception ex) {
             System.out.println(ex);
         }
    }
}
