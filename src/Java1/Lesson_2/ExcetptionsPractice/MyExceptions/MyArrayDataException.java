package Java1.Lesson_2.ExcetptionsPractice.MyExceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j, String s) {
        super("������ � ����� " + i + "X" + j + "- ������� ��������: " + s);
    }
}
