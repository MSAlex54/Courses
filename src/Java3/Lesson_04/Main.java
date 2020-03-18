package Java3.Lesson_04;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedQueue<String> mll = new MyLinkedQueue<>();

        mll.insert("Katia");
        mll.insert("Maria");
        mll.insert("Lyba");

        System.out.println(mll);

        mll.insert("Petia");
        System.out.println(mll);

        System.out.println(mll.remove());
        System.out.println(mll);

        System.out.println();
        Iterator<String> iterator = mll.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        for (String s : mll) {
            System.out.print(s + " : ");
        }

    }
}
