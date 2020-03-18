package Java1.Lesson_2.ExcetptionsPractice.MyExceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j, String s) {
        super("ќшибка в €чйке " + i + "X" + j + "- введено значение: " + s);
    }
}
