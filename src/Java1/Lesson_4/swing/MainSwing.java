package Java1.Lesson_4.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSwing {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("HellowWorld");
        setBounds(800, 400, 400, 400);
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton open = new JButton("Open");
        JButton cancel = new JButton("Cancel");

        jPanel.add(open);
        jPanel.add(cancel);
        add(jPanel,BorderLayout.SOUTH);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SecondWindow();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class SecondWindow extends JFrame {
    public SecondWindow() {
        setTitle("SecondWindow!");
        setBounds(500, 300, 200, 200);

        JButton btn1 = new JButton("SecondWindow");

        add(btn1, BorderLayout.CENTER);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
