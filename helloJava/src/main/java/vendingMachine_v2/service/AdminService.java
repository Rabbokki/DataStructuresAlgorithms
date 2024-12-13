package vendingMachine_v2.service;

import vendingMachine_v2.repository.ListRepository;
import vendingMachine_v2.vo.Product;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    ListRepository repository = new ListRepository();

    public void insertItem(Product product) {
        repository.insert(product);
    }

    public List<Product> getAllList() {
        List<Product> productList = new ArrayList<>();
        productList = repository.findAll();
        return productList;
//        return List<Product> productList = repository.findAll();
    }

    public boolean deleteItem(String itemName) {
        //1. itemName이 존재하는지 확인
        int index = repository.findIndex(itemName);

        //2. 존재하면 삭제 요청 후 true 아니면 false
        if(index != -1){
            repository.delete(index);
            return true;
        }else {

            return false;
        }
    }

    public boolean updateStock(String itemName, int updateStock) {
        int idx = repository.findIndex(itemName);
        if (idx != -1){
            //수정 할 제품 찾기
            Product findProduct = repository.findByName(itemName);
            //재고 수정하기
            int updateValue = findProduct.getStock() + updateStock;
            findProduct.setStock(updateValue);
            //수정 요청
            repository.update(idx,findProduct);
            return true;
        }else {
            return false;
        }
    }

    public void updateMenu(String productName, String newItem, int newPrice,int newStock) {
        Product findProduct = repository.findByName(productName);
        deleteItem(findProduct.getItem());
        insertItem(new Product(newItem, newPrice, newStock));
        getAllList();

    }

}
