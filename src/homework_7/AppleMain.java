package homework_7;

//Создать класс Apple и добавить в него поле color с модификатором доступа private и
//инициализировать его. В методе main другого класса создать объект Apple, и не
//используя сеттеры изменить значение поля color.

public class AppleMain {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.showApple();

        apple = new Apple("red");
        apple.showApple();
    }
}
