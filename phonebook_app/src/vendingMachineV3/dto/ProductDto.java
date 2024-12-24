package vendingMachineV3.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductDto {
    private int pId;
    private String productName;
    private int price;
    private int stock;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @Override
    public String toString() {
        String createDate = createdAt.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String updateDate = "";
        if(updateAt != null){
            updateDate = updateAt.format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }
        String str = String.format("%l \t %s \t %d \t %d \t \t" ,
                pId, productName, price, stock , createDate, updateDate);

        return str;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
