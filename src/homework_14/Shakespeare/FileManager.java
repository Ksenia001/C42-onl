package homework_14.Shakespeare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении.
//Проанализировать и записать в другой файл самое длинное слово
public class FileManager {
    public static void main(String[] args) {
        final String pathFile = "src/homework_14/Shakespeare/Romeo and Juliet.txt";
        final String pathWord = "src/homework_14/Shakespeare/The longest word.txt";

        File file = new File(pathFile);
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

        File newFile = new File(pathWord);
        try(PrintWriter pw = new PrintWriter(newFile);) {
            pw.println(text);
        }catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
