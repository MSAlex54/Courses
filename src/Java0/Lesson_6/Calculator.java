package Java0.Lesson_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private static double result = 0;

    public static double getResult() {
        return result;
    }

    public static void setResult(double result) {
        Calculator.result = result;
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new VerticalLayout());

        JTextField num1 = new JTextField(6);
        JTextField num2 = new JTextField(6);
        JLabel lbl1 = new JLabel("");
        JLabel lbl2 = new JLabel("");
        JButton btnPlus = new JButton("+");
        JButton btnMinus = new JButton("-");
        JButton btnMultip = new JButton("*");
        JButton btnDiv = new JButton("/");
        JButton btnExp = new JButton("^");
        btnExp.setActionCommand(btnExp.getText());
        JTextField resultField = new JTextField(20);

        btnPlus.setActionCommand(btnPlus.getText());
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double n1 =Double.parseDouble(num1.getText());
                double n2 =Double.parseDouble(num2.getText());
                calcResult(n1,n2, e.getActionCommand());
                resultField.setText(String.valueOf(getResult()));
            }
        });

        btnMinus.setActionCommand(btnMinus.getText());
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double n1 =Double.parseDouble(num1.getText());
                double n2 =Double.parseDouble(num2.getText());
                calcResult(n1,n2, e.getActionCommand());
                resultField.setText(String.valueOf(getResult()));
            }
        });

        btnMultip.setActionCommand(btnMultip.getText());
        btnMultip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double n1 =Double.parseDouble(num1.getText());
                double n2 =Double.parseDouble(num2.getText());
                calcResult(n1,n2, e.getActionCommand());
                resultField.setText(String.valueOf(getResult()));
            }
        });

            btnDiv.setActionCommand(btnDiv.getText());
        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double n1 =Double.parseDouble(num1.getText());
                double n2 =Double.parseDouble(num2.getText());
                calcResult(n1,n2, e.getActionCommand());
                resultField.setText(String.valueOf(getResult()));
            }
        });

        btnExp.setActionCommand(btnExp.getText());
        btnExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double n1 =Double.parseDouble(num1.getText());
                double n2 =Double.parseDouble(num2.getText());
                calcResult(n1,n2, e.getActionCommand());
                resultField.setText(String.valueOf(getResult()));
            }
        });


        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(2, 3, 5, 3);
        grid.setLayout(layout);
        grid.add(new JLabel("Число 1"));
        grid.add(lbl1);
        grid.add(new JLabel("Число 2"));
        grid.add(num1);
        grid.add(lbl2);
        grid.add(num2);

        JPanel buttonsPanel = new JPanel();
        GridLayout layout2 = new GridLayout(1, 5, 5, 3);
        buttonsPanel.setLayout(layout2);
        buttonsPanel.add(btnPlus);
        buttonsPanel.add(btnMinus);
        buttonsPanel.add(btnMultip);
        buttonsPanel.add(btnDiv);
        buttonsPanel.add(btnExp);


        mainPanel.add(grid);
        mainPanel.add(buttonsPanel);
        mainPanel.add(new JLabel("Результат"));

        mainPanel.add(resultField);


        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);


        class localActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                double n1 =Double.parseDouble(num1.getText());
                double n2 =Double.parseDouble(num2.getText());
                calcResult(n1,n2, e.getActionCommand());
            }
        }



    }


    public static double calcResult(double num1, double num2, String mathAction){
        double result = 0;
        switch (mathAction){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "^":
                result = expNumber(num1, num2);
                break;
        }
        setResult(result);
        return result;
    }
    public static double expNumber(double num1, double num2){
        double result = num1;
        for (int i = 1; i<num2;i++){
            result*=num1;
        }
        return result;
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
