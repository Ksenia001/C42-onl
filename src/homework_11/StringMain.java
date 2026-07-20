package homework_11;

import java.util.Arrays;
import java.util.Scanner;
//1. Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
//найденные строки и их длину.
//2. Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
//значений их длины.
//3. Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
//средней, а также их длину.
//4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
//Если таких слов несколько, найти первое из них.
//5. Вывести на консоль новую строку, которой задублирована каждая буква из
//начальной строки. Например, "Hello" -> "HHeelllloo".
//Задача *:
//Дана строка произвольной длины с произвольными словами. Написать программу для
//проверки является ли любое выбранное слово в строке палиндромом.
//Например, есть строка, вводится число 3, значит необходимо проверить является ли 3-е
//слово в этой строке палиндромом.
//Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций: например,
//в строке 5 слов, а на вход программе передали число 500.
public class StringMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] threeString = userInput(input);
        System.out.println("-".repeat(70));

        //задание 1
        System.out.println("Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. " +
                "Вывести найденные строки и их длину.");
        findShortAndLongString(threeString);
        System.out.println("-".repeat(70));

        //задание 2
        System.out.println("Ввести 3 строки с консоли. " +
                "Упорядочить и вывести строки в порядке возрастания значений их длины.");
        sortToLength(threeString);
        System.out.println("-".repeat(70));

        //задание 3
        System.out.println("Ввести 3 строки с консоли. " +
                "Вывести на консоль те строки, длина которых меньше средней, а также их длину.");
        findStringLessAverage(threeString);
        System.out.println("-".repeat(70));

        //задание 4
        System.out.println("Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов. " +
                "Если таких слов несколько, найти первое из них.");
        findDifferentSymbolString(threeString);
        System.out.println("-".repeat(70));

        //задание 5
        System.out.println("Вывести на консоль новую строку, которой задублирована каждая буква из начальной строки. " +
                "Например, \"Hello\" -> \"HHeelllloo\"");
        System.out.println("-".repeat(70));
        System.out.println("Введите строку для удвоения:");
        String doubleString = input.nextLine();
        System.out.println("Удвоенная строка: "+duplicatedAllLetter(doubleString));
        System.out.println("-".repeat(70));

        //задание 6
        System.out.println("Введите предложение, каждое слово отделяйте пробелом:");
        String suggestion = input.nextLine();
        System.out.println("Введите индекс слова, которого хотите проверить на палиндром:");
        int index = input.nextInt();
        input.nextLine();
        isPalindrome(suggestion, index);
        input.close();
    }
    //пользовательский ввод 3 строк
    public static String[] userInput(Scanner input){
        String[] userStrings = new String[3];
        System.out.println("Введите 3 строки.");
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Строка %s: ", i);
            userStrings[i-1]=input.nextLine();
        }
        System.out.println("Введённые строки:");
        System.out.println(Arrays.toString(userStrings));

        return userStrings;
    }
    //поиск самой короткой и самой длинной строки
    public static void findShortAndLongString(String[] arrayString){
        String shortString = arrayString[0];
        String longString = arrayString[0];
        for (String s : arrayString) {
            shortString = s.length() < shortString.length() ? s : shortString;
            longString = s.length() > longString.length() ? s : longString;
        }
        System.out.println("Первая самая короткая строка: " + shortString + ", её длина: " + shortString.length());
        System.out.println("Первая самая длинная строка: " + longString + ", её длниа: " + longString.length());
    }
    //Строки в порядке возрастания значения длины
    public static void sortToLength(String[] arrayString){
        Arrays.sort(arrayString, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Отсортированные строки в порядке возрастания: " + Arrays.toString(arrayString));
    }
    //Строки, длина которых меньше средней
    public static void findStringLessAverage(String[] arrayString) {
        int average = 0;
        for(String s : arrayString){
            average += s.length();
        }
        average = average / arrayString.length;
        System.out.println("Средняя длина всех строк: " + average);
        for (String s : arrayString){
            if(s.length() < average){
                System.out.println("Строка, длина которой меньше средней: "+s+", её длина: "+s.length());
            }
        }
    }
    //поиск слова, состоящее только из различных символов
    public static void findDifferentSymbolString(String[] arrayString) {
        for (String s : arrayString) {
            if (s == null || s.isBlank()) {
                continue;
            }
            boolean isUniq = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.indexOf(s.charAt(i)) != s.lastIndexOf(s.charAt(i))) {
                    isUniq = false;
                    break;
                }
            }
            if (isUniq) {
                System.out.println("Строка, состоящая из различных символов: " + s);
                break;
            }
        }
    }
    //дублирование каждая буква из начальной строки
    private static String duplicatedAllLetter(String doubleString) {
        char[] newStr = new char[doubleString.length()*2];
        for (int i = 0, j = 0; i < doubleString.length(); i++, j+=2) {
            newStr[j] = doubleString.charAt(i);
            newStr[j+1] = doubleString.charAt(i);
        }
        return String.valueOf(newStr);
    }
    //Проверяет слово по индексу является ли палиндромом
    public static void isPalindrome(String str, int index){
        if (str == null || str.isBlank()){
            System.out.println("Строка не получена или пуста");
            return;
        }
        String[] words = str.split("\\s+");
        if (index - 1 >= words.length || index < 1) {
            System.out.println("Индекс выходит за границы количества слов");
            return;
        }
        String word = words[index-1].toLowerCase();
        if (word.endsWith(",") || word.endsWith(".") || word.endsWith("?")
                || word.endsWith("!") || word.endsWith(";")|| word.endsWith(":")) {
            word = word.substring(0, word.length() - 1);
        }
        for (int i = 0, j = word.length()-1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                System.out.println("Строка "+ word + " не является палиндромом");
                return;
            }
        }
        System.out.println("Строка "+ word + " является палиндромом");
    }
}
