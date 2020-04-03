package Java2.Lesson_01;

/*���� ������ Fruit -> Apple, Orange (������ ������� �� ����);
����� Box, � ������� ����� ���������� ������. ������� ������� ����������� �� ���� ������, ������� � ���� ������� ������ ������� � ������, � ���������;
��� �������� ������� ������ ������� ����� ������������ ArrayList;
������� ����� getWeight(), ������� ����������� ��� �������, ���� ���������� ������� � ��� ������ ������ (��� ������ � 1.0f, ��������� � 1.5f. �� �����, � ����� ��� ��������);
������ ������ ������� ������� ����� compare, ������� ��������� �������� ������� ������� � ���, ������� ������� � compare � �������� ���������, true � ���� ��� ����� �� ����, false � � ��������� ������ (������� � �������� �� ����� ���������� � ��������� � �����������);
�������� �����, ������� ��������� ���������� ������ �� ������� ������� � ������ (������ ��� ���������� �������: ������ ������ �������� � ������� � �����������). ��������������, � ������� ������� ������� �� ��������, � � ������ �������������� �������, ������� ���� � ���� �������;
�� �������� ��� ����� ���������� ������ � �������.*/

public class HomeWork {

    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        for (int i = 0; i < 9 ; i++) {
            box1.addToBox(new Apple());
        }
        for (int i = 0; i < 6; i++) {
            box2.addToBox(new Orange());
        }
        System.out.println(box1.getTypeOfBox() + " " + box1.getWeight());
        System.out.println(box2.getTypeOfBox() + " " + box2.getWeight());
        System.out.println(box1.compareBoxes(box2));
        box1.moveToAnotherBox(box3);
        System.out.println(box1.getTypeOfBox() + " " + box1.getWeight());
        System.out.println(box3.getTypeOfBox() + " " + box3.getWeight());
    }
}
