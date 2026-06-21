package homework_2;

public class IntroductionToJava {

    public static void main(String[] args) {
        System.out.println("--------------------------");
        findValue();
        System.out.println("--------------------------");
        sumTwoDigit();
        System.out.println("--------------------------");
        sumThreeDigit();
        System.out.println("--------------------------");
        doRound();
        System.out.println("--------------------------");
        doDivision();
        System.out.println("--------------------------");
        swapVar();
    }

    public static void findValue(){
        //Написать приложение, которое будет вычислять и выводить значение по формуле:
        // а=4*(b+с-1)/2;
        // b и с задаем в коде самостоятельно.
        float b=5;
        float c=2;
        float a=4*(b+c-1)/2;
        System.out.println("а=4*(b+с-1)/2="+a);
    }

    public static void sumTwoDigit() {
        //В переменной n хранится двузначное число.
        // Создайте программу, вычисляющую и выводящую на экран сумму цифр n.
        // Например: n =26, в результате мы должны получить 8 (2+6).

        int n = 26;
        int b = n % 10;
        int a = (n-b)/10;
        System.out.println("При n="+n+" мы получаем "+a+"+"+b+"="+(a+b));
    }

    public static void sumThreeDigit() {
        //В переменной n хранится трёхзначное число.
        // Создайте программу, вычисляющую и выводящую на экран сумму цифр n.
        // Например: n =126, в результате мы должны получить 9 (1+2+6).
        int n = 126;
        int c = n % 10;
        int b = ((n-c)%100)/10;
        int a = n/100;
        System.out.println("При n="+n+" мы получаем "+a+"+"+b+"+"+c+"="+(a+b+c));
    }

    public static void doRound() {
        //В переменной и хранится вещественное число с ненулевой дробной частью.
        //Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран.
        double n = 123.556;
        n = Math.round(n);
        System.out.println(n);
    }

    public static void doDivision() {
        //В переменных q и w хранятся два натуральных числа.
        //Создайте программу, выводящую на экран результат деления q на w с остатком.
        //Пример вывода программы (для случая, когда в q хранится 21, а в w хранится 8):
        //21/8 = 2 и 5 в остатке.
        int q = 21;
        int w = 8;
        System.out.println(q+"/"+w+" = "+(q/w)+ " и "+(q%w)+" в остатке");
    }

    public static void swapVar(){
        //Написать программу, которая будет менять местами значение целочисленных переменных. Пример:
        //int a = 1; int b = 2; //код (ваше решение) sout(a); //выведет 2
        //sout(b); //выведет 1
        //Усовершенствовать программу, использовать только 2 входные переменные (а,b);

        int a = 1;
        int b = 2;
        a=a*b;
        b=a/b;
        a=a/b;
        System.out.println(a);
        System.out.println(b);
    }
}