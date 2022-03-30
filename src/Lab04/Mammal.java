package Lab04;

public class Mammal {

    private final int gestation;
    private double weight;

    /**
     * constructor
     *
     * @param weight    - weight of the mammal
     * @param gestation - duration of pregnancy in days (can't be change after initialization)
     */
    public Mammal(double weight, int gestation) {
        this.weight = weight;
        this.gestation = gestation;
    }

    public void lactate() {

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getGestation() {
        return gestation;
    }
}
