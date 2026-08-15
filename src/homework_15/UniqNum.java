package homework_15;

import java.util.LinkedHashSet;
import java.util.Scanner;

//Задача 1:
//Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
//4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
//При решении использовать коллекции
public class UniqNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите набор чисел с клавиатуры. Например: \"1, 2, 3, 4, 4, 5\".");
        String text = sc.nextLine();

        String[] arr =  text.split(",");

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String word : arr) {
            set.add(word.trim());
        }
        System.out.println(set);
    }
}
