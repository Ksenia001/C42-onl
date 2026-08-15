package homework_15.Student;

import java.util.Arrays;
import java.util.List;

//Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
//оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
//Написать метод, который удаляет студентов со средним баллом <3. Если средний
//балл>=3, студент переводится на следующий курс. Дополнительно написать метод
//printStudents(List<Student> students, int course), который получает список студентов и
//номер курса. А также печатает на консоль имена тех студентов из списка, которые
//обучаются на данном курсе.
public class StudentMain {
    public static void main(String[] args) {
        StudentCollection sc = new StudentCollection();

        sc.addStudent(new Student("Евгений", 333333, 1, Arrays.asList(5, 4, 4, 5)));
        sc.addStudent(new Student("Иван", 333333, 1, Arrays.asList(2, 2, 3, 2)));
        sc.addStudent(new Student("Григорий", 444444, 2, Arrays.asList(4, 5, 4, 4)));
        sc.addStudent(new Student("Игорь", 555555, 2, Arrays.asList(3, 3, 4, 3)));
        sc.addStudent(new Student("Андрей", 880055, 1, Arrays.asList(5, 5, 5, 5)));
        sc.addStudent(new Student("Михаил", 353535, 4, Arrays.asList(4, 4, 4, 4)));
        sc.addStudent(new Student("Артём", 111111, 3, Arrays.asList(2, 2, 2, 2)));

        System.out.println("\nДо отчисления:");
        sc.printStudents(sc.getStudents(), 1);
        sc.expel();

        System.out.println("\nПосле отчисления:");
        sc.printStudents(sc.getStudents(), 2);
    }
}
