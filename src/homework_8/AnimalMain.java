package homework_8;

public class AnimalMain {
    public static void main(String[] args) {

        //задача со звёздочкой
        Dog.createSecretDog().eat("Meat");
        Dog.createSecretDog().voice();

        //основная задача
        Animal[] animal =  {
                new Dog("Шарик"),
                new Rabbit("Яша"),
                new Tiger("Амур")
        };

        System.out.println("Звуки животных:");
        for (Animal a : animal) {
            a.voice();
        }

        System.out.println("Попытка покормить:");
        for (Animal a : animal) {
            a.eat("Meat");
            a.eat("Grass");
        }
    }
}
