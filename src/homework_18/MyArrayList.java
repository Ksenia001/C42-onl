package homework_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
//Stream'ов:
//- Удалить дубликаты
//- Оставить только четные элементы
//- Вывести сумму оставшихся элементов в стриме
public class MyArrayList {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < 40; i++){
            integerList.add(rand.nextInt(100));
        }

        System.out.println("Исходный массив");
        System.out.println(integerList);

        System.out.println("Массив без дубликатов:");
        System.out.println(deleteDuplicates(integerList));

        System.out.println("Только четные элементы:");
        System.out.println(returnEvenNumber(integerList));

        System.out.println("Сумма элементов : "+countSumElements(integerList));
    }
    public static <T> List<T> deleteDuplicates(List<T> list){
        return list.stream()
                    .distinct()
                    .collect(Collectors.toList());
    }

    public static List<Integer> returnEvenNumber(List<Integer> list){
        return list.stream()
                    .filter(x -> x % 2 == 0)
                    .collect(Collectors.toList());
    }

    public static int countSumElements(List<Integer> list){
        return list.stream()
                    .mapToInt(x -> x)
                    .sum();
    }
}
