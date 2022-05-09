package Lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab08Test {
    public static void main(String[] args) throws FileNotFoundException {
        StoreHouse storeHouse = new StoreHouse();
        File input = new File(args[0]);
        Scanner reader = new Scanner(input);
        reader.useDelimiter("\\s+");
        Set<Product> products = new HashSet<>();
        while (reader.hasNextLine()) {
            String cmd = reader.next();
            String productName = reader.next();
            int quantity = reader.nextInt();

            switch (cmd) {
                case "define":
                    products.add(new Product(productName, quantity));
                    System.out.println("Defined product: " + productName);
                    break;
                case "order":
                    var prod = products.stream().filter(o -> o.getName().equals(productName)).findFirst();
                    if(prod.isEmpty()) {
                        System.out.println("Unknown product " + productName);
                        continue;
                    }
                    try {
                        storeHouse.order(prod.get(), quantity);
                        System.out.println("Ordered " + quantity + " " + productName);
                        System.out.println(storeHouse);
                        System.out.println();
                    } catch (OverStockException e) {
                        System.out.println(e);
                    }
                    break;
                case "supply":
                    prod = products.stream().filter(o -> o.getName().equals(productName)).findFirst();
                    if(prod.isEmpty()) {
                        System.out.println("Unknown product " + productName);
                        continue;
                    }
                    try {
                        storeHouse.supply(prod.get(), quantity);
                        System.out.println("Supplied " + quantity + " " + productName);
                        System.out.println(storeHouse);
                        System.out.println();
                    } catch (OutOfStockException e) {
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("Unrecognized operation: " + cmd);
                    System.out.println();
                    break;
            }
            if(reader.hasNextLine()) {
                reader.nextLine();
            }
        }
    }
}
