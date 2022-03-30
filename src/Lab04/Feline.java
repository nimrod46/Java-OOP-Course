package Lab04;

public class Feline extends Mammal {

    private final boolean spots;

    public Feline(double weight, int gestation) {
        this(weight, gestation, false);
    }

    /**
     * constructor
     *
     * @param weight    - weight of the mammal
     * @param gestation - duration of pregnancy in days (can't be change after initialization)
     * @param spots - does it has spots (can't be change after initialization)
     */
    public Feline(double weight, int gestation, boolean spots) {
        super(weight, gestation);
        this.spots = spots;
    }

    public boolean isSpotted() {
        return spots;
    }
}
