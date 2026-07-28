package homework_12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Вывести в консоль из строки которую пользователь вводит с клавиатуры все
//аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
//только из прописных букв, без чисел.
public class Abbreviation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите строку, в которой я найду все аббревиатуры:");
        String line = input.nextLine();

        System.out.print(findAbbreviation(line)?"":"Аббревиатуры не найдены");
    }

    public static boolean findAbbreviation(String line) {
        final Pattern pattern = Pattern.compile("\\b[A-ZА-ЯЁ]{2,6}\\b");
        Matcher matcher = pattern.matcher(line);
        boolean isFind = false;

        while (matcher.find()) {
            System.out.println(matcher.group());
            isFind = true;
        }
        return isFind;
    }
}
