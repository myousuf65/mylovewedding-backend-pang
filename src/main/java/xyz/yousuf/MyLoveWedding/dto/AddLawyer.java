package xyz.yousuf.MyLoveWedding.dto;

public class AddLawyer {
    private String name;
    private int price;

    public AddLawyer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AddLawyer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
} 