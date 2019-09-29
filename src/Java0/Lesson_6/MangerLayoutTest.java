package Java0.Lesson_6;

import javax.swing.*;
import java.awt.*;

public class MangerLayoutTest extends JFrame {
    public MangerLayoutTest() {
        super("MangerLayoutTest");
        setSize(320,240);
        setLocation(100,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //создание панели с табличным расположением
        JPanel grid = new JPanel(new GridLayout(1,2,5,0));
        //добавление кнопок в панель
        grid.add(new JButton("Ok"));
        grid.add(new JButton("Cancel"));
        //Создание панельи с последовательным расположением
        // компонентов и выравниванием по правому краю
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        flow.add(new JButton("TEST"));
        //получение панели содержимого
        Container container = getContentPane();
        //размещение панели с кнопками внизу справа
        container.add(flow,BorderLayout.SOUTH);
        //Открытие окна
        setVisible(true);
    }

    public static void main(String[] args) {
        new MangerLayoutTest();
    }

}
