package homework_9.lesson_3;

public class DocumentMain {

    public static void main(String[] args) {

        Document original = new Document("Project plan", "John Smith", 1);

        Document clone = original.clone();
        clone.setVersion(clone.getVersion() + 1);

        System.out.println("Original: " + original);
        System.out.println("Clone: " + clone);
        System.out.println("Independent: " + (original != clone));
    }


}
