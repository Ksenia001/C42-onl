package Game;
//❗️Техническое задание №1. Игра «Угадай слово»
//Необходимо разработать консольную игру «Угадай слово».
//1. Исходные данные
//1. Создать массив строк, содержащий 20 различных слов. Слова выбираются студентом самостоятельно.
//2. С помощью генератора случайных чисел выбрать одно слово из массива и сохранить его как загаданное.
//2. Правила игрыа
//Пользователь должен угадать загаданное слово. Возможны два варианта ввода:
//- ввод всего слова целиком;
//- ввод одной буквы.
//3. Логика работы программы
//1. Пользователь получает 5 попыток.
//2. Если пользователь вводит слово полностью и оно совпадает с загаданным, игра завершается сообщением о победе.
//3. Если пользователь вводит одну букву:
//   - при правильном ответе буква открывается во всех соответствующих позициях слова;
//   - при неправильном ответе количество оставшихся попыток уменьшается на единицу, после чего программа запрашивает новый ввод.
//4. Игра продолжается до тех пор, пока:
//   - пользователь не угадает всё слово;
//   - либо не будут исчерпаны все 5 попыток.
//4. Условия завершения игры
//Победа
//Пользователь считается победителем, если:
//- угадал слово целиком с первой или последующих попыток;
//- либо последовательно открыл все буквы слова до исчерпания пяти попыток.
//Поражение
//Если все 5 попыток использованы, а слово не угадано, программа должна вывести сообщение о поражении.
//5. Повторный запуск
//После проигрыша программа должна вывести вопрос:
//«Хотите начать заново?»
//Возможны два варианта ответа:
//- «Да» — игра начинается сначала, при этом снова случайным образом выбирается слово из массива.
//- «Нет» — программа завершает работу и выводит сообщение:
//«Прощайте, до свидания».
//6. Дополнительные требования
//1. Игра должна быть реализована в консольном режиме.
//2. Использовать массив из 20 различных слов.
//3. Для выбора загаданного слова использовать генератор случайных чисел.
//4. Количество попыток должно храниться в отдельной переменной.
//5. Программа должна корректно обрабатывать ввод пользователя и обеспечивать возможность повторного запуска игры.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        playGame(input);
    }

    //игровой цикл повторения игры
    public static void playGame(Scanner input) {
        do {
            String[] arrayWord = {"стол", "стул", "книга", "ручка", "тетрадь", "телефон",
                    "ноутбук", "чашка", "тарелка", "ложка", "ключ", "кошелек", "часы",
                    "рюкзак", "лампа", "зеркало", "подушка", "одеяло", "зонт", "расческа"};

            int randomNumber = new Random().nextInt(arrayWord.length);
            int countAttempts = 5;

            String randomWord = arrayWord[randomNumber];

            String[] output = new String[randomWord.length()];
            Arrays.fill(output, "_ ");

            playOneGame(randomWord, countAttempts, output, input);

            System.out.println("Хотите начать заново?(Да/Нет)");
            String inputUser = input.nextLine();
            if (!inputUser.equalsIgnoreCase("Да")) {
                System.out.println("Прощайте, до свидания.");
                break;
            }
        }while (true);
    }

    //проводит одну игровую партию
    public static void playOneGame (String randomWord, int countAttempts, String[] output, Scanner input){
        System.out.println("Добро пожаловать в игру \"Угадай слово\"");
        //System.out.println("Загаданное слово: " + randomWord);
        printWord(output);

        String inputUser;

        do {
            System.out.println("-".repeat(60));
            System.out.println("Попыток: " + countAttempts);
            System.out.println("Введите букву или можете попытаться отгадать сразу всё слово:");
            inputUser = input.nextLine();

            //проверка на пустой ввод
            if (inputUser.isEmpty()) {
                System.out.println("Вы ничего не ввели. Попробуйте снова.");
                continue;
            }

            //ввод одной буквы
            if (inputUser.length() == 1) {
                countAttempts = processOneLetter(inputUser, output, countAttempts, randomWord);
            }
            //ввод всего слова
            else {
                countAttempts = processWord(inputUser, countAttempts, randomWord);
                if (countAttempts == -1) break;
            }

            printWord(output);

            boolean isWin = isOpenAll(output);

            //если отгадал слово
            if (isWin) {
                System.out.println("Вы отгадали слово!");
                break;
            }
            //если закончились попытки
            if (countAttempts == 0) {
                System.out.println("Вы проиграли(");
                System.out.println("Загаданное слово: " + randomWord);
                break;
            }
        } while (true);
    }

    //проверяет не открыты ли все буквы
    public static boolean isOpenAll(String[] output){
        for (String cell : output) {
            if (cell.equals("_ ")) {
                return false;
            }
        }
        return true;
    }

    //обрабатывает ввод одной буквы
    public static int processOneLetter(String inputUser, String[] output, int countAttempts, String randomWord) {
        boolean isFind = false;
        for (int i = 0; i < randomWord.length(); i++) {
            String currentLetter = randomWord.substring(i, i + 1);

            if (inputUser.equalsIgnoreCase(currentLetter)) {
                output[i] = currentLetter + " ";
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("Такой буквы нет.");
            countAttempts--;
        }
        return countAttempts;
    }
    //обрабатывает ввод всего слова
    public static int processWord(String inputUser, int countAttempts, String randomWord){
        if (inputUser.equalsIgnoreCase(randomWord)) {
            System.out.println("Вы отгадали слово!");
            return -1;
        } else {
            System.out.println("Вы не отгадали слово.");
            countAttempts--;
        }
        return countAttempts;
    }

    //выводит слово в виде чёрточек "_"
    public static void printWord(String[] output) {
        System.out.println("-".repeat(60));
        System.out.println("Загаданное слово:");
        for (String cell : output) {
            System.out.print(cell);
        }
        System.out.println();
    }
}
