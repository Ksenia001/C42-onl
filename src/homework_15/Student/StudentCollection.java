package homework_15.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentCollection {
    private List<Student> students = new LinkedList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }

    public void expel() {
        if (students.isEmpty()) {
            return;
        }

        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public void printStudents(List<Student> students, int course){
        System.out.println("Студенты " + course + "курса:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.toString());
            }
        }
    }
}
