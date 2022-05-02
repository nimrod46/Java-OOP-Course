package Lab07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Cities {

    private final SortedSet<City> cityList;

    public Cities() {
        this.cityList = new TreeSet<>();
    }

    public void init(String fileName) {

        FileReader file = null;
        try {
            file = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[\n\t]");
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            String country = scanner.next();
            int population = scanner.nextInt();
            int area = scanner.nextInt();
            City city = new City(name, country, population, area);
            cityList.add(city);
            scanner.nextLine();
        }

    }

    public void listAlphabetically() {
        System.out.println();
        System.out.println("City list");
        System.out.println();

        for (City city : cityList) {
            formatPrint(null,city.getName(), city.getCountry(), city.getPopulation(), city.getArea());
        }
    }

    public void listByCountry(String country) {
        System.out.println();
        System.out.printf("Cities in %s:\n", country);
        System.out.println();

        for (City city : cityList.stream().filter(c -> c.getCountry().equals(country)).collect(Collectors.toList())) {
            formatPrint(null,city.getName(), city.getCountry(), city.getPopulation(), city.getArea());
        }
    }

    public void listByPopulation() {
        System.out.println();
        System.out.println("City list by population");
        System.out.println();

        for (City city : cityList.stream().sorted(Collections.reverseOrder(Comparator.comparingInt(City::getPopulation)))
                .collect(Collectors.toList())) {
            formatPrint(null,city.getName(), city.getCountry(), city.getPopulation(), city.getArea());
            //System.out.printf("%s(%s) population: %d area: %d\n", city.getName(), city.getCountry(), city.getPopulation(), city.getArea());
        }
    }

    public void listByDensity() {
        System.out.println();
        System.out.println("City list by density");
        System.out.println();

        for (City city : cityList.stream().sorted(Comparator.comparingInt(value -> value.getPopulation() / value.getArea()))
                .collect(Collectors.toList())) {
            formatPrint(" density: %d\n",city.getName(), city.getCountry(),
                    city.getPopulation(), city.getArea(), city.getPopulation() / city.getArea());
        }
    }

    private static void listCities(String title, List<City> cities) {
        System.out.println();
        System.out.println(title);
        System.out.println();
        for (City city : cities) {
            formatPrint(null,city.getName(), city.getCountry(), city.getPopulation(), city.getArea());
        }
    }

    private static void formatPrint(String ext, Object... params) {
        if(ext == null || ext.trim().isEmpty()) {
            ext = "\n";
        }
        System.out.printf("%s(%s) population: %d area: %d" + ext, params);
    }
}
