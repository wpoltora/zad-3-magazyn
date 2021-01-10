package pl.edu.wszib.magazyn.model;


public class Product {
    private int id;
    private String name;
    private double price;
    private int pieces;

    public Product(int id, String name, double price, int pieces) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pieces = pieces;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public Product clone() {
        return new Product(this.id, this.name, this.price, this.pieces);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pieces=" + pieces +
                '}';
    }
}


