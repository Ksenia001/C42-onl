package homework_8;

public class Tiger extends  Animal{

    Tiger(String name){
        super(name);
    }

    @Override
    void voice(){
        System.out.println("Тигр "+getName()+": Ррррр");
    }

    @Override
    void eat(String food){
        if (food.equalsIgnoreCase("Meat") || food.equalsIgnoreCase("Мясо")){
            System.out.println("Тигр "+getName()+" любит мясо");
        }
        else{
            System.out.println("Тигр "+ getName() +" недоволен. Тигры не едят "+food);
        }
    }
}
