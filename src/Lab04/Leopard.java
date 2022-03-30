package Lab04;

public class Leopard extends Feline {

    private int mates;

    public Leopard(double weight, int gestation) {
        this(weight, gestation, false, 0);
    }

    public Leopard(double weight, int gestation, boolean isSpotted) {
        this(weight, gestation, isSpotted, 0);
    }

    /**
     * constructor
     *
     * @param weight    - weight of the mammal
     * @param gestation - duration of pregnancy in days (can't be change after initialization)
     * @param spots     - does it has spots (can't be change after initialization)
     * @param mates     - how many friends
     */
    public Leopard(double weight, int gestation, boolean spots, int mates) {
        super(weight, gestation, spots);
        this.mates = mates;
    }

    public void roar() {

    }

    public void prey() {

    }

    public int getMates() {
        return mates;
    }

    public void setMates(int mates) {
        this.mates = mates;
    }
}
