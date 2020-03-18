package Java1.Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        //Первая задача
        ArrayList <String> arrString = new ArrayList<>(20);
        HashMap<String,Integer> arrCounter = new HashMap<>();

        for (int x = 0; x<20; x++){ //заполняем массив текстом в цикле
            arrString.add ("Stroka" +  (int) (Math.random()*5));
        }

        for (int x = 0; x<arrString.size(); x++){
            String key = arrString.get(x);
            Integer value = arrCounter.get(key);
            arrCounter.put(key,value == null ? 1:value+1);
        }
        System.out.println(arrString);
        System.out.println(arrCounter);


        //Вторая задача

        //Наполяем коллекцию
        YellowPages yp = new YellowPages();
        HashSet <String> pNumber;
        String[] names = {"Ivanov", "Petrov","Sidorov","Orlov"};
        for (String s :names) {
            pNumber = new HashSet<>();
            for (int x = 0; x<(1 +(int) (Math.random()*5)); x++){//генерим номера телефонов (от 1 до 5 на человека)
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
