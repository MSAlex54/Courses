package Java3.Lesson_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long tStart;
        long tFinish;
        int sizeOf = 1000000;
        MyArrayList <Integer> selectList = createArList(sizeOf);
        MyArrayList <Integer> insertList = createArList(sizeOf);
        MyArrayList <Integer> bubleList = createArList(sizeOf);
        MyArrayList <Integer> standartList = createArList(sizeOf);
//        MySortedArrayList<Integer> msal = new MySortedArrayList<>();

        tStart = System.currentTimeMillis();
        standartList.sort();
        tFinish = System.currentTimeMillis();
        System.out.println((tFinish - tStart) + "мс - Сортировка стандарт");

        tStart = System.currentTimeMillis();
        selectList.selecionSort();
        tFinish = System.currentTimeMillis();
        System.out.println((tFinish - tStart) + "мс - Сортировка выбором");

        tStart = System.currentTimeMillis();
        insertList.insertionSort();
        tFinish = System.currentTimeMillis();
        System.out.println((tFinish - tStart) + "мс - Сортировка вставкой");

        tStart = System.currentTimeMillis();
        bubleList.selecionSort();
        tFinish = System.currentTimeMillis();
        System.out.println((tFinish - tStart) + "мс - Сортировка пузырьковая");

    }

    public static MyArrayList<Integer> createArList (int size){
        Random random = new Random();
        MyArrayList<Integer> arrList = new MyArrayList<>(size);
        for (int i = 0; i <size ; i++) {
            arrList.add(random.nextInt(100));
        }
        return arrList;
    }


}
