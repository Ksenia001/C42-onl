package homework_15.Animals;

import java.util.LinkedList;

public class Animals {
    private LinkedList<String> animals = new LinkedList<>();

    public Animals() {}

    public void addAnimal(String animal) {
        animals.addFirst(animal);
    }
    public void deleteAnimal() {
        if (!animals.isEmpty()) {
            animals.removeLast();
        }
    }
    @Override
    public String toString() {
        return animals.toString();
    }
}
