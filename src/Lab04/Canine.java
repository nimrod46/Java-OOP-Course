package Lab04;

public class Canine extends Mammal {

    private boolean vac;

    public Canine(double weight, int gestation) {
        this(weight, gestation, false);
    }

    /**
     * constructor
     *
     * @param weight    - weight of the mammal
     * @param gestation - duration of pregnancy in days (can't be change after initialization)
     * @param vac       - is it vaccinated
     */
    public Canine(double weight, int gestation, boolean vac) {
        super(weight, gestation);
        this.vac = vac;
    }

    public void wail() {

    }

    public boolean isVac() {
        return vac;
    }

    public void setVac(boolean vac) {
        this.vac = vac;
    }
}
