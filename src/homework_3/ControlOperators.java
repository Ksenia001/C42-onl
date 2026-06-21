package homework_3;

import java.util.Scanner;

public class ControlOperators {
    public static void main(String[] args) {
        System.out.println("-".repeat(50));
        isParity();
        System.out.println("-".repeat(50));
        getTempOutside();
        System.out.println("-".repeat(50));
        getSquaresNumbers();
        System.out.println("-".repeat(50));
        getSequence();
        System.out.println("-".repeat(50));
        getSumNum();
    }
    public static void isParity(){
        //Напишите программу, которая будет принимать на вход число из консоли и на выход
        //будет выводить сообщение четное число или нет. Для определения четности числа
        //используйте операцию получения остатка от деления (операция выглядит так: '% 2').

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = sc.nextInt();

        System.out.println((a%2==0)?"ЧЁТНОЕ":"НЕЧЁТНОЕ");
    }

    public static void getTempOutside(){
        //Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
        //Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold».
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите температуру на улице: ");
        int t = sc.nextInt();

        if (t>-5) System.out.println("Warm");
        else if (t <= -5 && t > -20) System.out.println("Normal");
        else System.out.println("Cold");
    }

    public  static void getSquaresNumbers(){
        //Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно.
        for (int i=10; i<=20; i++){
            System.out.println(i*i);
        }
    }

    public  static void getSequence(){
        //Необходимо, чтоб программа выводила на экран вот такую последовательность:
        //7 14 21 28 35 42 49 56 63 70 77 84 91 98. В решении используйте цикл while.
        int a=7;
        int i=1;
        while (i<=14){
            System.out.print(a*i);
            System.out.print(" ");
            i++;
        }
        System.out.println();
    }

    public static void getSumNum(){
        //Напишите программу, где пользователь вводит любое целое положительное число. А
        //программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
        //числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
        //ввести некорректные данные.
        Scanner sc = new Scanner(System.in);
        int a;

        do {
            System.out.print("Введите положительное число: ");
        }while ((a = sc.nextInt()) <= 0);

        int sum = 0;
        for (int i=1; i<=a; i++){
            sum += i;
        }
        System.out.println("Сумма чисел от 1 до "+ a+" = "+sum);
    }
}
