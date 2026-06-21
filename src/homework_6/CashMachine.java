package homework_6;

//Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
//задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
//метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
//принимает сумму денег, а возвращает болевое значение - успешность выполнения
//операции. При снятии денег, функция должна распечатывать каким количеством купюр
//какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
//количеством купюр каждого номинала

import java.util.Scanner;

public class CashMachine {
    int countNominal20;     //количеством купюр номиналом 20
    int countNominal50;     //количеством купюр номиналом 50
    int countNominal100;    //количеством купюр номиналом 100

    CashMachine(){
        this.countNominal100=0;
        this.countNominal50=0;
        this.countNominal20=0;
    }

    CashMachine(int countNominal100, int countNominal50, int countNominal20){
        this.countNominal100=countNominal100;
        this.countNominal50=countNominal50;
        this.countNominal20=countNominal20;
    }

    //метод для добавления денег в банкомат
    public void addMoney(int nominal100,int nominal50,int nominal20){
        countNominal100 += nominal100;
        countNominal50 += nominal50;
        countNominal20 += nominal20;
    }

    //метод для снятия денег из банкомата
    public boolean withdrawMoney(int amount){
        System.out.println("Запрос обрабатывается...");
        if ((amount % 10 !=0) || amount < 20 || amount == 30){
            System.out.println("Некорректная сумма. Операция отклонена.");
            return false;
        }

        int give20=0, give50=0, give100=0;

        give100 = amount/100;
        while (countNominal100  < give100){
            give100--;
        }
        amount-= give100*100;

        if((amount%50!=0) && (give100!=0)){
            give100--;
            amount+= 100;
        }

        give50 = amount/50;
        while (countNominal50  < give50){
            give50--;
        }
        amount-= give50*50;

        if((amount%20!=0) && (give50!=0)){
            give50--;
            amount+= 50;
        }

        give20 = amount/20;
        while (countNominal20  < give20){
            give20--;
        }
        amount-= give20*20;

        if (amount == 0){
            countNominal100 -= give100;
            countNominal50 -= give50;
            countNominal20 -= give20;
            System.out.println("Вся сумма успешно выдана.");
            System.out.println("Выдано купюр номиналом 100: "+give100);
            System.out.println("Выдано купюр номиналом  50: "+give50);
            System.out.println("Выдано купюр номиналом  20: "+give20);
            return true;
        }
        else{
            System.out.println("Ошибка. Недостаточно средств в банкомате.");
            return false;
        }
    }

    public void showCountNominal(){
        System.out.println("В банкомате:");
        System.out.println("Количество купюр номиналом 100: "+countNominal100);
        System.out.println("Количество купюр номиналом  50: "+countNominal50);
        System.out.println("Количество купюр номиналом  20: "+countNominal20);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CashMachine cashMachine = new CashMachine();

        cashMachine.addMoney(100,100,100);
        cashMachine.showCountNominal();

        System.out.println("-".repeat(20));
        System.out.println("Введите сумму, которую хотите снять:");
        int summ = input.nextInt();
        cashMachine.withdrawMoney(summ);
        cashMachine.showCountNominal();
    }
}
