package Java0.Lesson_6;

import javax.swing.*;
import java.awt.*;

public class MangerLayoutTest extends JFrame {
    public MangerLayoutTest() {
        super("MangerLayoutTest");
        setSize(320,240);
        setLocation(100,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //�������� ������ � ��������� �������������
        JPanel grid = new JPanel(new GridLayout(1,2,5,0));
        //���������� ������ � ������
        grid.add(new JButton("Ok"));
        grid.add(new JButton("Cancel"));
        //�������� ������� � ���������������� �������������
        // ����������� � ������������� �� ������� ����
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        flow.add(new JButton("TEST"));
        //��������� ������ �����������
        Container container = getContentPane();
        //���������� ������ � �������� ����� ������
        container.add(flow,BorderLayout.SOUTH);
        //�������� ����
        setVisible(true);
    }

    public static void main(String[] args) {
        new MangerLayoutTest();
    }

}
