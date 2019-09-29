package Java1.Lesson_2.HomeWork.ExcetptionsPractice.MyExceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j, String s) {
        super("Ошибка в ячйке " + i + "X" + j + "- введено значение: " + s);
    }
}
