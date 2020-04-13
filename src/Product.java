public class Product implements Comparable<Product> {
    private String productID;
    private String name;
    private String productor;
    private float price;
    private String description;

    Product() {

    }

    Product(String productID, String name, String productor, float price, String description) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productor = productor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProduction(String production) {
        this.productor = production;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getProductID() {
        return productID;
    }

    public String getProduction() {
        return productor;
    }

    @Override
    public int compareTo(Product product) {
        return this.getName().compareTo(product.getName());
    }

    public void display() {
        System.out.printf("%-8s%-6s%-8.2f%-11s%-8s\n", this.getName(), this.getProductID(), this.getPrice(), this.getProduction(), this.getDescription());
    }

    @Override
    public String toString() {
        return String.format("%-8s%-6s%-8.2f%-11s%-8s\n", this.getName(), this.getProductID(), this.getPrice(), this.getProduction(), this.getDescription());
    }
}
