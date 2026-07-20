package homework_9.work;
//Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом,
//который печатает название должности и имплементировать этот метод в созданные
//классы.
public class JobMain {
    public static void main(String[] args) {
        Position director = new Director();
        Position worker = new Worker();
        Position accountant = new Accountant();

        director.showPosition();
        worker.showPosition();
        accountant.showPosition();
    }
}
