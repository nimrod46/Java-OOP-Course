package Lab04;

public class Dog extends Canine {

    private String name;
    private int fleas;

    public Dog(double weight, int gestation) {
        this(weight, gestation, false, "", 0);
    }

    public Dog(double weight, int gestation, boolean vac) {
        this(weight, gestation, vac, "", 0);
    }

    /**
     * constructor
     *
     * @param weight    - weight of the mammal
     * @param gestation - duration of pregnancy in days (can't be change after initialization)
     * @param vac       - is it vaccinated
     * @param name      - name of the dog
     * @param fleas     - number of fleas
     */
    public Dog(double weight, int gestation, boolean vac, String name, int fleas) {
        super(weight, gestation, vac);
        this.name = name;
        this.fleas = fleas;
    }

    public void bark() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFleas() {
        return fleas;
    }

    public void setFleas(int fleas) {
        this.fleas = fleas;
    }
}
