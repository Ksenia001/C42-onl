package homework_10;

//Задание 1
//Создать класс для описания пользователя системы. Переопределить в классе методы
//toString, hashcode и equals. Создать несколько экземпляров класса с одним и тем же
//значением полей и сравнить с помощью метода equals.
//Задание *
//Создать программу для реализации поверхностного и глубокого клонирования объекта
//класса User. Пусть на вход программе будет передаваться тип операции клонирования
//(поверхностное клонирование или глубокое), а также id юзера для клонирования

import java.util.Scanner;

import static homework_10.User.getUserById;

public class UserMain {
    public static void main(String[] args) {
        Role user = new Role("User");
        Role admin = new Role("admin");

        User user1 = new User(1,"Standart user", "123456", "user7986541.mail.com", user);
        User user2 = new User(2,"unStandart user", "653421", "user1456897.mail.com", user);
        User imposter = new User(3,"Standart user", "123456", "user7986541.mail.com", user);
        User admin1 = new User(4,"admin", "111111", "admin@mail.com", admin);

        //задание 1
        isEqual(user1, user2);
        isEqual(user1, imposter);
        isEqual(user1, admin1);

        System.out.println("-".repeat(100));

        //задание со *
        User[] users = {user1, user2, imposter, admin1};

        User shallowUser = makeClone(1, "shallow",  users);
        if (shallowUser != null) {
            System.out.println("Поверхносный клон создан!");
            System.out.println(shallowUser);
        }
        User deepUser = makeClone(2, "deep",  users);
        if (deepUser != null) {
            System.out.println("Глубокий клон создан!");
            System.out.println(deepUser);
        }
    }

    public static void isEqual(User user1, User user2) {
        System.out.println(user1+" equals "+user2+": "+user1.equals(user2));
    }

    public static User makeClone(int id, String typeClone, User[] users) {
        Scanner scanner = new Scanner(System.in);
        User original = getUserById(id, users);

        if (original == null) {
            System.out.println("Пользователь с ID " + id + " не найден.");
            return null;
        }

        System.out.print("Введите новый ID для клона: ");
        int newId = scanner.nextInt();
        scanner.nextLine();

        User cloneUser;

        if (typeClone.equalsIgnoreCase("shallow")) {
            cloneUser = original.shallowClone();
        } else if (typeClone.equalsIgnoreCase("deep")) {
            cloneUser = original.deepClone();
        } else {
            System.out.println("Неизвестный тип клонирования.");
            return null;
        }

        if (cloneUser != null) {
            cloneUser.setId(newId);
        }
        return cloneUser;
    }
}
