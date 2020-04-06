package Java2.Lesson_02;

import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/*1. ������������ ������� ������� (id, prodid, title, cost) �������� �� Java-���������� (��������� - � ������������ ������� � �����);
��� ������� ���������� �������� ������� � ��������� 10000 ������� (��������� - � ������������ ������� � �����);
2. �������� ���������� ����������, ������� ��������� ������ ���� ������ �� ��� �����, ���� ������� ��������� ������� ������ ���,
���� ����� �� ��������� � ����. ���������� �������: �/���� �����545�.
�������� ����������� ��������� ���� ������. ��������� ��� ������ � ����� ����. ���������� �������: �/����������� �����10 10000�.
������� ������ � �������� ������� ���������. ���������� �������: �/������������ 100 600�*/

public class HomeWork {
    private static final String DB_PATH = "D:\\��������\\GeekBrains\\GeekBrains\\lesson2.db";
    private static Connection connect;
    private static Statement statement;
    private static String help = "��������� ��������:\n" +
            "/exit - ����� �� ����������\n" +
            "/���� X - ������� �� ����� ���� ������ 'X'\n" +
            "/����������� X Y - ���������� ������ 'X' ���� 'Y'\n" +
            "/������������ X Y - ������� ������ �������  � ��������� ��� �� 'X' �� 'Y'\n" +
            "/help - ������ ��������� �������";
    public static void main(String[] args) {
        createDB();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String rqst = "";
        ResultSet rs;
        while (true){
            try {
                System.out.println("������� ��������");
                input = reader.readLine();
                if (input.startsWith("/exit")){
                    System.out.println("��������� �����������.");
                    break;
                }
                if (input.startsWith("/")){
                    switch (input.split(" ",2)[0]) {
                        case ("/����"):
                            rqst = String.format("SELECT cost FROM Goods WHERE title = '%s'", input.split(" ", 2)[1]);
                            rs = statement.executeQuery(rqst);
                            if (rs.next()) {
                                System.out.println("���� ������ " + input.split(" ", 2)[1] + " �����: " + rs.getInt(1));
                            } else {
                                System.out.println("������ ������ ��� � ����");
                            }
                            break;
                        case ("/�����������"):
                            rqst = String.format("UPDATE Goods SET cost = %d WHERE title = '%s'", Integer.parseInt(input.split(" ", 3)[2]), input.split(" ",3)[1]);
                            System.out.println("���� ������ " + input.split(" ", 3)[1] + " ��������� � ������ �����: " + input.split(" ", 3)[2]);
                            break;
                        case ("/������������"):
                            rqst = String.format("SELECT title, cost FROM Goods WHERE cost BETWEEN %d AND %d", Integer.parseInt(input.split(" ", 3)[1]),Integer.parseInt(input.split(" ", 3)[2]));
                            rs = statement.executeQuery(rqst);
                            if (rs.next()) {
                                while (rs.next()) {
                                    System.out.println(rs.getString("title") + " " + rs.getString("cost"));
                                }
                            } else {
                                System.out.println("������ ������ ��� � ����");
                            }
                        case ("/help"):
                            System.out.println(help);
                    }
                } else {
                    System.out.println("����������� ��������. \n" + "����� �������� ������ ������� ������� /help");
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
            int option = 0;
            while (true){
                try {
                    System.out.println("�������� ������ ������������ ������� (1 ��� 2):");
                     option = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                     if (option == 1 || option == 2) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long startTime = System.currentTimeMillis();
            int rowCount = 10000;
            connect.setAutoCommit(false);
            if (option == 1) {
                StringBuilder req = new StringBuilder();
                req.append("(0,0,\'�����0\',1000)");
                for (int i = 1; i < rowCount-1; i++) {
                    req.append(", (" + i + "," + i + ",\'�����" + i + "\'," + (1000 + i) + ")");
                }
                statement.execute(String.format("INSERT INTO Goods (id, prodid, title, cost) VALUES %s",req));
            } else {
                PreparedStatement ps = connect.prepareStatement("INSERT INTO Goods (id, prodid, title, cost) VALUES (?,?,?,?)");
                for (int i = 0; i < rowCount; i++) {
                    ps.setInt(1, i);
                    ps.setInt(2, i);
                    ps.setString(3, "�����" + i);
                    ps.setInt(4, 1000 + i);
                    ps.addBatch();
                }
            }
            connect.commit();
            System.out.println("��������� ����� " + rowCount + " �� " + (System.currentTimeMillis() - startTime) + " ��");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
