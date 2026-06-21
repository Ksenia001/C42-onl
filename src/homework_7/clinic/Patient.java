package homework_7.clinic;

public class Patient {
    private String name;            //имя
    private String surname;         //фамилия
    private int treatmentPlan;      //план лечения
    private Doctor doctor;          //доктор

    //конструктор
    Patient(String surname, String name, int treatmentPlan) {
        this.name = name;
        this.surname = surname;
        this.treatmentPlan = treatmentPlan;
    }

    //геттеры
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getTreatmentPlan() {
        return treatmentPlan;
    }
    public Doctor getDoctor() {
        return doctor;
    }

    //сеттеры
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setTreatmentPlan(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
