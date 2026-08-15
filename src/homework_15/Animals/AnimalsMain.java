package homework_15.Animals;

//Создать класс, который будет хранить в себе коллекцию с названиями животных.
//Реализовать методы удаления и добавления животных по следующим правилам:
//добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
//объекта этого класса в main методе другого класса
public class AnimalsMain {
    public static void main(String[] args) {
        Animals animals = new Animals();

        animals.addAnimal("Попугай");
        animals.addAnimal("Лев");
        animals.addAnimal("Тигр");
        animals.addAnimal("Зебра");
        animals.addAnimal("Кот");
        animals.addAnimal("Собака");

        System.out.println("Добавили животных:");
        System.out.println(animals.toString());

        animals.deleteAnimal();
        System.out.println("Удалили животное:");
        System.out.println(animals.toString());
    }
}
