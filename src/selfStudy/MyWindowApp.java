package selfStudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowApp extends JFrame {

    private int cnt = 0;
    private JButton circleBtn;
    private JButton decBtn;

    public MyWindowApp(){
        super("My First Window"); //Заголовок окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, а не висела в процессах
        //setBounds(0, 0, 1000, 1000); //Если не выставить размер и положение то окно будет мелкое и незаметное

        //setLayout(BorderLayout); // отключаем систему Layout Manager

        //Подготавливаем компоненты объекта
        circleBtn = new JButton("Add circle");

        DrawingPanel circlePnl = new DrawingPanel();

        add(circleBtn, BorderLayout.NORTH);
        add(circlePnl, BorderLayout.SOUTH);

        //Подготавливаем временные компоненты
        //JPanel buttonsPanel = new JPanel(new FlowLayout());
        //Расставляем компоненты по местам
        //buttonsPanel.add(incBtn);
        //buttonsPanel.add(decBtn);

        //add(cntLabel); //О размещении компонент поговорим позже
        //add(incBtn);
        //add(decBtn);

        //super.add(buttonsPanel, BorderLayout.SOUTH);

        circleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cnt ++;   // Увеличиваем счетчик
                //updateCounter(); // Изменяем сообщение о состоянии счетчика
            }
        });

    }


    public void paint(Graphics g)
    {
        //cntLabel.setBounds(20, 20, 200, 25);
        //incBtn.setBounds(160, 50, 70, 25);
        //decBtn.setBounds(20, 60, 150, 25);
    }

    private void updateCounter() {
        //cntLabel.setText("Counter: " + cnt);
    }

    public static void main(String[] args) { //эта функция может быть и в другом классе
        MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
        app.setVisible(true); //С этого момента приложение запущено!
        app.pack(); //Эта команда подбирает оптимальный размер в зависимости от содержимого окна
    }

}


