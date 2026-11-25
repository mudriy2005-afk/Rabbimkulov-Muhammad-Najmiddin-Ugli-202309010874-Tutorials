public class Main {
    public static void main(String[] args) {
        Person p0 = new Person("Ali", "P001");
        Person p1 = new Student("Muhammad", "S001");
        Person p2 = new Lecturer("Dr. Karim", "L001");

        p0.introduce();
        p1.introduce();
        p2.introduce();
    }
}