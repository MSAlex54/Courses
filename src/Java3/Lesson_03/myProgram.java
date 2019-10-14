package Java3.Lesson_03;

public class myProgram {
    public static void main(String[] args) {
        String stroka = "казак, шучу";
        System.out.println(stroka);
        System.out.println(reverseLine(stroka));

        MyDeque deque = new MyDeque(10);
        deque.insertRight(10);
        deque.insertLeft(11);
        deque.insertLeft(13);
        System.out.println(deque.toString());

    }
    public static String reverseLine(String stroka){
        String result = "";
        MyStack stack = new MyStack(stroka.length());

        for (int i = 0; i <stroka.length() ; i++) {
            stack.push(stroka.toCharArray()[i]);
        }
        for (int i = 0; i <stroka.length() ; i++) {
            result = result + stack.pop();
        }
        return result;
    }
}
