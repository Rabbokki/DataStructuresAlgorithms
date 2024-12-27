package vendingMachineV3.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductDto {
    private int pId;
    private String productName;
    private int price;
    private int stock;
    private boolean status = true;

//    private LocalDateTime createdAt;
//    private LocalDateTime updateAt;

    public ProductDto() {
    }

    public ProductDto(int pId, String productName, int price, int stock, boolean status) {
        this.pId = pId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
//        String createDate = createdAt.format(
//                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//        String updateDate = "";
//        if(updateAt != null){
//            updateDate = updateAt.format(
//                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//        }
        String str = String.format("%d \t %s \t %d \t %d \t %b \t \t ",
                pId, productName, price, stock, status);

        return str;
    }
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(LocalDateTime updateAt) {
//        this.updateAt = updateAt;
//    }

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
