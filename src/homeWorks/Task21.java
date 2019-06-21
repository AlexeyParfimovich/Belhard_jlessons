package homeWorks;

/*
Строки
Имеется строка с текстом. Вывести текст, составленный из последних букв всех слов.
*/


import java.util.Date;

public class Task21 {
    public static void main(String[] args) {

        String str = "12345678909876543211234567890";
        int cnt = 10000;

        String buff1 = "";
        StringBuffer buff2 = new StringBuffer();
        StringBuilder buff3 = new StringBuilder();

        long startTime;
        long finishTime;
        long timeConsumedMillis;

        startTime = System.currentTimeMillis();
        for ( int i=0; i< cnt; i++) {
            buff1 += str;
        }
        finishTime = System.currentTimeMillis();
        System.out.println("\nRun time for String (ms) = " + (finishTime - startTime));

        startTime = System.currentTimeMillis();
        for ( int i=0; i< cnt; i++) {
            buff2.append(str);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("\nRun time for StringBuffer (ms) = " + (finishTime - startTime));

        startTime = System.currentTimeMillis();
        for ( int i=0; i< cnt; i++) {
            buff3.append(str);
        }
        finishTime = System.currentTimeMillis();
        System.out.println("\nRun time for StringBuilder (ms) = " + (finishTime - startTime));

    }
}
