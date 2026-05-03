public class MyTestingClass {
    int id;
    String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id * 31 + name.length();
    }
}