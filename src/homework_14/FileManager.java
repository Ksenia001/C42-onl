package homework_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении.
//Проанализировать и записать в другой файл самое длинное слово
public class FileManager {
    public static void main(String[] args) {
        File file = new File("src/homework_14/Romeo and Juliet.txt");
        String text = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.replaceAll("[^a-zA-Zа-яА-Я-]", "");
                if (!word.isBlank()) {
                    if (word.length() > text.length()) {
                        text = word;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
        System.out.println(text);

        File newFile = new File("src/homework_14/The longest word.txt");
        try(PrintWriter pw = new PrintWriter(newFile);) {
            pw.println(text);
        }catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
