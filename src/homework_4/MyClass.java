package homework_4;

import java.util.Arrays;

public class MyClass {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        doTask1(arr.clone());
        System.out.println("-".repeat(50));
        doTask2(arr.clone());
        System.out.println("-".repeat(50));
        doTask3(arr.clone());
        System.out.println("-".repeat(50));
        doTask4(arr.clone());
        System.out.println("-".repeat(50));
        doTask5(arr.clone());
        System.out.println("-".repeat(50));
        doTask6(arr.clone());
        System.out.println("-".repeat(50));
        doTask7(arr.clone());
        System.out.println("-".repeat(50));
    }

    public static void doTask1(int[] arr){
        //Пройти по массиву, вывести все элементы в прямом и в обратном порядке.

        System.out.println("Массив в прямом порядке:");
        for (int j : arr) {
            System.out.print(j+" ");
        }
        System.out.println("\nМассив в обратном порядке:");

        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");
    }

    public static void doTask2(int[] arr){
        //Найти минимальный-максимальный элементы и вывести в консоль.
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Минимальный элемент массива: "+ min);
        System.out.println("Максимальный элемент массива: " + max);
    }

    public static void doTask3(int[] arr){
        //Найти индексы минимального и максимального элементов и вывести в консоль
        int min = arr[0];
        int max = arr[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("Индекс минимального элемента массива: "+ minIndex);
        System.out.println("Индекс максимального элемента массива: " + maxIndex);

    }

    public static void doTask4(int[] arr){
        //Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести
        //сообщение, что их нет.
        int zeroCount = 0;
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            }
        }
        if (zeroCount > 0){
            System.out.println("Количество нулевых элементов: "+ zeroCount);
        } else
            System.out.println("Нулевых элементов нет");
    }

    public static void doTask5(int[] arr){
        //Пройти по массиву и поменять местами элементы первый и последний, второй и
        //предпоследний и т.д.
        for (int i = 0; i < arr.length/2; i++){
            int j = arr.length-1-i;
            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void doTask6(int[] arr){
        //Проверить, является ли массив возрастающей последовательностью (каждое следующее
        //число больше предыдущего).
        boolean isSequence  = true;
        for (int i =  0; i < arr.length-1; i++) {
            if (arr[i] >= arr[i+1]) {
                isSequence = false;
                break;
            }
        }

        if (isSequence) {
            System.out.println("Массив является возрастающей последовательностью");
        } else {
            System.out.println("Массив не является возрастающей последовательностью");
        }
    }

    public static void doTask7(int[] arr){
        //Имеется массив из неотрицательных чисел(любой). Представьте что массив
        //представляет целое число (Например массив {1,2,3} -> 123, {9,9,9} -> 999). Задача
        //добавить единицу к этому “числу” и на выходе получить исправленный массив. Массив не
        //содержит нуля в начале, кроме самого числа 0.
        //Пример:
        //Input: [1,4,0,5,6,3]
        //Output: [1,4,0,5,6,4]
        //Input: [9,9,9]
        //Output: [1,0,0,0]
        int countNine = 0;

        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == 9){
                countNine++;
            }
            if (arr[i]<9){
                arr[i]++;
                break;
            }
            arr[i] = 0;

        }
        if (countNine == arr.length) {
            int[] temp = new int[arr.length+1];
            temp[0] = 1;
            System.out.println(Arrays.toString(temp));
        }
        else
            System.out.println(Arrays.toString(arr));
    }
}
