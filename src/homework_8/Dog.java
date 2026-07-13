package homework_8;

//Написать такой конструктор, который запретит создание объекта класса Dog в других
//классах; Найти способ вызывать методы voice(), eat() класса Dog, который позволит
//обойти ограничение, наложенное конструктором выше. Объяснить, как работают оба
//способа.

public class Dog extends Animal{

    //конструктор, который запретит создание объекта класса Dog в других классах
    private Dog() {
        super("Secret Dog");
    }
    public static Dog createSecretDog(){
        return new Dog();
    }

    Dog(String name){
        super(name);
    }

    @Override
    void voice(){
        System.out.println("Собака "+ getName() +": Гав-гав");
    }

    @Override
    void eat(String food){
        if (food.equalsIgnoreCase("Meat") || food.equalsIgnoreCase("Мясо")){
            System.out.println("Собака "+getName()+" любит мясо");
        }
        else if (food.equalsIgnoreCase("Grass") || food.equalsIgnoreCase("Трава")){
            System.out.println("Собака "+getName()+" сьела траву. Кажется она приболела");
        }
        else{
            System.out.println("Собака "+ getName() +" недоволен. Собаки не едят "+food);
        }
    }
}
