package homework_8;

public class Rabbit extends Animal{
    Rabbit(String name){
        super(name);
    }

    @Override
    void voice(){
        System.out.println("Кролик "+getName()+": Фыр-фыр");
    }

    void eat(String food){
        if (food.equalsIgnoreCase("Grass") || food.equalsIgnoreCase("Трава")){
            System.out.println("Кролик "+getName()+" любит есть траву");
        }
        else{
            System.out.println("Кролик "+ getName() +" недоволен. Кролики не едят "+food);
        }
    }
}
