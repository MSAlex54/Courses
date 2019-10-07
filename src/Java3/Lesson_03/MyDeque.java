package Java3.Lesson_03;

import java.util.Arrays;

public class MyDeque<Item>  {
    private Item[] list;
    private int size = 0;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int head = 1;
    private int tail = 0;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Object[capacity];
        this.capacity = capacity;
    }

    public MyDeque() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertLeft (Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        if (tail > 0 ){
            list[tail] = item;
            tail--;
        } else if (tail == 0){
            list[tail] = item;
            tail=getCapacity()-1;
        }
        size++;
    }
    public void insertRight  (Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        if (head < getCapacity() ){
            list[head] = item;
            head++;
        } else if (head == getCapacity()){
            list[head] = item;
            head = 0;
        }
        size++;
    }

    public Item removeLeft() {
        Item res = list[tail+1];
        tail++;
        list[tail] = null;
        size--;
        return res;
    }

    public Item removeRight() {
        Item res = list[head-1];
        head--;
        list[head] = null;
        size--;
        return res;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
        this.capacity = newCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
