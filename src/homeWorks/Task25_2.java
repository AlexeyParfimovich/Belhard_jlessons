package homeWorks;

/*
Классы
Создать класс и объекты описывающие Окружность (Circle).
Перегрузить конструктор класса, что бы в момент создания ввод параметров крга запрашивался с клавиатуры.
Создать метод для перемещения цента круга в случайную точку координатной плоскости 100х100.
Создать метод для вычисления расстояния между центрами двух окружностей.
Создать метод, проверяющий, касаются ли окружности в одной точке.
*/

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.*;

public class Task25_2 {
    public static void main(String[] args) {

        Circle circ1 = new Circle (10,10,10);

        System.out.println();
        System.out.println("Окружность 1: " + circ1);

        Circle circ2 = new Circle();

        System.out.println("Окружность 2: " + circ2);

        System.out.println("\nПереместим окружность 1 в случаную точку : ");
        circ1.moveToRandomPoint(-99,-99,99,99);
        System.out.print(" X " + circ1.getCenterX() + " и Y " + circ1.getCenterY());

        System.out.println("\nПереместим окружность 2 в случаную точку : ");
        circ2.moveToRandomPoint(-99,-99,99,99);
        System.out.print(" X " + circ2.getCenterX() + " и Y " + circ2.getCenterY());

        System.out.println();
        System.out.println("\nРасстояние между центрами окружностей = " + circ1.getDistanceTo(circ2));

        if (circ1.isTouchesIt(circ2)) {
            System.out.println("\nОкружности касаются друг-друга в одной точке");
        } else {
            System.out.println("\nОкружности не касаются друг-друга");
        }
    }
}

class Circle {

    private int centerX;
    private int centerY;
    private int radius;

    Circle (int centerX, int centerY, int radius){
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    Circle (){
        int x;
        int y;
        int r;

        Scanner sc = new Scanner(System.in);

        System.out.println("\nSetting the parameters of new circle.");

        System.out.println("Enter the X coordinate of the center (-99 to 99): ");
        x = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the Y coordinate of the center (-99 to 99): ");
        y = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the radius of the circle (0 to 99): ");
        r = Integer.parseInt(sc.nextLine());

        sc.close();

        this.centerX = x;
        this.centerY = y;
        this.radius = r;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString () {
        return "@" + hashCode() + " X:" + getCenterX() + ", " + " Y:" + getCenterY() + ", радиус: " + getRadius();
    }

    public void moveToRandomPoint (int coordX_start, int coordY_start, int coordX_end, int coordY_end) {
        Random rnd = new Random();
        centerX = rnd.nextInt(abs(coordX_start)+coordX_end) - coordX_end;
        centerY = rnd.nextInt(abs(coordY_start)+coordY_end) - coordY_end;
    }

    int getDistanceTo (Circle dest) {
        return (int)round(sqrt(pow(this.centerX-dest.getCenterX(),2) + pow(this.centerY-dest.getCenterY(),2)));
    }

    boolean isTouchesIt (Circle dest) {
        if (this.radius + dest.getRadius() == getDistanceTo(dest)) return true;
        else return false;
    }
}

