package homework_7.clinic;
//Создать программу для имитации работы клиники. Пусть в клинике будет три врача:
//хирург, терапевт и дантист. Каждый врач имеет метод «лечить», но каждый врач лечит
//по-своему. Так же предусмотреть класс «Пациент» с полем «План лечения» и полем
//«Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения. У
//терапевта создать метод, который будет назначать врача пациенту согласно плану
//лечения:
//Если план лечения имеет код 1 – назначить хирурга и выполнить метод лечить.
//Если план лечения имеет код 2 – назначить дантиста и выполнить метод лечить.
//Если план лечения имеет любой другой код – назначить терапевта и выполнить метод
//лечить.
public class ClinicMain {
    public static void main(String[] args) {
        Dentist dentist = new Dentist("Сидоров", "Семён");
        Surgeon surgeon = new Surgeon("Петров","Петр");
        Therapist therapist = new Therapist("Иванов", "Иван");

        System.out.println("Лечение пациентов:");

        Patient patient1 = new Patient("Михайлович", "Михаил", 1);
        therapist.prescribeTreatment(patient1, dentist, surgeon, therapist);

        Patient patient2 = new Patient("Дмитриевич","Дмитрий", 2);
        therapist.prescribeTreatment(patient2, dentist, surgeon, therapist);

        Patient patient3 = new Patient("Павлович", "Павел", 3);
        therapist.prescribeTreatment(patient3, dentist, surgeon, therapist);
    }
}
