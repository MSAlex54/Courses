package Java1.Lesson_4.jFX;

import com.sun.javaws.exceptions.JreExecException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {

    public ChatWindow() {
        setTitle("ChatWindows");
        setBounds(800, 300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel chatPanel = new JPanel();
        JPanel btnsPanel = new JPanel();
        chatPanel.setBackground(Color.gray);
        btnsPanel.setBackground(Color.darkGray);

        btnsPanel.setPreferredSize(new Dimension(1,40));

        add(btnsPanel,BorderLayout.SOUTH);
        add(chatPanel,BorderLayout.CENTER);

        chatPanel.setLayout(new BorderLayout());
        btnsPanel.setLayout(new FlowLayout());

        JButton send = new JButton("Send");
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        chatPanel.add(jsp,BorderLayout.CENTER);

        JTextField jtf = new JTextField();
        btnsPanel.add(jtf);
        btnsPanel.add(send);

        jtf.setPreferredSize(new Dimension(300,28));
        jta.setEditable(false);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtf.getText().equals("")){
                    jta.append(jtf.getText() + "\n");
                    jtf.setText("");
                }
                jtf.grabFocus();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChatWindow();
    }
}
