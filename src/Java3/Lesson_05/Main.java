package Java3.Lesson_05;
//1. Написать программу по возведению числа в степень с помощью рекурсии.
//2. Написать программу «Задача о рюкзаке» с помощью рекурсии
//В общем виде задачу можно сформулировать так: из заданного множества предметов со свойствами «стоимость» и «вес»
// требуется отобрать подмножество с максимальной полной стоимостью, соблюдая при этом ограничение на суммарный вес.
public class Main {
    public static void main(String[] args) {
        System.out.println(expOn(3,6));//степень


        System.out.println(knapsack(values.length - 1, packMaxWeight));//рюкзак
    }
    static int[] values = new int[] {894, 260, 392, 281, 27};//рюкзак
    static int[] weights = new int[] {8, 6, 4, 0, 21};//рюкзак
    static int packMaxWeight = 30;//рюкзак


    //возведение в степень в рекурсии
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

    //Задача о рюкзаке
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
