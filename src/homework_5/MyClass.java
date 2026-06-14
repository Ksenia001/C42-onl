package homework_5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        doTask1();
        System.out.println("-".repeat(50));
        doTask2();
        System.out.println("-".repeat(50));
        doTask3();
    }

    public static void doTask1(){
        //1.1 Создать двумерный массив, заполнить его случайными числами.
        //1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
        //1.3 Найти сумму всех получившихся элементов и вывести в консоль.

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число строк: ");
        int rows = sc.nextInt();
        System.out.print("Введите число столбцов: ");
        int cols = sc.nextInt();

        Random input = new Random();
        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = input.nextInt(100);
            }
        }

        System.out.println(Arrays.deepToString(arr));

        System.out.println("-".repeat(50));
        System.out.println("Введите число, которое вы хотите прибавить к каждому значению: ");

        int num = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] += num;
                sum += arr[i][j];
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println("Сумма всех элементов: "+sum);
    }

    public static void doTask2(){
        //Создать программу для раскраски шахматной доски с помощью цикла. Создать
        //двумерный массив String 8х8. С помощью циклов задать элементам массива значения
        //B(Black) или W(White). При выводе результат работы программы должен быть
        //следующим:
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B W B W B W

        String[][] arr = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    arr[i][j]= "W";
                }
                else {
                    arr[i][j]= "B";
                }
            }
        }

        for (String[] row : arr) {
            for (String value : row) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

    public static void doTask3(){
        //Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой.
        //Формат входных данных:
        //Программа получает на вход два числа n и m.
        //Формат выходных данных:
        //Программа должна вывести полученный массив, отводя на вывод каждого числа ровно 3
        //символа.

        System.out.print("Введите число строк: ");
        int n = new Scanner(System.in).nextInt();
        System.out.print("Введите число столбцов: ");
        int m = new Scanner(System.in).nextInt();

        int[][] arr = new int[n][m];

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 == 0) {
                    arr[i][j] = num++;
                }
                else {
                    arr[i][m-j-1] = num++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
