package Lab07;

public class Lab07Test {

    public static void main(String[] args) {
        Cities cities = new Cities();
        cities.init("cities.txt");
        cities.listAlphabetically();
        cities.listByCountry("China");
        cities.listByPopulation();
        cities.listByDensity();
    }
}
