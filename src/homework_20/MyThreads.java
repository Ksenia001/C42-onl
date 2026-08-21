package homework_20;

import java.util.Scanner;
import java.util.function.Function;

//Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
//потока. Первый поток находит максимум в массиве, второй — минимум. Результаты
//вычислений возвращаются в метод main()
public class MyThreads {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int[] result = minMaxThreads(input);
        System.out.println("min = " + result[0]);
        System.out.println("max = " + result[1]);
        input.close();
    }

    public static int inputInt(Scanner input) {

        while (!input.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.");
            input.next();
        }
        return input.nextInt();
    }

    public static int[] minMaxThreads(Scanner input) throws InterruptedException {
        System.out.println("Размер массива:");
        int size = input.nextInt();
        input.nextLine();
        System.out.println("Массив:");
        int[] inputArr = new int[size];
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = inputInt(input);
        }

        Function<int[], Integer> min = (int[] arr) -> {
            int minValue = arr[0];
            for (int arrs : arr) {
                if (arrs < minValue) {
                    minValue = arrs;
                }
            }
            return minValue;
        };

        Function<int[], Integer> max = (int[] arr) -> {
            int maxValue = arr[0];
            for (int arrs : arr) {
                if (arrs > maxValue) {
                    maxValue = arrs;
                }
            }
            return maxValue;
        };

        int[] resultArr = new int[2];

        Thread threadMin = new Thread(()-> resultArr[0] = min.apply(inputArr));
        Thread threadMax = new Thread(()-> resultArr[1] = max.apply(inputArr));

        threadMin.start();
        threadMax.start();
        threadMin.join();
        threadMax.join();

        return resultArr;
    }
}
