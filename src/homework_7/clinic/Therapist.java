package homework_7.clinic;

//Терапевт
public class Therapist extends Doctor {

    //конструктор
    public Therapist(String surname,String name) {
        super(surname, name);
    }

    //метод лечить
    @Override
    public void treat() {
        System.out.println("Терапевт " + getSurname() + " " + getName() + " делает осмотр и назначает лечение...");
    }

    //назначение врача согласно плану лечения
    public void prescribeTreatment(Patient patient, Dentist dentist, Surgeon surgeon, Therapist therapist) {
        Doctor doctor;
        if (patient.getTreatmentPlan() == 1) {
            doctor = surgeon;
        }
        else if (patient.getTreatmentPlan() == 2) {
            doctor = dentist;
        }
        else {
            doctor = therapist;
        }

        patient.setDoctor(doctor);
        doctor.treat();
    }
}
