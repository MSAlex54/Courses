package Java2.Lesson_02;

import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/*1. Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java-приложения (подробнее - в методическом пособии к уроку);
При запуске приложения очистить таблицу и заполнить 10000 товаров (подробнее - в методическом пособии к уроку);
2. Написать консольное приложение, которое позволяет узнать цену товара по его имени, либо вывести сообщение «Такого товара нет»,
если товар не обнаружен в базе. Консольная команда: «/цена товар545».
Добавить возможность изменения цены товара. Указываем имя товара и новую цену. Консольная команда: «/сменитьцену товар10 10000».
Вывести товары в заданном ценовом диапазоне. Консольная команда: «/товарыпоцене 100 600»*/

public class HomeWork {
    private static final String DB_PATH = "D:\\Обучение\\GeekBrains\\GeekBrains\\lesson2.db";
    private static Connection connect;
    private static Statement statement;
    public static void main(String[] args) {
        createDB();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String rqst = "";
        ResultSet rs;
        while (true){
            try {
                System.out.println("Введите комманду");
                input = reader.readLine();
                if (input.startsWith("/exit")){
                    System.out.println("Программа отключается.");
                    break;
                }
                if (input.startsWith("/")){
                    switch (input.split(" ",2)[0]) {
                        case ("/цена"):
                            rqst = String.format("SELECT cost FROM Goods WHERE title = '%s'", input.split(" ", 2)[1]);
                            rs = statement.executeQuery(rqst);
                            if (rs.next()) {
                                System.out.println("Цена товара " + input.split(" ", 2)[1] + " равна: " + rs.getInt(1));
                            } else {
                                System.out.println("Такого товара нет в базе");
                            }
                            break;
                        case ("/сменитьцену"):
                            rqst = String.format("UPDATE Goods SET cost = %d WHERE title = '%s'", Integer.parseInt(input.split(" ", 3)[2]), input.split(" ",3)[1]);
                            System.out.println("Цена товара " + input.split(" ", 3)[1] + " обновлена и теперь равна: " + input.split(" ", 3)[2]);
                            break;
                        case ("/товарыпоцене"):
                            rqst = String.format("SELECT title, cost FROM Goods WHERE cost BETWEEN %d AND %d", Integer.parseInt(input.split(" ", 3)[1]),Integer.parseInt(input.split(" ", 3)[2]));
                            rs = statement.executeQuery(rqst);
                            if (rs.next()) {
                                while (rs.next()) {
                                    System.out.println(rs.getString("title") + " " + rs.getString("cost"));
                                }
                            } else {
                                System.out.println("Такого товара нет в базе");
                            }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createDB(){
        try {
            connect = DriverManager.getConnection(JDBC.PREFIX + DB_PATH);
            statement = connect.createStatement();
            statement.execute("DROP TABLE IF EXISTS Goods ");
            statement.execute("CREATE TABLE IF NOT EXISTS Goods (id INT, prodid INT, title VARCHAR, cost DOUBLE) ");
            StringBuilder req = new StringBuilder();
            req.append("(0,0,\'good0\',1000)");
            for (int i = 1; i < 100; i++) {
                req.append(", (" + i + "," + i + ",\'good" + i + "\'," + (1000 + i) + ")");
            }
            statement.execute(String.format("INSERT INTO Goods (id, prodid, title, cost) VALUES %s",req));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
