package Java3.Lesson_04;
//реализовать очередь на безе linkedList
//


import java.util.Iterator;

public class MyLinkedQueue<T>  implements Iterable<T> {
    private MyLinkedList<T> queue = new MyLinkedList<>();

    public void insert(T value) {
        queue.insertFirst(value);
    }

    public T remove() {
        return queue.removeLast();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public T peekFront(){
        return queue.getFirst();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

}
