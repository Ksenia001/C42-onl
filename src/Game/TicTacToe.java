package Game;

import java.util.Random;
import java.util.Scanner;

//Необходимо написать консольную игру «Крестики-нолики».
//Игра должна реализовываться на поле размером 3×3.
//На начальном этапе все ячейки игрового поля должны быть заполнены любым значением,
//которое не соответствует символам «X» или «0», чтобы было понятно, что клетка свободна.
//
//Перед началом игры с помощью класса Random необходимо случайным образом определить, кто будет ходить первым:
//пользователь или искусственный интеллект. Игрок, который ходит первым, ставит крестики «X»,
//а второй игрок ставит нолики «0».
//
//Пользователь играет против искусственного интеллекта.
//Ход пользователя должен осуществляться через консольный ввод координат ячейки.
//Координаты должны вводиться в формате строки и столбца, например: 1 0 или 1,0.
//После ввода координат программа должна проверять, существует ли такая ячейка на поле и свободна ли она.
//Если координаты введены неверно или ячейка уже занята,
//программа должна вывести сообщение об ошибке и предложить пользователю повторить ввод.
//
//Искусственный интеллект должен делать ход автоматически.
//Минимальная реализация может предусматривать случайный выбор свободной клетки.
//После каждого хода игровое поле должно выводиться в консоль в актуальном состоянии.
//
//Программа должна проверять условия победы после каждого хода. Победа засчитывается,
//если один из игроков заполнил своими символами одну строку, один столбец или одну диагональ.
//Если все клетки заполнены, но победитель не определён, игра завершается ничьей.
//
//После завершения игры программа должна вывести итоговое сообщение: победил пользователь,
//победил искусственный интеллект или игра завершилась вничью.
//
//Программа должна спросить пользователя - желает ли он повторить игру, если да,
//игра начинается заново, если нет, конец программы.
public class TicTacToe {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        playGame(input);
    }

    //игровой цикл повторения игры
    public static void playGame(Scanner input){
        do{
            String firstPlayer = " X ";
            String secondPlayer = " O ";

            String[][] board = {
                    {"   ", "   ", "   "},
                    {"   ", "   ", "   "},
                    {"   ", "   ", "   "}
            };

            playOneGame(board, firstPlayer, secondPlayer, input);

            System.out.println("Хотите начать заново?(Да/Нет)");
            String inputUser = input.nextLine();
            if (!inputUser.equalsIgnoreCase("Да")) {
                System.out.println("Прощайте, до свидания.");
                break;
            }
        }while(true);
    }

    //проводит одну игровую партию до победы или ничьи
    public static void playOneGame(String[][] board, String firstPlayer, String secondPlayer, Scanner input){
        boolean isII = new Random().nextBoolean();
        boolean isWin = false;
        int move = 0;

        System.out.print("Первый ход: ");
        System.out.println(isII ? "Искусственный интеллект" : "Игрок");

        System.out.println("Игровое поле:");
        showBoard(board);

        do {
            int[] coordinates;

            //ход искуственного интеллекта
            if (isII){
                coordinates = moveAI(board);
            }
            //ход игрока
            else {
                System.out.println("Ваш ход!");
                coordinates = movePlayer(board, input);
            }

            String currentPlayer = (move % 2 == 0) ? firstPlayer : secondPlayer;
            putSign(coordinates[0], coordinates[1], currentPlayer, board);

            showBoard(board);
            move ++;

            isII = !isII;   //передача хода

            if (move>4){
                isWin = isVictory(board);
            }

        }while(!isWin && move < 9);

        if (isWin) {
            String winner = (move % 2 != 0) ? firstPlayer : secondPlayer;
            System.out.println("Победа! Выиграл: " + winner);
        } else {
            System.out.println("Ничья!");
        }
    }

    //вывод игрового поля
    public static void showBoard(String[][] board) {
        System.out.println(String.join(" | ", board[0]));
        System.out.println("-".repeat(15));
        System.out.println(String.join(" | ", board[1]));
        System.out.println("-".repeat(15));
        System.out.println(String.join(" | ", board[2]));
    }

    //установка символа на игровое поле
    public static void putSign(int row, int col, String player, String[][] board) {
         board[row-1][col-1] = player;
    }

    //проверка занятости клетки
    public static boolean isBusy(int row, int col, String[][] board) {
        return !board[row-1][col-1].equals("   ");
    }

    //проверка победной комбинации
    public static boolean isWinningCombination(String a, String b, String c) {
        return !a.equals("   ") && a.equals(b) && a.equals(c);
    }

    // проверка есть ли на поле выигрышная комбинация
    public static boolean isVictory(String[][] board) {
        //строки
        for (int i = 0; i < 3; i++) {
            if (isWinningCombination(board[i][0], board[i][1], board[i][2])) return true;
        }
        //столбцы
        for (int j = 0; j < 3; j++) {
            if (isWinningCombination(board[0][j], board[1][j], board[2][j])) return true;
        }
        //главная диагональ
        if (isWinningCombination(board[0][0], board[1][1], board[2][2])) return true;
        //побочная диагональ
        if (isWinningCombination(board[0][2], board[1][1], board[2][0])) return true;

        return false;
    }

    //генерирует ход искусственного интеллекта
    public static int[] moveAI(String[][] board) {
        System.out.println("Ход искусственного интеллекта!");
        int row, col;
        do {
            row = getRandomCoordinate();
            col = getRandomCoordinate();
        }while (isBusy(row, col, board));

        return new int[]{row, col};
    }

    //возвращает случайное число от 1 до 3
    public static int getRandomCoordinate() {
        return new Random().nextInt(1,4);
    }

    //получает ход игрока
    public static int[] movePlayer(String[][] board, Scanner input) {
        int row, col;

        do {
            System.out.println("Введите координаты строки и столбца(два числа от 1 до 3 через пробел):");
            if (!input.hasNextInt()) {
                System.out.println("Ошибка! Введите число.");
                input.nextLine();
                continue;
            }
            row = input.nextInt();
            if (!input.hasNextInt()) {
                System.out.println("Ошибка! Введите число.");
                input.nextLine();
                continue;
            }
            col = input.nextInt();
            input.nextLine();
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Ошибка! Координаты должны быть числа от 1 до 3. Попробуйте еще раз.");
            }
            else if (isBusy(row, col, board)) {
                System.out.println("Эта клетка уже занята! Выберите другую.");
            }
            else break;
        }while (true);

        return new int[]{row, col};
    }
}
