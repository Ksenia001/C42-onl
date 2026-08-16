package homework_17;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        printHundredBirthday();
        System.out.println("-".repeat(20));
        showPositiveArray();
        System.out.println("-".repeat(20));
        showBynInDollar("3250 BYN");
        System.out.println("-".repeat(20));
        reverseString();
    }

    public static int inputInt() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.");
            input.next();
        }
        return input.nextInt();
    }

    //Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
    //когда пользователю исполнится 100 лет. Использовать Date/Time API.
    public static void printHundredBirthday() {
        System.out.println("Введите дату своего рождения(ввод в виде числа)");
        while (true) {
            System.out.println("Введите день рождения:");
            int day = inputInt();
            System.out.println("Введите месяц рождения:");
            int month = inputInt();
            System.out.println("Введите год рождения:");
            int year = inputInt();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                System.out.println("Вам исполниться 100 лет "
                        + LocalDate.of(year, month, day).plusYears(100).format(formatter));
                break;
            } catch (DateTimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //Используя Predicate среди массива чисел вывести только те, которые являются
    //положительными.
    public static void showPositiveArray(){
        int[] numbers = new int[]{-3, 2, -1, 4, 0, 5};
        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("Положительные элементы: ");
        for (int number : numbers) {
            if (isPositive.test(number)) {
                System.out.print(number);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    //Используя Function реализовать лямбду, которая будет принимать в себя строку в
    //формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
    //возвращать сумму, переведенную сразу в доллары.
    public static final double dollarExchangeRate = 2.977;
    public static double conversionIntoDollar(String input){
        Function<String, Double> bynByDollar = (String byn) ->
            Double.parseDouble(byn
                    .replaceAll("[^0-9.,]", "")
                    .replace(",", ".")
            ) / dollarExchangeRate;

        return bynByDollar.apply(input);
    }

    //Используя Consumer реализовать лямбду, которая будет принимать в себя строку в
    //формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
    //выводить сумму, переведенную сразу в доллары.
    public static void showBynInDollar(String input){
        Consumer<String> formatter = s ->
                System.out.printf("BYN: %s\nDollar: %.2f\n", s, conversionIntoDollar(s));
        formatter.accept(input);
    }

    //Используя Supplier написать метод, который будет возвращать введенную с консоли
    //строку задом наперед.
    public static void reverseString(){
        System.out.println("Введите строку: ");
        Supplier<String> supplier = () -> new StringBuffer(new Scanner(System.in).nextLine()).reverse().toString();

        System.out.println("Строка задом наперёд: "+supplier.get());
    }
}
