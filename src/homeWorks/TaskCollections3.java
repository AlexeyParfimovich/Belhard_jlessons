package homeWorks;

/*
Коллекции
Написать класс Student, предоставляющий информацию об имени студента методом getName() и о его курсе методом getCourse().
Написать метод printStudents(List students, int course), который получает список студентов и номер курса и печатает
в консоль имена тех студентов из списка, которые обучаются на данном курсе. Для обхода списка в этом методе использовать итератор.

Протестировать метод - создав предварительно десять объектов класса Student и поместив их в список.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class Student{
    private String name;
    private Integer course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Integer getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return name + " - " + course;
    }
}

public class TaskCollections3 {

    public static List<String> getStudentsOfCourse(List<Student> studentList, Integer courseNum){
        Student student;
        List<String> list = new ArrayList<>();
        Iterator<Student> itr = studentList.iterator();
        while(itr.hasNext()){
            student = itr.next();
            if(student.getCourse().equals(courseNum)){
                list.add(student.getName());
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<Student> AllSudentslist = new ArrayList<>();

        Random rnd = new Random();

        // Создание и заполнение списка студентов
        int studentsNum = rnd.nextInt(10)+10;
        for(int i=0; i<studentsNum; i++){
            AllSudentslist.add(new Student("Name"+(i+1), rnd.nextInt(5)+1));
        }
        System.out.println("All students:");
        System.out.println(AllSudentslist);

        // Отбор и вывод студентов только выбранного курса
        int courseNum = 1;
        System.out.println("Students of course " + courseNum + " :");
        System.out.println(getStudentsOfCourse(AllSudentslist,courseNum));
    }
}
