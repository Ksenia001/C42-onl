package homework_7;

//яблоко
public class Apple {
    private String color = "green";     //цвет

    Apple(){}

    //конструктор с параметрами
    Apple(String color) {
        this.color = color;
    }

    public void showApple() {
        System.out.println("Цвет яблока: " + color);
    }
}


