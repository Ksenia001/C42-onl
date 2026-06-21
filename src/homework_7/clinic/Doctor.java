package homework_7.clinic;

public class Doctor {
    private String name;        //имя
    private String surname;     //фамилия

    //конструктор
    Doctor(String surname, String name) {
        this.name = name;
        this.surname = surname;
    }

    //метод лечить
    public void treat() {
        System.out.println("Доктор " + getSurname() + " " + getName() + " лечит...");
    }

    //геттеры
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
}
