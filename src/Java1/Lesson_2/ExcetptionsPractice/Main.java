package Java1.Lesson_2.ExcetptionsPractice;

import Java1.Lesson_2.ExcetptionsPractice.MyExceptions.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String [][] strings1 = {{"2","3","3","3"},{"3","3","3","3"},{"3","3","3","3"},{"3","3","3","3"}};
        String [][] strings2 = {{"2","3","3","3"},{"3","3","3","3"},{"3","3","3","3"}};
        String [][] strings3 = {{"2","3","3","3"},{"3","3","3","3"},{"3","�","3","3"},{"3","3","3","3"}};//��� ����� � (Z) ������ ������, ���� ���...
        ArrayList<String[][]> array = new ArrayList();
        array.add(strings1);
        array.add(strings2);
        array.add(strings3);
        for (String [][]s : array) {
            try {
                System.out.println("����� ���� ��������� ������� �����: " + summOfArrayElements(s));
            } catch (Exception e) {
                e.printStackTrace();//����� �������� �� ����� ���
            }
        }
    }

    static int summOfArrayElements (String [][] strings) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        if (strings.length != 4 || strings[0].length != 4){
            throw new MyArraySizeException("����������� ������� �� 4X4!");
        } else {
            for (int i = 0; i<strings.length; i++){
                for (int j = 0; j<strings[0].length; j++){
                    try {
                        summ += Integer.parseInt(strings[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i+1,j+1,strings[i][j]);//������ ��������� ��� ������ � 1
                    }
                }
            }
        }
        return summ;
    }
}