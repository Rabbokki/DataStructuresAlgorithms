package vendingMachine_v2.vo;

public class Product {
    private String item;
    private int price;
    private int stock;

    public Product() {}

    public Product(String item, int price, int stock) {
        this.item = item;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "제품명 : " + item  + "/ 가격 : " + price +
                ", 재고 : " + stock;
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
