package vendingMachine_v2.vo;

public class Product {
    private String item;
    private int price;
    private int stock;

    @Override
    public String toString() {
        return "product{" +
                "item : '" + item + '\'' +
                ", price : " + price +
                ", stock : " + stock +
                '}';
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
