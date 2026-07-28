package homework_7.clinic;

public class Patient {
    private String name;            //имя
    private String surname;         //фамилия
    private int treatmentPlan;      //план лечения
    private Doctor doctor;          //доктор

    //конструктор
    public Patient(String surname, String name, int treatmentPlan) {
        this.name = name;
        this.surname = surname;
        this.treatmentPlan = treatmentPlan;
    }

    //геттеры
    public String getName() {
        return name;
    }
    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    //сеттеры
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
