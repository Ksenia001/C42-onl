package homework_7;

//яблоко
public class Apple {
    private String color = "green";     //цвет

    public Apple(){}

    //конструктор с параметрами
    public Apple(String color) {
        this.color = color;
    }

    public void showApple() {
        System.out.println("Цвет яблока: " + color);
    }
}


