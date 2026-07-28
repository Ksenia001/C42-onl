package homework_7.clinic;

//Дантист
public class Dentist extends Doctor {

    //конструктор
    public Dentist(String surname, String name) {
        super(surname, name);
    }

    //метод лечить
    @Override
    public void treat() {
        System.out.println("Дантист " + getSurname() + " " + getName() + " лечит зубы...");
    }
}
