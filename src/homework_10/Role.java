package homework_10;

public class Role implements Cloneable{
    private String name;

    public Role(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public Role clone() throws CloneNotSupportedException {
        return (Role) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
