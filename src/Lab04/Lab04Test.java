package Lab04;

public class Lab04Test {
    public static void main(String[] args) {
        Mammal m = new Leopard(50, 25, true, 20);
        m.lactate();

        Cat c = new Cat(15, 60, true);
        c.scratch();

        Canine cn = new Canine(50, 90);
        cn.wail();

        Dog d = new Dog(45, 60, true, "Doggy", 4);
        d.bark();
        d.bark();
        d.lactate();
    }
}
