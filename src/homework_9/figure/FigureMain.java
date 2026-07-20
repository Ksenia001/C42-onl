package homework_9.figure;
//Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг. Реализовать
//функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя
//абстрактный класс/методы). Создать массив из 5 разных фигур. Вывести на экран сумму
//периметра всех фигур в массиве
public class FigureMain {
    public static void main(String[] args) {
        Figure[] figures = {new Circle(5),
                new Triangle(3,4,5),
                new Rectangle(20,15),
                new Circle(10),
                new Rectangle(25,15)
        };

        double totalPerimeter = 0;
        for (Figure figure : figures) {
            System.out.println(figure);
            totalPerimeter+=figure.calculationPerimeter();
        }

        System.out.println("Total perimeter is "+totalPerimeter);
    }
}
