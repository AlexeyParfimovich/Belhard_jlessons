package selfStudy;

import javax.swing.*;
import java.awt.*;

public class Drawing {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Picture");                                                                            // Создать объект окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);

        //JPanel panel = new JPanel();
        JButton btn1 = new JButton("Button 1");

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(200,200,50);
        //Circle circle3 = new Circle(100,100,50,Color.RED);
        DrawingPanel panel = new DrawingPanel();                                                                            // Создание панели для рисования

        frame.add(panel);                                                                                                   // Добавить панель в окно
        frame.add(btn1);
        frame.add(circle1);
        frame.add(circle2);
        //frame.add(circle3);

        frame.pack();                                                                                                       // Установить размер окна по размеру панели
        frame.setVisible(true);                                                                                             // Отобразить окно
    }
}

class DrawingPanel extends JPanel{
    DrawingPanel() {
        setPreferredSize(new Dimension(100,100));
        setLayout(new BorderLayout());
        setBackground(Color.YELLOW);
        setOpaque(true);
    }
}

class Circle extends JPanel {

    int centerX;
    int centerY;
    int radius;
    Color color;

    Circle(int centerX, int centerY, int radius, Color color){
        setLayout(new BorderLayout());
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
    }

    Circle(int centerX, int centerY, int radius) {
        this(centerX, centerY, radius, Color.BLACK);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    Circle() {
        this(0, 0, 10, Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(centerX-radius, centerY-radius, centerX+radius, centerY+radius);
    }

}