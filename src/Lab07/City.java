package Lab07;

public class City implements Comparable<City> {

    private final String name;
    private final String country;

    private int population;
    private int area;

    public City(String name, String country, int population, int area) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.area = area;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    @Override
    public int compareTo(City o) {
        return name.compareTo(o.name);
    }
}
