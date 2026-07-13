package homework_7.clinic;

//Хирург
public class Surgeon extends Doctor {
    //конструктор
    public Surgeon(String surname, String name) {
        super(surname, name);
    }

    //метод лечить
    @Override
    public void treat() {
        System.out.println("Хирург " + getSurname() + " " + getName() + " оперирует...");
    }
}
