package homeWorks;

/*
Классы
Создать класс и объекты описывающие промежуток времени.
Промежуток в классе должен задаваться тремя свойствами: секундами, минутами, часами.
Создать два конструктора: получающий общее количество секунд, получающий часы, минуты и секунды по отдельности.
Сделать методы для получения полного количества секунд в объекте и сравнения двух объектов, метод для вывода данных.
*/

import java.sql.Time;

public class Task24 {
    public static void main(String[] args) {

        TimeRange tr1 = new TimeRange(1000);
        TimeRange tr2 = new TimeRange(2, 15, 45);

        System.out.println(tr1);
        System.out.println(tr1.getTimeRange());

        System.out.println();

        System.out.println(tr2);
        System.out.println(tr2.getTimeRange());

        System.out.println();

        switch (tr1.compareTo(tr2)) {
            case -1:
                System.out.println("tr1 is less then tr2");
                break;
            case 0:
                System.out.println("tr1 is equal to tr2");
                break;
            case 1:
                System.out.println("tr1 is more then tr2");
                break;
        }

    }
}

class TimeRange {

    private long hours;
    private long minutes;
    private long seconds;

    TimeRange (long hours, long minutes, long seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    TimeRange (long seconds) {
        this(seconds/60/60, seconds/60%60, seconds % 60);
    };

    final void SetTimeRange (long hours, long minutes, long seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    final void SetTimeRange (long seconds) {
        SetTimeRange(seconds/60/60, seconds/60%60, seconds % 60);
    };

    long getTimeRange() {
        return hours*60 + minutes*60 + seconds;
    }

    int compareTo (TimeRange trange) {

        if (this.getTimeRange() < trange.getTimeRange()) {
            return -1;
        } else if (this.getTimeRange() == trange.getTimeRange()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Time range is " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.";
        //getClass().getName()+"@"+Integer.toHexString(hashCode());
    }

}

