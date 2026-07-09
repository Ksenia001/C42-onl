package homework_8;

public class Dog extends Animal{

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
