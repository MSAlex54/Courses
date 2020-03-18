package Java3.Lesson_05;
//1. �������� ��������� �� ���������� ����� � ������� � ������� ��������.
//2. �������� ��������� ������� � ������� � ������� ��������
//� ����� ���� ������ ����� �������������� ���: �� ��������� ��������� ��������� �� ���������� ����������� � ����
// ��������� �������� ������������ � ������������ ������ ����������, �������� ��� ���� ����������� �� ��������� ���.
public class Main {
    public static void main(String[] args) {
        System.out.println(expOn(3,6));//�������


        System.out.println(knapsack(values.length - 1, packMaxWeight));//������
    }
    static int[] values = new int[] {894, 260, 392, 281, 27};//������
    static int[] weights = new int[] {8, 6, 4, 0, 21};//������
    static int packMaxWeight = 30;//������


    //���������� � ������� � ��������
    static int expOn (int num, int  pow){
        if (num == 0){
            return 0;
        }else if (num==1){
            return num;
        }else if (pow==1){
            return num;
        }else if(pow ==0){
            return 1;
        }
        return num * expOn(num ,pow-1);
    }

    //������ � �������
    private static int knapsack (int numOfThings, int maximumWeight) {
        if (numOfThings < 0) {
            return 0;
        }
        if (weights[numOfThings] > maximumWeight) {
            return knapsack(numOfThings-1, maximumWeight);
        } else {
            return Math.max(knapsack(numOfThings-1, maximumWeight), knapsack(numOfThings-1, maximumWeight - weights[numOfThings]) + values[numOfThings]);
        }
    }
}
