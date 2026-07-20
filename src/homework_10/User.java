package homework_10;

import java.util.Objects;
//Задание 1
//Создать класс для описания пользователя системы. Переопределить в классе методы
//toString, hashcode и equals. Создать несколько экземпляров класса с одним и тем же
//значением полей и сравнить с помощью метода equals.
//Задание *
//Создать программу для реализации поверхностного и глубокого клонирования объекта
//класса User. Пусть на вход программе будет передаваться тип операции клонирования
//(поверхностное клонирование или глубокое), а также id юзера для клонирования

public class User implements Cloneable {
    private int id;

    private String username;
    private String password;
    private String email;
    private Role role;

    public User(int id, String username, String password, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User shallowClone(){
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public User deepClone(){
        try {
            User newUser = (User) super.clone();
            Role newRole = this.getRole().clone();
            newUser.setRole(newRole);
            return newUser;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                                   //если является тем же объектом
        if (obj == null || getClass() != obj.getClass()) return false;  //если не совпадает тип
        User user = (User) obj;
        return Objects.equals(username, user.username)
                && Objects.equals(password, user.password)
                && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email); //генерирует хеш код на основе полей
    }

    public Role getRole() {
        return this.role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static User getUserById(int id, User[] users) {
        for (User u : users) {
            if (u.id == id) return u;
        }
        return null;
    }
}