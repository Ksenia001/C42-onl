package homework_9.lesson_3;

class Document implements Cloneable{
    private String title;
    private String author;
    private int version;

    Document(String title, String author, int version) {
        this.title = title;
        this.author = author;
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public Document clone(){
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return String.format("Document[title=%s, author=%s, version=%s]", title, author, version);
    }
}
