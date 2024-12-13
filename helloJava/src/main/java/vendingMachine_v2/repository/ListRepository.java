package vendingMachine_v2.repository;

import vendingMachine_v2.myInterface.ArrayListInterface;
import vendingMachine_v2.vo.Product;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements ArrayListInterface {

    //상품목록(상품명,금액,재고) 정보를 담는 저장공간

    List<Product> productList = new ArrayList<>();

    @Override
    public int findIndex(String name) {
        for (Product p : productList) {
            if(p.getItem().equals(name)){
                return productList.indexOf(p);
            }
        }

        return -1;
    }

    @Override
    public boolean insert(Product product) {
        productList.add(product);
        System.out.println(productList);
        return true;
    }

    @Override
    public boolean update(int idx, Product product) {
        productList.set(idx,product);
        return true;
    }

    @Override
    public boolean delete(int idx) {
        productList.remove(idx);
        return false;
    }

    @Override
    public Product findByName(String name) {
        for (Product p : productList) {
            if(p.getItem().equals(name)){
                return p;
            }
        }
        return null;

    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
