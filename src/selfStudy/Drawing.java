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

        //JFrame.setDefaultLookAndFeelDecorated(true);                                                                   // Отрисовка окна выполняется через SWING

        JFrame frame = new JFrame("Picture");                                                                       // Создать объект окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout());
        frame.setBackground(Color.WHITE);

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(200,200,50);
        Circle circle3 = new Circle(100,100,50,Color.RED);

        DrawingPanel panel = new DrawingPanel();                                                                       // Создание панели для рисования
        panel.add(circle1);
        panel.add(circle2);
        panel.add(circle3);

        frame.add(panel); //, BorderLayout.NORTH);                                                                                              // Добавить панель в окно

        frame.pack();                                                                                                    // Установить размер окна по размеру панели
        frame.setVisible(true);                                                                                          // Отобразить окно
    }
}

class DrawingPanel extends JPanel{

    DrawingPanel() {
        setPreferredSize(new Dimension(1000,1000));

        setLayout(null);
        //setBackground(Color.GREEN);
        setOpaque(false);
    }

    public void paint(Graphics g)
    {
       //super.paintComponent(g);
        //g.clearRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < getComponentCount(); i++) {
           Circle c = (Circle)getComponent(i);

           g.setColor(c.color);
           g.drawOval(c.centerX - c.radius, c.centerY - c.radius, c.radius*2, c.radius*2);
           //c.setBounds(c.centerX - c.radius, c.centerY - c.radius, c.radius*2, c.radius*2);
       }

       //super.paintComponent(g);
    }

}

class Circle extends JPanel {

    int centerX;
    int centerY;
    int radius;
    Color color;

    Circle(int centerX, int centerY, int radius, Color color){
        setLayout(null);
        setPreferredSize(new Dimension(radius*2,radius*2));
        setOpaque(false);

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
        //setBackground(color);
        //super.paintComponent(g);
        //g.setColor(color);
        //g.drawOval(0, 0, radius*2, radius*2);

        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.drawOval(0, 0, getWidth(), getHeight());

    }

}