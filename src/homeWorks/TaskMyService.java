package homeWorks;

/*
Придумать и написать собственную аннотацию @Version, которая бует хранить информацию о версии класса сервиса (поле обязательное) MyService
и кодовое название версии (поле не обязательное) - (например номер версии = 7.1, а кодовое название версии = Nougat).
Класс MyService должен иметь переменные c private модификаторами, конструктор по умолчанию, get и set методы, переопределенные методы equals и hashcode,
а так же private метод (private thisClassInfo), который будет просто печатать данные о самом классе (данные любые на ваш выбор), в котором он определен.

Написать программу, которая будет анализировать присутствие аннотации над классом MyService и если она присутствует - создавать экземпляр этого класса,
задавать значения его полям и вызывать метод thisClassInfo (использовать возможности пакета reflection).
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

@Version(versionNumber=1.0, versionName = "Belhaven Black")
class MyService {

    private double versionNumber;
    private String versionName;

    MyService(){
        this.versionNumber = 0;
        this.versionName = "Unknown";
    }

    public double getVersionNumber() {
        return versionNumber;
    }

    public String getVersionName() {
        return versionName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MyService ms = (MyService)obj;
        return versionNumber == ms.getVersionNumber()
            && (versionName == ms.getVersionName() || (versionName != null && versionName.equals(ms.getVersionName())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int res = 1;

        res = prime * res + ((versionName == null) ? 0 : versionName.hashCode());
        res = prime * res + Double.hashCode(versionNumber);

        return res;
    }

    private String thisClassInfo(){
        return "The object @" + hashCode() + " of class " + this.getClass().getName() + " v." + versionNumber + "/" + versionName;
    }
}

public class TaskMyService {
    public static void main(String[] args) {

        try {
            Class cl = Class.forName("homeWorks.MyService");

            MyService msObject;
            Method clMethod;
            Field clField;

            Version clVer = (Version)cl.getAnnotation(Version.class);
            //if (!cl.isAnnotationPresent(ClassVersion.class)) {
            if (clVer == null){
                System.err.println("There is no annotation for class, finita la comedia");
            } else {
                System.out.println("Class is annotated - " + cl.getAnnotation(Version.class));

                msObject =  (MyService)cl.getDeclaredConstructor().newInstance();

                clField = cl.getDeclaredField("versionNumber");
                clField.setAccessible(true);
                clField.setDouble(msObject,clVer.versionNumber());

                clField = cl.getDeclaredField("versionName");
                clField.setAccessible(true);
                clField.set(msObject,clVer.versionName());

                clMethod = cl.getDeclaredMethod("thisClassInfo");
                clMethod.setAccessible(true);
                System.out.println(clMethod.invoke(msObject));
            }
        } catch (ClassNotFoundException Ex) {
            System.out.print("Class not found: ");
            System.out.println(Ex.getMessage());
        } catch (NoSuchFieldException Ex){
            System.out.print("Class field not declared: ");
            System.out.println(Ex.getMessage());
        } catch (NoSuchMethodException Ex) {
            System.out.print("Class constuctor or method not declared: ");
            System.out.println(Ex.getMessage());
        } catch (InvocationTargetException Ex) {
            System.out.print("Class method invocation error: ");
            System.out.println(Ex.getMessage());
        } catch (IllegalAccessException Ex) {
            System.out.print("The object could not be created (still some kind of garbage): ");
            System.out.println(Ex.getMessage());
        } catch (InstantiationException Ex) {
            System.out.print("The object could not be created (still some kind of garbage): ");
            System.out.println(Ex.getMessage());
        }
    }
}

