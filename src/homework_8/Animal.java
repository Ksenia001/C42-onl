package homework_8;
//Создать логически верную иерархию следующих классов: Animal, Dog, Tiger, Rabbit.
//Переопределить методы voice(), eat(String food) чтобы они выводили верную
//информацию. Метод eat может принимать “Meat”, “Grass” и другие строки.
//Например, если мы создадим объект класса Rabbit, вызовем метод eat() и передадим
//туда “Grass” он должен написать в консоли что любит есть травку. Если передадим “Meat”
//или другую строку то он будет недоволен.
public class Animal {
    private String name;

    Animal(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void voice(){
        System.out.println("Голос");
    }

    void eat(String food){
        System.out.println(food);
    }
}
