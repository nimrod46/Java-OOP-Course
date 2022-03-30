package Lab04;

public class Cat extends Feline {

    private final boolean spayed;

    public Cat(double weight, int gestation) {
        this(weight, gestation, false);
    }

    public Cat(double weight, int gestation, boolean isSpotted) {
        this(weight, gestation, isSpotted, false);
    }

    /**
     * constructor
     *
     * @param weight    - weight of the mammal
     * @param gestation - duration of pregnancy in days (can't be change after initialization)
     * @param isSpotted - does it has spots (can't be change after initialization)
     * @param spayed  - is it spayed (can be change just once to true)
     */
    public Cat(double weight, int gestation, boolean isSpotted, boolean spayed) {
        super(weight, gestation, isSpotted);

        this.spayed = spayed;
    }

    public void scratch() {

    }

    public boolean isSpayed() {
        return spayed;
    }
}
