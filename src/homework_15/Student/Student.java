package homework_15.Student;

import java.util.LinkedList;
import java.util.List;

public class Student {
    private String name;
    private int group;
    private int course;
    private LinkedList<Integer> grades;

    public Student(String name, int group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades != null ? new LinkedList<>(grades) : new LinkedList<>();
    }

    public void setCourse(int course){
        this.course = course;
    }
    public int getCourse(){
        return this.course;
    }

    public double getAverageGrade(){
        if (this.grades.isEmpty()){
            return 0.0;
        }
        int sum = 0;
        for(Integer grade : grades){
            sum += grade;
        }
        return (double) sum/grades.size();
    }
    @Override
    public String toString() {
        return "Студент [Имя=" + name + ", группа=" + group + ", курс=" + course + ", оценки=" + grades + "]";
    }
}
