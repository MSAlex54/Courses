package Java0.Lesson_2;

import java.util.Arrays;

public class CyclesAndArrays {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание 1:\n" + Arrays.toString(nums)+"\n");//выводим на жкран первоначальный массив
        for (int i = 0; i<nums.length; i++){
            nums[i] = nums[i]==1 ? 0:1;//если значение элемента равно 1 то меняем на 0 иначе - на 1.
        }
        System.out.println(Arrays.toString(nums));//выводим на жкран преобразованый массив


        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] nums2 = new int[8];
        for (int i = 0; i<nums2.length; i++){
            nums2[i] = i*3;
        }
        System.out.println("Задание 2:\n" + Arrays.toString(nums2)+"\n");//выводим на жкран преобразованый массив


        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
        int[] nums3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i<nums3.length; i++){
            if(nums3[i]<6){
                nums3[i]*=2;
            }
        }
        System.out.println("Задание 3:\n" + Arrays.toString(nums3)+"\n");//выводим на жкран преобразованый массив


        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание 4:");
        int[][] nums4 = new int[5][5];
        for( int i = 0, j = 0; i<nums4.length; i++, j++){
            nums4[i][j] = 1;
            System.out.println(Arrays.toString(nums4[i]));
        }


        //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] nums5 = nums3;
        int min = nums5[0];
        int max = nums5[0];
        for (int i : nums5){
            min = min>i ? i:min;
            max = max<i ? i:max;
        }
        System.out.println("Задание 5:\n" + "Массив: " + Arrays.toString(nums5) + "\nMin = " + min  +"\nMax = " + max);
        //Альтернативный ввариант
        Arrays.sort(nums5);//сортируем встроенным методом и тогда минимум будет в начале массива, а максимум - в конце
        System.out.println("Задание 5 (с сортировкой):\n" + "Массив: " + Arrays.toString(nums5) + "\nMin = " + nums5[0]  +"\nMax = " + nums5[nums5.length-1]+"\n");


        //6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        //Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;
        System.out.println("Задание 6:");
        int[] test1 = {1, 1, 1,  2, 1};
        int[] test2 = {2, 1, 1, 2, 1};
        int[] test3 = {10,10};
        checkBalance(test1);
        checkBalance(test2);
        checkBalance(test3);


        //7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.
        int[] task7Test1 = new int[0];
        int[] task7Test2 = {1,2,3,4,5};
        int[] task7Test3 = {1,2,3,4,5};
        int[] task7Test4 = {1,2,3,4,5};
        int[] task7Test5 = {1,2,3,4,5};
        int[] task7Test6 = {1,2,3,4,5};
        shift(task7Test1,4);
        shift(task7Test2,1);
        shift(task7Test3,4);
        shift(task7Test4,-1);
        shift(task7Test5,-2);
        shift(task7Test6,0);
    }


    //метод для 6 задания
    public static boolean checkBalance(int [] arr){
        boolean result = false;
        if (arr.length ==0 ){
            System.out.println("В массиве нет данных");
        } else{
            System.out.println("Для массива: " + Arrays.toString(arr));
            for (int i = 0; i<arr.length-1; i++){
                int sumLeft = 0;
                int sumRight = 0;
                for (int j = 0; j<=i; j++){
                    sumLeft +=arr[j];
                }
                for (int j = i+1; j<arr.length; j++){
                    sumRight +=arr[j];
                }
                if (sumLeft==sumRight){
                    result = true;
                    break;
                }
            }
        }
        System.out.println("Результат: " + result);
        return result;
    }


    //метод для 7 задания
    public static void shift (int[] arr, int n){
        System.out.println("\nЗадание 7:");
        if (arr.length==0){
            System.out.println("В массиве нет данных.");
            return;
        } else if(n==0){
            System.out.println("Сдвига не требуется. Результат:\n" + Arrays.toString(arr));
        } else{
            System.out.println("Оригинал массива:\n" + Arrays.toString(arr));
            if (n > 0){
                for (int i = 0; i<Math.abs(n); i++){
                    int buffer = arr[arr.length-1];
                    for (int j = arr.length-1; j>0;j--){
                        arr[j] = arr[j-1];
                    }
                    arr[0] = buffer;
                }
            } else {
                for (int i = 0; i<Math.abs(n); i++){
                    int buffer = arr[0];
                    for (int j = 0; j<arr.length-1;j++){
                        arr[j] = arr[j+1];
                    }
                    arr[arr.length-1] = buffer;
                }
            }
            System.out.println("Массив после сдвига на " + Math.abs(n) + " шагов " + (n>0 ? "вправо" : "влево") + ":\n" + Arrays.toString(arr));
        }
    }
}