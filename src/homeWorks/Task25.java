package homeWorks;

/*
Классы
Создать класс и объекты описывающие Банкомат.
Набор купюр находящихся в банкомате должен задаваться тремя свойствами: количеством купюр номиналом 20 50 100.
Сделать методы для добавления денег в банкомат.
Сделать функцию снимающую деньги: на вход передается сумма денег, на выход – булевское значение (операция удалась или нет).
При снятии денег функция должна рапечатывать каким количеством купюр какого номинала выдается сумма.
Создать конструктор с тремя параметрами – количеством купюр.
*/

import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {

        int res;
        int amount;

        Atm atm1 = new Atm(1000, 1000, 1000);

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the amount : ");

        amount = Integer.parseInt(sc.nextLine());

        System.out.println("\nАmount requested: " + amount);
        res = atm1.getMoney(amount);

        switch (res) {
            case -1:
                System.out.println("\nError! Not enough money in the account: " + atm1.totalAmount());
                break;
            case 0:
                System.out.println("\nОperation completed successfully");
                break;
            default:
                System.out.println("\nError! It is not possible to issue the full amount. Outstanding balance -" + res);
                break;
        }

        sc.close();
    }
}

class Atm {

    private int bnote05_cnt;
    private int bnote10_cnt;
    private int bnote20_cnt;

    final int BNOTE05 = 5;
    final int BNOTE10 = 10;
    final int BNOTE20 = 20;

    final int totalAmount () {
        return (BNOTE05 * bnote05_cnt) + (BNOTE10 * bnote10_cnt) + (BNOTE20 * bnote20_cnt);
    }

    final void loadMoney (int bnote05_num, int bnote10_num, int bnote20_num){

        if (bnote05_num < 0) bnote05_cnt = 0;
        else bnote05_cnt = bnote05_num;

        if (bnote10_num < 0) bnote10_cnt = 0;
        else bnote10_cnt = bnote10_num;

        if (bnote20_num < 0) bnote20_cnt = 0;
        else bnote20_cnt = bnote20_num;
    }

    Atm (int bnote05_num, int bnote10_num, int bnote20_num){
        loadMoney (bnote05_num, bnote10_num, bnote20_num);
    }

    Atm (){
        loadMoney (0, 0, 0);
    }

    int getMoney (int amount) {

        int bnote05_num =0;
        int bnote10_num =0;
        int bnote20_num =0;

        if (amount >= totalAmount()) {
            return -1;
        }

        bnote20_num = amount/BNOTE20;
        if (bnote20_num <= bnote20_cnt) {
            bnote20_cnt -= bnote20_num;
            amount -= bnote20_num * BNOTE20;
        } else {
            bnote20_num = 0;
        }

        bnote10_num = amount/BNOTE10;
        if (bnote10_num <= bnote10_cnt) {
            bnote10_cnt -= bnote10_num;
            amount -= bnote10_num * BNOTE10;
        } else {
            bnote10_num = 0;
        }

        bnote05_num = amount/BNOTE05;
        if (bnote05_num <= bnote05_cnt) {
            bnote05_cnt -= bnote05_num;
            amount -= bnote05_num * BNOTE05;
        } else {
            bnote05_num = 0;
        }

        if (amount > 0) {
            return amount;
        } else {

            System.out.println("\nThe amount will be issued in banknotes:");
            if (bnote20_num > 0) System.out.println("face value 20 Euro - " + bnote20_num);
            if (bnote10_num > 0) System.out.println("face value 10 Euro - " + bnote10_num);
            if (bnote05_num > 0) System.out.println("face value 05 Euro - " + bnote05_num);

            return 0;
        }
    }
}
