package homework_20;

import java.util.Arrays;
import java.util.Random;

//Сортировка массива цифр в нескольких потоках различными алгоритмами:
// сортировка вставками;
// сортировка выбором;
// сортировка пузырьком.
//Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
//результат отсортированных массивов в консоль.
public class MySortedThread {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(100);
        }
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));

        int[] bubbleArr = Arrays.copyOf(arr, arr.length);
        int[] insertsArr = Arrays.copyOf(arr, arr.length);
        int[] selectionArr = Arrays.copyOf(arr, arr.length);

        Thread threadBubble = new Thread(() -> bubbleSort(bubbleArr));
        Thread threadInsert = new Thread(() -> insertsSort(insertsArr));
        Thread threadSelection = new Thread(() -> selectionSort(selectionArr));

        threadBubble.start();
        threadInsert.start();
        threadSelection.start();
        threadBubble.join();
        threadInsert.join();
        threadSelection.join();

        System.out.println("Пузырьком:");
        System.out.println(Arrays.toString(bubbleArr));
        System.out.println("Вставкой:");
        System.out.println(Arrays.toString(insertsArr));
        System.out.println("Выбором:");
        System.out.println(Arrays.toString(selectionArr));
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        return arr;
    }

    public static int[] insertsSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i+1];
            int j = i;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
