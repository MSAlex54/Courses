package Java1.Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        //������ ������
        ArrayList <String> arrString = new ArrayList<>(20);
        HashMap<String,Integer> arrCounter = new HashMap<>();

        for (int x = 0; x<20; x++){ //��������� ������ ������� � �����
            arrString.add ("Stroka" +  (int) (Math.random()*5));
        }

        for (int x = 0; x<arrString.size(); x++){
            String key = arrString.get(x);
            Integer value = arrCounter.get(key);
            arrCounter.put(key,value == null ? 1:value+1);
        }
        System.out.println(arrString);
        System.out.println(arrCounter);


        //������ ������

        //�������� ���������
        YellowPages yp = new YellowPages();
        HashSet <String> pNumber;
        String[] names = {"Ivanov", "Petrov","Sidorov","Orlov"};
        for (String s :names) {
            pNumber = new HashSet<>();
            for (int x = 0; x<(1 +(int) (Math.random()*5)); x++){//������� ������ ��������� (�� 1 �� 5 �� ��������)
                String numb = "8900";
                for (int j = 0; j<7;j++){
                    numb = numb + (int) (Math.random()*9);
                }
                pNumber.add(numb);
            }
            yp.add(s,pNumber);
        }
        System.out.println("Ivanov: " + yp.get("Ivanov"));
    }
}
