package homework_16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//Задание 1
//На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
//строка является ключом, и ее значение равно true, если эта строка встречается в массиве
//2 или более раз. Пример:
//wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
//wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
//wordMultiple(["c", "c", "c", "c"]) → {"c": true}

//Задание 2
//На вход поступает массив непустых строк, создайте и верните Map<String,
//String> следующим образом: для каждой строки добавьте ее первый символ в
//качестве ключа с последним символом в качестве значения. Пример:
//pairs(["code", "bug"]) → {"b": "g", "c": "e"}
//pairs(["man", "moon", "main"]) → {"m": "n"}
//pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
public class WordMultiple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] words = inputUser(input);

        System.out.println("Карта строк >=2 раз");
        Map<String, Boolean> booleanLinkedHashMap = buildFrequencyMap(words);
        System.out.println(booleanLinkedHashMap);

        System.out.println("Карта первый-последний символ");
        Map<String,String> stringLinkedHashMap = buildFirstLastMap(words);
        System.out.println(stringLinkedHashMap);
        input.close();
    }

    public static Map<String, Boolean> buildFrequencyMap(String[] words) {
        if (words == null) {
            return new LinkedHashMap<>();
        }
        LinkedHashMap<String, Boolean> map = new LinkedHashMap<>();
        HashSet<String> keys = new HashSet<>();
        for (String word : words) {
            if (word == null || word.isBlank()) {
                continue;
            }
            if(keys.add(word)){
                map.put(word, false);
            }
            else {
                map.put(word, true);
            }
        }
        return map;
    }

    public static Map<String, String> buildFirstLastMap(String[] words) {
        if (words == null) {
            return new LinkedHashMap<>();
        }
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for (String word : words) {
            if (word == null || word.isBlank()) {
                continue;
            }
            map.put(word.substring(0,1), word.substring(word.length()-1));
        }
        return map;
    }

    public static String[] inputUser(Scanner input) {
        System.out.print("Введите количество слов: ");
        while (!input.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.");
            input.next();
        }
        int size = input.nextInt();

        input.nextLine();

        String[] words = new String[size];

        System.out.println("Введите слова:");
        for (int i = 0; i < size; i++) {
            words[i] = input.nextLine();
        }

        System.out.println("Ваш массив строк: " + Arrays.toString(words));
        return words;
    }
}
