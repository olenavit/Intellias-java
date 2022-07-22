package com.intellias.vitkovska;

public class Product {
    private final String id;
    private final String name;
    private final Double price;

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name);
        sb.append("{");
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
