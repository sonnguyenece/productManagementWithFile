import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManagement {
    private ArrayList<Product> listProducts;

    ProductManagement() {
        listProducts = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        listProducts.add(product);
    }

    public void sortByName() {
        Collections.sort(listProducts);
    }

    public void sortFromLowestPrice() {
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return (int) ((product.getPrice() - (t1.getPrice())) * 100);
            }
        });
    }

    public void sortFromHighestPrice() {
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return -(int) ((product.getPrice() - (t1.getPrice()))* 100);
            }
        });
//        display();
    }

    public void sortByProduction() {
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return product.getProduction().compareTo(t1.getProduction());
            }
        });
//        display();
    }

    public void editWithId(String editID, String newID, String newName, String newProduction, float newPrice, String newDescription) {
        for (int i = 0; i < listProducts.size(); i++) {
            Product product = listProducts.get(i);
            if (product.getProductID().compareTo(editID) == 0) {
                product.setName(newName);
                product.setDescription(newDescription);
                product.setPrice(newPrice);
                product.setProductID(newID);
                product.setProduction(newProduction);
                System.out.println("Change completed");
                return;
            }
        }
        System.out.println("Can't find that ID!");
    }

    public void removeWithId(String removeID) {
        for (int i = 0; i < listProducts.size(); i++) {
            Product product = listProducts.get(i);
            if (product.getProductID().compareTo(removeID) == 0) {
                listProducts.remove(i);
            }
        }
    }

    public String searchByID(String searchID) {
        Product product = new Product();
        boolean checkID = false;
        String display = (String.format("%-5s%-8s%-6s%-6s%-12s%-8s\n", "No.", "Name", "ID", "Price", "Productor", "Description"));
        for (int i = 0; i < listProducts.size(); i++) {
            product = listProducts.get(i);
            if (product.getProductID().compareTo(searchID) == 0) {
                display += " " + (i + 1) + "   " + product.toString();
                checkID = true;
            }
        }
        if (!checkID) return "Can't find that ID!";
        return display;
    }

    public String searchByName(String name) {
        Product product = new Product();
        boolean checkName = false;
        String display = (String.format("%-5s%-8s%-6s%-6s%-12s%-8s\n", "No.", "Name", "ID", "Price", "Productor", "Description"));
        for (int i = 0; i < listProducts.size(); i++) {
            product = listProducts.get(i);
            if (product.getName().contains(name)) {
                display += " " + (i + 1) + "   " + product.toString();
                checkName = true;
            }
        }
        if (!checkName) return "Can't find that name";
        return display;
    }

    public void display() {
        for (Product product : listProducts) {
            System.out.printf("%-8s%-6s%-8.2f%-11s%-8s\n", product.getName(), product.getProductID(), product.getPrice(), product.getProduction(), product.getDescription());
        }
    }

    @Override
    public String toString() {
        String display = String.format("%-5s%-8s%-6s%-6s%-12s%-8s\n", "No.", "Name", "ID", "Price", "Productor", "Description");
        for (int i = 0; i < listProducts.size(); i++) {

            display += String.format(" %-4d%-8s%-6s%-8.2f%-11s%-8s\n", (i + 1), listProducts.get(i).getName(), listProducts.get(i).getProductID(), listProducts.get(i).getPrice(), listProducts.get(i).getProduction(), listProducts.get(i).getDescription());
        }
        return display;
    }
}

