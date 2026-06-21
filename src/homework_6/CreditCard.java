package homework_6;
//Создать класс CreditCard c полями номер счета, текущая сумма на счету.
//Добавьте метод, который позволяет начислять сумму на кредитную карточку.
//Добавьте метод, который позволяет снимать с карточки некоторую сумму.
//Добавьте метод, который выводит текущую информацию о карточке.
//Напишите программу, которая создает три объекта класса CreditCard у которых заданы номер счета и начальная сумма.
//Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с третьей.
//Выведите на экран текущее состояние всех трех карточек.

public class CreditCard {

    int accountNumber;     //номер счёта
    double currentSumm;    //текущая сумма

    //метод, который позволяет начислять сумму на кредитную карточку.
    public void addSumm(double amount){
        if(amount>0){
            currentSumm += amount;
        }
        else {
            System.out.println("Сумма ввода должна быть положительной.");
        }
    }

    //метод, который позволяет снимать с карточки некоторую сумму.
    public void subtractSumm(double amount){
        if(currentSumm<amount){
            System.out.println("Недостаточно средств!");
        }
        else {
            currentSumm -= amount;
        }
    }

    //метод, который выводит текущую информацию о карточке.
    public void showCurrentInfo(){
        System.out.println("Номер счёта: " + accountNumber);
        System.out.println("Текущий баланс: " + currentSumm);
    }

    public static void main(String[] args) {
        //создаем три объекта класса CreditCard
        CreditCard c1 = new CreditCard();
        CreditCard c2 = new CreditCard();
        CreditCard c3 = new CreditCard();

        //задаём начальную сумму и номер счёта
        c1.accountNumber = 1;
        c1.currentSumm = 100.0;

        c2.accountNumber = 2;
        c2.currentSumm = 1000.0;

        c3.accountNumber = 3;
        c3.currentSumm = 400.0;

        //выполняем операции
        c1.addSumm(100.0);
        c2.addSumm(200.0);
        c3.subtractSumm(300.0);

        //выводим на экран текущее состояние всех трех карточек.
        c1.showCurrentInfo();
        c2.showCurrentInfo();
        c3.showCurrentInfo();
    }
}
