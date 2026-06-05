package homework_3;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("-".repeat(50));
        Task1();
        System.out.println("-".repeat(50));
        Task2();
        System.out.println("-".repeat(50));
        Task3();
        System.out.println("-".repeat(50));
        Task4();
        System.out.println("-".repeat(50));
        Task5();
    }
    public static void Task1(){
        //Напишите программу, которая будет принимать на вход число из консоли и на выход
        //будет выводить сообщение четное число или нет. Для определения четности числа
        //используйте операцию получения остатка от деления (операция выглядит так: '% 2').

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = sc.nextInt();

        System.out.println((a%2==0)?"ЧЁТНОЕ":"НЕЧЁТНОЕ");

    }

    public static void Task2(){
        //Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
        //Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold».
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите температуру на улице: ");
        int t = sc.nextInt();

        if (t>-5) System.out.println("Warm");
        else if (t <= -5 && t > -20) System.out.println("Normal");
        else System.out.println("Cold");
    }

    public  static void Task3(){
        //Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно.
        for (int i=10; i<=20; i++){
            System.out.println(i*i);
        }
    }

    public  static void Task4(){
        //Необходимо, чтоб программа выводила на экран вот такую последовательность:
        //7 14 21 28 35 42 49 56 63 70 77 84 91 98. В решении используйте цикл while.
        int a=7;
        int i=1;
        while (i<15){
            System.out.print(a*i);
            System.out.print(" ");
            i++;
        }
        System.out.println("\n");
    }

    public static void Task5(){
        //Напишите программу, где пользователь вводит любое целое положительное число. А
        //программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
        //числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
        //ввести некорректные данные.
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Введите положительное число: ");
            int a = sc.nextInt();
            if (a <= 0) System.out.println("Вы ввели отрицательное число. Попробуйте снова.");
            else{
                int sum = 0;
                for (int i=1; i<=a; i++){
                    sum += i;
                }
                System.out.println("Сумма чисел от 1 до "+ a+" = "+sum);
                break;
            }
        }while (true);
    }
}
