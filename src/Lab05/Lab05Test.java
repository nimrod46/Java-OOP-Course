package Lab05;

public class Lab05Test {

    public static void main(String[] args) {
        Circle c = new Circle(5);
        Prism p = new Prism(c, 4);
        System.out.println(p);
        System.out.println(c);
    }
}
